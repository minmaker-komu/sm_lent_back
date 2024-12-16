package com.example.smLent.service;

import com.example.smLent.domain.Member;
import com.example.smLent.dto.LoginRequestDto;
import com.example.smLent.dto.LoginResponseDto;
import com.example.smLent.dto.MemberDto;
import com.example.smLent.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public void signUp(MemberDto memberDto) {
        Optional<Member> existingMember = memberRepository.findByUsername(memberDto.getUsername());
        if (existingMember.isPresent()) {
            throw new RuntimeException("이미 존재하는 사용자 이름입니다.");
        }

        Member member = new Member();
        member.setUsername(memberDto.getUsername());
        member.setPassword(memberDto.getPassword()); // 암호화 없이 저장
        memberRepository.save(member);
    }

    /**
     * 로그인
     */
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        Member member = memberRepository.findByUsername(loginRequestDto.getUsername())
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));

        if (!loginRequestDto.getPassword().equals(member.getPassword())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }

        return new LoginResponseDto(null, "로그인 성공"); // 토큰 없이 로그인 성공 메시지만 반환
    }
}

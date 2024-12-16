package com.example.smLent.controller;

import com.example.smLent.dto.LoginRequestDto;
import com.example.smLent.dto.LoginResponseDto;
import com.example.smLent.dto.MemberDto;
import com.example.smLent.service.MemberService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 회원가입
    @PostMapping("/signup")
    public String signUp(@RequestBody MemberDto memberDto) {
        memberService.signUp(memberDto);
        return "회원가입 성공";
    }

    // 로그인
    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto) {
        return memberService.login(loginRequestDto);
    }
}

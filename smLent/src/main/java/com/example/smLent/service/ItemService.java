package com.example.smLent.service;

import com.example.smLent.domain.Item;
import com.example.smLent.dto.ItemDto;
import com.example.smLent.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public ItemDto addItem(ItemDto itemDto) {
        Item item = new Item();
        item.setName(itemDto.getName());
        item.setPrice(itemDto.getPrice());
        item.setSpecialNote(itemDto.getSpecialNote());

        Item savedItem = itemRepository.save(item);

        itemDto.setId(savedItem.getId());
        return itemDto;
    }
}

package com.example.spring_practice.controller;

import com.example.spring_practice.entity.Items;
import com.example.spring_practice.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/items")
public class ItemController {
    private final ItemService itemService;

    @GetMapping(value = "/get")
    public List<Items> getAllItems() {
        return itemService.getAllItems();
    }

    @PostMapping(value = "/post")
    public String createItems(@RequestBody Items item) {
        return itemService.createItems(item);
    }

    @GetMapping(value = "/item")
    public List<Items> getItem(@RequestBody Items item) {
        return itemService.getItem(item.getExcludeType(), item.getRegId());
    }
}

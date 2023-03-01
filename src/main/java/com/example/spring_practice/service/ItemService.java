package com.example.spring_practice.service;

import com.example.spring_practice.entity.Items;
import com.example.spring_practice.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

//    public List<Items> getItems(Integer excludeType, String regId) {
//        if(excludeType == 1) {
//            // exclude Call 조회
//            return itemRepository.findItemsByExcludeType(1);
//        } else {
//            // exclude Name 조회
//            return itemRepository.findItemsByExcludeType(2);
//        }
//    }

    public List<Items> getAllItems() {
        return itemRepository.findAll();
    }

    public String createItems(Items item) {
        itemRepository.save(item);
        return "성공";
    }

    public List<Items> getItem(Integer type, String regId) {
        return itemRepository.findItemsByExcludeTypeAndRegId(type, regId);
    }
}

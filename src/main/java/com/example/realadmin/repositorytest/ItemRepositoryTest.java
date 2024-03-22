package com.example.realadmin.repositorytest;

import com.example.realadmin.repositroy.ItemRepository;
import com.example.realadmin.test.RealadminApplicationTests;
import com.example.realadmin.system.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ItemRepositoryTest extends RealadminApplicationTests{
    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create(){
        Item item = new Item();
        item.setStatus("UNREGISTERED");
        item.setName("삼성 노트북");
        item.setTitle("삼성 노트북 A100");
        item.setContent("2019년형 노트북입니다"); item.setPrice(BigDecimal.valueOf(900000));
        item.setBrandName("삼성");
        item.setRegisteredAt(LocalDateTime.now());
        item.setCreatedAt(LocalDateTime.now());
        item.setCreatedBy("Partner01");
        item.setPartnerId(1L);
        Item newItem = itemRepository.save(item); // item을 save시키면 새로운 아이템 newItem이 반환되 며
        Assertions.assertNotNull(newItem); // 그 newItem은 null값이 아니어야 함
        }
    @Test
    public void read(){
        Item item = itemRepository.findFirstByNameOrderByIdDesc("삼성 노트북");

    }
}






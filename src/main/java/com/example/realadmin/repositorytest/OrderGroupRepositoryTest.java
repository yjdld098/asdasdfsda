package com.example.realadmin.repositorytest;

import ch.qos.logback.classic.Level;
import com.example.realadmin.repositroy.OrderGroupRepository;
import com.example.realadmin.system.OrderGroup;
import com.example.realadmin.test.RealadminApplicationTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderGroupRepositoryTest extends RealadminApplicationTests {
    @Autowired
    private OrderGroupRepository orderGroupRepository;


    @Test
    public void create(){
        OrderGroup orderGroup = new OrderGroup();
        orderGroup.setStatus("COMPLETE");
        orderGroup.setOrderType("ALL");
        orderGroup.setRevAddress("서울시 강남구");
        orderGroup.setRevName("홍길동");
        orderGroup.setPaymentType("CARD");
        orderGroup.setTotalPrice(BigDecimal.valueOf(900000));
        orderGroup.setTotalQuantity(1);
        orderGroup.setOrderAt(LocalDateTime.now().minusDays(2));
        orderGroup.setArrivalDate(LocalDateTime.now());
        orderGroup.setCreatedAt(LocalDateTime.now());
        orderGroup.setCreatedBy("AdminServer"); orderGroup.setUserId(1L);
        OrderGroup newOrderGroup = orderGroupRepository.save(orderGroup);
        Assertions.assertNotNull(newOrderGroup);

    }
    @Test
    public void read(){
        OrderGroup orderGroup = orderGroupRepository.findFirstByRevAddressOrderByIdDesc("서울시 강남구");
    }
}

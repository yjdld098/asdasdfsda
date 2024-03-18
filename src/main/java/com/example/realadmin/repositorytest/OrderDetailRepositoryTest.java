package com.example.realadmin.repositorytest;

import com.example.realadmin.repositroy.OrderDetailRepository;
import com.example.realadmin.system.OrderGroup;
import com.example.realadmin.test.RealadminApplicationTests;
import com.example.realadmin.system.OrderDetail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.Optional;


public class OrderDetailRepositoryTest extends RealadminApplicationTests{

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void create(){

        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setStatus("WAITING");
        orderDetail.setArrivalDate(LocalDateTime.now().plusDays(2));
        orderDetail.setQuantity(1); orderDetail.setTotalPrice(BigDecimal.valueOf(900000));
        orderDetail.setOrderGroupId(1L); // 어떤 장바구니에
        orderDetail.setItemId(1L); // 어떤 상품인지
        orderDetail.setCreatedAt(LocalDateTime.now());
        orderDetail.setCreatedBy("AdminServer");
        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
        Assertions.assertNotNull(newOrderDetail);
    }
    @Test
    public void read(){
        Optional<OrderDetail> optionalOrderDetail = orderDetailRepository.findByItemId(1L);
    }
}

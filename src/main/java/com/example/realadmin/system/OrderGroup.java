package com.example.realadmin.system;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString(exclude = {"user", "orderDetailList"})
public class OrderGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private String orderType; //주문의 형태 - 일괄 / 개별
    private String revAddress;
    private String revName;
    private String paymentType; // 카드 / 현금
    private BigDecimal totalPrice;
    private Integer totalQuantity;
    private LocalDateTime orderAt;
    private LocalDateTime arrivalDate;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
    private Long userId;

    //OrderGroup : User = N:1
    @ManyToOne
    private User user; // 'user'는 User클레스에 있는 mappedBy에 있는 변수명과 일치해야함

    // OrderGroup : OrderDetail = 1 : N
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderGroup")
    private List<OrderDetail> orderDetailList;


}

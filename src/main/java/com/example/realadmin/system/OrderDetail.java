package com.example.realadmin.system;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.math.BigDecimal;

@Data
@NoArgsConstructor// 기본 생성자
@AllArgsConstructor //모든 매개변수를 가진 생성자
@Entity // 엔티티임을 명시, 자바는 카멜케이스 DB연결할 때는 스네이크케이스 이므로 order_detail에 자동을 연결
@ToString(exclude = {"orderGroup", "item"})
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String status;
    private LocalDateTime arrivalDate;
    private Integer quantity;
    private BigDecimal totalPrice;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
    private Long itemId;
    private Long orderGroupId;

    //OrderDetail : OrderGroup = N : 1
    @ManyToOne
    private OrderGroup orderGroup;

    //OrderDetail : Item = N : 1
    @ManyToOne
    private Item item;

}


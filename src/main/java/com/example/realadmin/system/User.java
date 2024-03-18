package com.example.realadmin.system;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;


@Data // 기본 생성자와 변수에 대해 get, set메서드 생성
@AllArgsConstructor // 모든 매개변수를 가진 생성자도 추가
@NoArgsConstructor //파라미터가 없는 생성자 생성
@Entity //Entity임을 선언 = table
@ToString(exclude = {"orderGroup"}) // OneToMany의 경우 상호참조시 오버플로우가 발생 -> exclude 시켜줌
@Builder // 빌더 생성자 패턴 -> 이해가 안가서 사용하지않았음
@Accessors(chain = true) // chaining된 형태로 객체를 생성하거나 수정 할 수 있음
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String account;
    private String password;
    private String status;
    private String email;
    private String phoneNumber;
    private LocalDateTime registeredAt;
    private LocalDateTime unregisteredAt;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;

    // User : OrderGroup = 1:N
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user") // user라는 맴버변수에 매칭시킴
    private List<OrderGroup> orderGroupList; // OneToMany이므로 List타입으로 바꿔줘야한다

    // OrderGroup : OrderDetail = 1 : N
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderGroup")
    private List<OrderDetail> orderDetailList;
}


package com.example.realadmin.system;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 전체 생성자
@Data
@Entity
@ToString(exclude = {"partnerList"})
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본적으로 mySQL은 IDENTITY를 사용함

    private Long id;
    private String type;
    private String title;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;

    //Category : Partner = 1 : N
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private List<Partner> partnerList;
}


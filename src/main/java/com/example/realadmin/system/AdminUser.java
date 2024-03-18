package com.example.realadmin.system;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@EntityListeners(AuditingEntityListener.class) // 해당 EntityListener는 AuditingEntityListener를 사용하겠다

public class AdminUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String account;
    private String password;
    private String status;
    private String role;
    private LocalDateTime lastLoginAt;
    private LocalDateTime passwordUpdatedAt;
    private int loginFailCount;
    private LocalDateTime registeredAt;
    private LocalDateTime unregisteredAt;

    @CreatedDate // 따로 지정하지 않더라도 해당 객체가 수정되면 자동으로 값이 채워짐
    private LocalDateTime createdAt;

    @CreatedBy // LoginUserAuditorAware에서 리턴하는 AdminServer를 반영함
    private String createdBy;

    @LastModifiedDate // 따로 지정하지 않더라도 해당 객체가 수정되면 자동으로 겂아 채워짐
    private LocalDateTime updatedAt;

    @LastModifiedBy // LoginUserAuditorAware에서 리턴하는 AdminServer를 반영함
    private String updatedBy;

}


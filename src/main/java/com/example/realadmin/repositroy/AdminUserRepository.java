package com.example.realadmin.repositroy;

import com.example.realadmin.system.AdminUser;
import com.example.realadmin.system.OrderGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {

    AdminUser findFirstByAccountOrderByIdDesc(String Account);
}

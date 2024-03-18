package com.example.realadmin.repositorytest;

import com.example.realadmin.repositroy.AdminUserRepository;
import com.example.realadmin.system.AdminUser;
import com.example.realadmin.test.RealadminApplicationTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class AdminUserRepositoryTest extends RealadminApplicationTests {
    @Autowired
    private AdminUserRepository adminUserRepository;

    @Test
    public void create(){
        AdminUser adminUser = new AdminUser();
        adminUser.setAccount("AdminUser01");
        adminUser.setPassword("AdminUser01");
        adminUser.setStatus("REGISTERED");
        adminUser.setRole("PARTNER");
        adminUser.setCreatedAt(LocalDateTime.now());
        adminUser.setCreatedBy("AdminServer");
        AdminUser newAdminUser = adminUserRepository.save(adminUser);
        Assertions.assertNotNull(newAdminUser);

    }
    @Test
    public void read(){
        AdminUser adminUser = adminUserRepository.findFirstByAccountOrderByIdDesc("AdminUser01");
    }


}

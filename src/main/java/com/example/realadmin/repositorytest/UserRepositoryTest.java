package com.example.realadmin.repositorytest;

import com.example.realadmin.repositroy.UserRepository;
import com.example.realadmin.system.User;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.springframework.data.jpa.domain.AbstractAuditable_.createdBy;

public class UserRepositoryTest extends StudyApplicationTests {
    // Dependency Injextion (DI)
    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){

        String accoount = "Test01";
        String password = "Test01";
        String status = "REGISTERED";
        String email = "TEST01@gmail.com";
        String phoneNumber = "010-1111-2222";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createBy = "AdminServer";

        //User 객체를 만들어준다.
        User user = new User();
        user.setAccount(accoount);
        user.SsetPassword(password);
        user.setStatus(status);
        user.setEmail.(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
        user.setCreatedAt(createdAt);
        user.setCreatedBy(createdBy);

        User newUser = userRepository.save(user); // sava를 통해 user의 내용을 newUser에 넣음
        Assertions.assertNotNull(newUser);

    }

    @Test
    @Transactional
    public void read(){
        User user = userRepository.findFirstByPhoneNumberOrdOrderByDesc("010-1111-2222");
        Assert.assertNotNull(user);
    }
}

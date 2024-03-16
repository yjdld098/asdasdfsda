package com.example.realadmin.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.realadmin.system.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long>{

    //FirstBy로 하면 가장 최근의 건을 반환함
    User findFirstByPhoneNumberOrdOrderByDesc(String phoneNumber);
}

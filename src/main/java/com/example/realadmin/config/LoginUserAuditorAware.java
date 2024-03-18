package com.example.realadmin.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;
import java.util.Optional;
public class LoginUserAuditorAware implements AuditorAware<String>{
    @Override
    public Optional<String> getCurrentAuditor(){
        return  Optional.of("AdminServer");
    }
}

// 이 클래스는 로그인 한 사용자를 감시하는 역할로 사용할 예정
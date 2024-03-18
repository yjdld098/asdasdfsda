package com.example.realadmin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration //이 파일에는 설정파일이 들어간다고 알려줌 -> 해당 클래스가 설정파일임을 알려주는 역할
@EnableJpaAuditing // JPA에 대해서 감시를 활성화시킴

public class JpaConfig {
}

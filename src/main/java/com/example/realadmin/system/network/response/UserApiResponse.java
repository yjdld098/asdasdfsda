package com.example.realadmin.system.network.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserApiResponse {

    private Long id;
    private String account;
    private String password;
    private String status;
    private String email;
    private String phoneNumber;
    private LocalDateTime registeredAt;
    private LocalDateTime unregisteredAt;
}
//requset랑 response 를 나눠서 작성한 이유는 같은값들을 다르게 정의해서 내려주는 경우가 있어서이다
//예를들어 password같은 경우 요청을할떄는 평문으로 들어갈 것이지만 , response로 내려줄 떄는 암호화 해서 처리할 것임
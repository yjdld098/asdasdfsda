package com.example.realadmin.controller;

import com.example.realadmin.system.network.Header;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // controller임을 알려주는 표시
@RequestMapping("/api") // 이곳으로 들어오는 API주소를 mapping, /api주소로 받겠다 (localhost:8088/api)

public class GetContorller {

    // localhost:8080/api/getMultiParameter?account=abcd&email=study@gmail.com&page=10
    @GetMapping("/header")
    public Header getHeader() {

        //{"resulCode" : "OK", "descriptiom: " : "OK"}
        return Header.builder().resultCode("OK").description("OK").build();
    }
}

// Header라는 object를 반환할것이며, resultCode와 description이 "OK" 값을 가진 JSON 형태로 내려갈것이다
//{"resulCode" : "OK", "descriptiom: " : "OK"}
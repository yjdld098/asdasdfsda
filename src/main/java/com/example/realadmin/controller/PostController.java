package com.example.realadmin.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController //controller임을 알려주는 표시
@RequestMapping("/api") // 이곳으로 들어오는 API주소를 Mapping, /api 주소로 받겠다 (localhost:8080/api)
public class PostController {
    //@RequestMapping(method = RequestMethod.POST, path = "/postMethod")
    @PostMapping("/postMethod")
    //위에 두개는 동일한 의미임 둘 중 하나 쓰고 싶은거 쓰셈
    public String postMethod(@RequestBody SearchParam searchParam) {
        return "ok";
    }
}

//post라는것은 HTML에서 <Form>테그를 사용하거나, ajax에서 검색을 할 때(비동기화) 사용한다
//이러한 경우는 주로 검섹 파라미터기 많은경우이므로 멀티 파라미터로 받아야함
//but getMethod와 깉이 Search Param으로 받으면 안되고 @RequestBody로 받겠다고 선언해줘야함
//왜냐, 이는 http 통신을 할 때 post의 body에 data를 넣어서 보내겠다라는 의미
// RequestBody에 SearchParam 값들을 매칭시켜서 달라는 의미이다

//RequestBody의 form에는 여러 형식이 있다.
// request 포맷으로는 json, xml, multipart-form, text-plain 등 여러 타입이 있다.
// 이 경우 @PostMapping에 produces = {"application-json"} 과 같이 입력하면 된다.
// 하지만 우리는 기본적으로 json 형식을 사용하므로 이 부분은 필요 없다.

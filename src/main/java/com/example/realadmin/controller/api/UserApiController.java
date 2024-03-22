package com.example.realadmin.controller.api;

import com.example.realadmin.ifs.CrudInterface;
import com.example.realadmin.service.UserApiLogicService;
import com.example.realadmin.system.network.Header;
import com.example.realadmin.system.network.request.UserApiRequest;
import com.example.realadmin.system.network.response.UserApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface<UserApiRequest, UserApiResponse>{

    @Autowired
    private UserApiLogicService userApiLogicService;
    @Override
    @PostMapping("") // /api/user
    public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> request) {
        log.info("{}", request);
        return userApiLogicService.create(request);
    }

    // create는 당연히 service와 연결시켜줘야하기 때문에 UserApiLogicService를 가져온다.
    // 그리고 create 메 서드와 매개변수로 넘어온 request와 연결을 시켜주면
    // user.ApiLogicService의 create에 가서 User를 생성한 후,
    // 생성된 데이터를 바탕으로 useApiResponse를 만들어서 return 해준다.

    @Override
    @GetMapping("{id}") // /api/user/{id}
    public Header<UserApiResponse> read(@PathVariable(name = "id") Long id) {
        log.info("read id: {}", id);
        return userApiLogicService.read(id);
    }
    // id에 데이터가 어떤식으로 들어갔는지 lon.info로 찍어보고, userApiLogicService에 read로 연결시켜줌

    @Override
    @PutMapping("") // /api/user
    public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> request) {

        return userApiLogicService.update(request);
    }

    @Override
    @DeleteMapping("{id}") // /api/user/{id]
    public Header delete(@PathVariable Long id) {
        log.info("delete: {}", id);
        return userApiLogicService.delete(id);
    }
}



//위 코드는, 앞으로 어드민 페이지 만들기 프로젝트에서 사용하는 CRUD를 아래의 규칙대로 Http 메소드와 매칭 시키겠다는 의미이다.
// 1. create에 대해서는 반드시 PostMapping으로 받는다.
// 2. read에 대해서는 GetMapping으로 받을 것이며, PathVariable을 이용한다.
// 3. update에 대해서는 PutMapping으로 받는다.
// 4. delete에대해서는 DeleteMapping으로 받으며, PathVariable을 이용한다.

// @SIF4j는 로깅 시스템이다.
// 데이터가 어떻게 이동하는지를 확인하기 위해 로깅 or 로깅 시스템을 통해 로그를 남기는 방법을 사용
// 롬복에 있는 어노테이션, log.info() 등을 통해 info 레벨로 로그를 남겨서 확인 가능
// System.out.println 괴 유사하게 동작함
// 차이점은 나중애 로그 파일에 로그 서비스를 추가하겠다고 하면 로그 레벨을 선택할 수 있음
// 자바에서 심플하게 쓰는 로깅 시스템이라고 생각
//log.info("{}, {}", request, "ABC");
//첫 번째 파라미터 속 중괄호({})는 뒤에 따라오는 파라미터 수와 일치해야하며, 각 파라미터들이 순서대로 중괄호 안에 매칭되어서 찍힌다. 위의 log.info의 경우 아래와 같이 파일에 로그가 찍힐 것이다.
//request.tostring(), ABC
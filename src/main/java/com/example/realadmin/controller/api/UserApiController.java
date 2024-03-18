package com.example.realadmin.controller.api;

import com.example.realadmin.ifs.CrudInterface;
import com.example.realadmin.system.network.Header;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface {

    @Override
    @PostMapping("") // /api/user
    public Header create() {
        return null;
    }

    @Override
    @GetMapping("{id}") // /api/user/{id}
    public Header read(@PathVariable(name = "id") Long id) {
        return null;
    }

    @Override
    @PutMapping("") // /api/user
    public Header update() {
        return null;
    }

    @Override
    @DeleteMapping("{id}") // /api/user/{id]
    public Header delete(@PathVariable Long id) {
        return null;
    }
}

        //위 코드는, 앞으로 어드민 페이지 만들기 프로젝트에서 사용하는 CRUD를 아래의 규칙대로 Http 메소드와 매칭 시키겠다는 의미이다.
        // 1. create에 대해서는 반드시 PostMapping으로 받는다.
        // 2. read에 대해서는 GetMapping으로 받을 것이며, PathVariable을 이용한다.
        // 3. update에 대해서는 PutMapping으로 받는다.
        // 4. delete에대해서는 DeleteMapping으로 받으며, PathVariable을 이용한다.
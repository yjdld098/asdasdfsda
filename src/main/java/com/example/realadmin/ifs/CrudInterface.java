package com.example.realadmin.ifs;

import com.example.realadmin.system.network.Header;

public interface CrudInterface<Req, Res> { //반드시 작성해야할 부분을 이렇게 인터페이스로 만듬

    Header<Res> create(Header<Req> requset);
    Header<Res> read(Long id);
    Header<Res> update(Header<Req> requset);
    Header delete(Long id);
}


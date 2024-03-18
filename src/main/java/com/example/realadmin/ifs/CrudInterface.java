package com.example.realadmin.ifs;

import com.example.realadmin.system.network.Header;

public interface CrudInterface { //반드시 작성해야할 부분을 이렇게 인터페이스로 만듬

    Header create();
    Header read(Long id);

    Header update();

    Header delete(Long id);
}


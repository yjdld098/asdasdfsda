package com.example.realadmin.system.network;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Header<T> {

    //api 통신시간
    private LocalDateTime transactionTime;

    //api 응답코드
    private String resultCode;

    //api 부가설명
    private String description;

    private T data;

    //OK (정상적인 통신일 때는 ok만 호출
    public static <T> Header<T> OK(){
        return (Header<T>) Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .build();
    }

    //DaTa Ok (데이터가 있을때는 Data Ok 호출)
    public static <T> Header<T> OK(T data){ // 제네릭으로 data를 받음
        return (Header<T>)Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .data(data)
                .build();
    }
    // ERROR (비정상일 때는 ERROR 호출)
    public static <T> Header<T> ERROR(String description) {
        return (Header<T>)Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("ERROR")
                .description(description) // 어떤 에러인지 프론트엔드에게 알려줌
                .build();
    }
}
// 해더파일엔 항상 들어가는 값인 api통신시간, 응답코드, 부가설명을 내려주는 값을 작성한다
// 통신시간의 경우 localdatetime를 사용하긴 했지만 실제 프론트단에 보내줄때는 String으로 더 많이 보내줌
// -> 그래야 형 변환하기 더 쉬움
// 계속 바뀌는 data 부분을 정의 할 때 제네릭(<T>)을 이용 -> 언제는 몸통을 갈이 끼울수있음
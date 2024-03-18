package com.example.realadmin.repositorytest;

import com.example.realadmin.repositroy.UserRepository;
import com.example.realadmin.system.User;
import com.example.realadmin.test.RealadminApplicationTests;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class UserRepositoryTest extends RealadminApplicationTests{
    // Dependency Injection (DI)
    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){

        String accoount = "Test01";
        String password = "Test01";
        String status = "REGISTERED";
        String email = "TEST01@gmail.com";
        String phoneNumber = "010-1111-2222";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createBy = "AdminServer";

        //User 객체를 만들어준다.
        User user = new User();
        user.setAccount(accoount);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
        user.setCreatedAt(createdAt);
        user.setCreatedBy(createBy);

        User newUser = userRepository.save(user); // sava를 통해 user의 내용을 newUser에 넣음
        Assertions.assertNotNull(newUser);

    }

    @Test
    @Transactional
    public void read(){
        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");

        if(user != null) // NullPointerException을 방지하기 위해 user가 null이 아닌경우에만 실행하도록 if문설정
        {
            user.getOrderGroupList().stream().forEach(orderGroup -> {
                        System.out.println("-------------주문묶음-------------");
                        System.out.println("수령인: " + orderGroup.getRevName());
                        System.out.println("수령지: " + orderGroup.getRevAddress());
                        System.out.println("총금액: " + orderGroup.getTotalPrice());
                        System.out .println("총수량: " + orderGroup.getTotalQuantity());

                        System.out.println("-------------주문상세-------------");
                        orderGroup.getOrderDetailList().forEach(orderDetail -> {
                                    //System.out.println("파트너사 이름: " + orderDetail.getItem().getPartner().getName());
                                    //System.out.println("파트너사 카테고리: " + orderDetail.getItem().getPartner().getCategory().getTitle());
                                    System.out.println("주문상품: " + orderDetail.getItem().getName());
                                    //System.out.println("고객센터 번호: " + orderDetail.getItem().getPartner().getCallCenter());
                                    System.out.println("주문상태: " + orderDetail.getStatus());
                            System.out.println("도착예정일자: " + orderDetail.getArrivalDate());
                        }
                        );

                    }
            );
        }
    }
}

//쿼리문을 사용하면 join을 계속 걸어서 각 항목을 가져와야함
//하지만ㅠJPA를 활용하면 user.getOrderGroup.getOrderDetail.getItem.getPartner.getCategory와 같은 방식으로
//마치 객체를 계속 해서 타고다니면서 필요한 값을 출력할 수 있다.
//따라서 JPA를 활용해서 프로그래밍을 하면 쿼리문에 대해 따로 신경 쓰지 않고, 객체 형태로 여러 정보를 가져오고, 수정하고, 입력할 수 있다.
// 이것이 바로 JPA의 장점이다.

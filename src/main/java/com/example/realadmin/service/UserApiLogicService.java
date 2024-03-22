package com.example.realadmin.service;

import com.example.realadmin.ifs.CrudInterface;
import com.example.realadmin.repositroy.UserRepository;
import com.example.realadmin.system.User;
import com.example.realadmin.system.network.Header;
import com.example.realadmin.system.network.request.UserApiRequest;
import com.example.realadmin.system.network.response.UserApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserApiLogicService implements CrudInterface<UserApiRequest, UserApiResponse> {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request){

        UserApiRequest userApiRequest = request.getData(); // -> 1. Request data 가져오기

        User user = User.builder()
                .account(userApiRequest.getAccount())
                .password(userApiRequest.getPassword())
                .status("REGISTERED")
                .phoneNumber(userApiRequest.getPhoneNumber())
                .email(userApiRequest.getEmail())
                .registeredAt(LocalDateTime.now())
                .build();
        User newUser = userRepository.save(user); // ->2.user 생성
        return Header.OK(response(newUser)); // -> 3. 생성된 데이터 기준으로 UserApiResponse 만들어서 return하기
    }


    @Override
    public Header<UserApiResponse> read(Long id) {

        //id를 가지고 repository를 통해서 getOne 또는 getByld를 통해 데이터를 가져옴
        //해당 데이터 user가 오면 userApiResponse를 return
        return userRepository.findById(id)
                .map( user -> response(user))
                .map( userApiResponse -> Header.OK(userApiResponse))
                .orElseGet( () -> Header.ERROR("데이터없음"));
    } // 람다식으로 한번에 연결함
    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {

        //1.data 가져오기
        UserApiRequest userApiRequest = request.getData();

        //2. id를 가지고 user데이터 찾기
        Optional<User> optional = userRepository.findById(userApiRequest.getId());
        return optional.map(user -> {
            //3.1번에서 받아온 data를 가지고 update
            //4.userApiResponse 만들기
            user.setAccount(userApiRequest.getAccount())
                    .setPassword(userApiRequest.getPassword())
                    .setStatus(userApiRequest.getStatus())
                    .setPhoneNumber(userApiRequest.getPhoneNumber())
                    .setEmail(userApiRequest.getEmail())
                    .setRegisteredAt(userApiRequest.getRegisteredAt())
                    .setUnregisteredAt(userApiRequest.getUnregisteredAt()) ;
            return user;
        })
                .map(user -> userRepository.save(user)) //여기서 update가 일어나고
                .map(updateUser -> response(updateUser)) // 여기서 userApiResponse가 만들어짐
                .map(userApiResponse -> Header.OK(userApiResponse))
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    //service 레벨에서 하는것은 먼저 데이터를 가져온 후 id를 가지고 user 데이터를 찾음 다음에
    //update를 시켜주고 userApiResponse를 만들어주면 됨
    //이때, request를 받을 때 여러 예외사항이 있을수 있지만 일단 모든값이 정상적으로 들어왔다고 가정하고 함
    @Override
    public Header delete(Long id) {
        // 1. id를 가지고 repository를 통해 user를 찾고
        Optional<User> optional = userRepository.findById(id);
        // 2. repository를 통해 delete를 해주고
        // 3. response를 return해주기기
        return optional.map(user -> {
            userRepository.delete(user);
            return Header.OK();
        })
            .orElseGet( ()-> Header.ERROR("데이터 없음"));
    }

    private UserApiResponse response(User user){
        UserApiResponse userApiResponse = UserApiResponse.builder()
                .id(user.getId())
                .account(user.getAccount())
                .password(user.getPassword()) //todo 암호화, 길이를 return한다든지 등의 옵션이 생길 수 있다
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .status(user.getStatus())
                .registeredAt(user.getRegisteredAt())
                .unregisteredAt(user.getUnregisteredAt())
                .build();
        return userApiResponse;// header에 data 부분을 합쳐서 return하기
    }
}






//UserApiRequest에서 request data를 getDate() 메서드를 통해 가져오고,
// user를 생성한 후 빌더 메서드 를 통해 값을 넣어 준다.
// 그리고 이를 save 메서드를 통해 새로운 user에 저장한다.
//그리고 3번의 response를 만들어주는 경우,
// 이는 user 객체로 만들어서 리턴하는 값이기 때문에 create 외에도 read나 update 등 다른 데에서도 사용하는 부분이다.
// 자주 사용하는 부분이므로 중복을 피하기 위해 response 함
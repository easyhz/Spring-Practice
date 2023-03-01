package com.example.spring_practice;

import com.example.spring_practice.entity.Users;
import com.example.spring_practice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@DataJpaTest
@Slf4j
//@SpringBootTest
class SpringPracticeApplicationTests {

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void insertTestData() {
        Users user = new Users();
        user.setUsername("Kim ji");
        userRepository.save(user);

        user = new Users();
        user.setUsername("Lee soo");
        userRepository.save(user);

        user = new Users();
        user.setUsername("Shin soo");
        userRepository.save(user);

        user = new Users();
        user.setUsername("Lee ji");
        userRepository.save(user);

        user = new Users();
        user.setUsername("Kim soo");
        userRepository.save(user);


    }
    @Test
    void findAllTest() {
        // 저장된 데이터 모두를 Spring JPA에 미리 구현된 findAll 명령을 통해 불러옴.
        List<Users> userList = userRepository.findAll();
        for(Users u : userList) {
            log.info("[FIND ALL] : " + u.getId() + " | " + u.getUsername());
        }
    }

    @Test
    void find2ByNameTest() {
        // Like 검색으로 값 2개만 값을 가져오는 작성한 명령을 실행
        List<Users> userList = userRepository.findFirst2ByUsernameLikeOrderByIdDesc("Lee%");
        for(Users u : userList) {
            log.info("[FIND SOME] : " + u.getId() + " | " + u.getUsername());
        }
    }

}

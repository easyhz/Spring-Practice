package com.example.spring_practice;

import com.example.spring_practice.entity.Users;
import com.example.spring_practice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;


@DataJpaTest
@Slf4j
//@SpringBootTest
class SpringPracticeApplicationTestExample {

    @Autowired
    UserRepository userRepository;

    @BeforeAll
    static void beforeAll() {
        log.info("[BEFORE] : BeforeAll");
    }
    @BeforeEach
    void beforeEach() {
        log.info("[BEFORE] : BeforeEach");
    }

    @AfterAll
    static void afterAll() {
        log.info("[AFTER] : AfterAll");
    }

    @AfterEach
    void afterEach() {
        log.info("[AFTER] : AfterEach");
    }

    @Test
    void test1() {
        log.info("[TEST] : 테스트 1");
    }

    @Test
    void test2() {
        log.info("[TEST] : 테스트 2");
    }

}

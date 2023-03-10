package com.example.spring_practice;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class SpringPracticeItemTests {
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

}

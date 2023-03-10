package com.example.spring_practice.service;

import com.example.spring_practice.entity.Users;
import com.example.spring_practice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public List<Users> getUsersService(String name) {
        if(name.isBlank()) {
            // name 파라미터가 null 이면 전체 user return
            return userRepository.findAll();
        } else{
            log.info("[ USER SERVICE              ] : " + name);
            return userRepository.findFirst2ByUsernameLikeOrderByIdDesc(name);
        }
    }

    public String createUserService(Users user) {
        userRepository.save(user);  // User Insert 쿼리 수행
        return "완료";
    }
}

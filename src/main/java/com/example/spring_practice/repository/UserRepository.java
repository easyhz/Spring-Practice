package com.example.spring_practice.repository;

import com.example.spring_practice.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface UserRepository extends JpaRepository<Users, Long> {

    List<Users> findFirst2ByUsernameLikeOrderByIdDesc(String name);
}

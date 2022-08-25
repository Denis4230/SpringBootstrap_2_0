package com.example.web.springbootstrap2_0.repository;


import com.example.web.springbootstrap2_0.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

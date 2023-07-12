package com.luv2code.springboot.demosecurity.dao;

import com.luv2code.springboot.demosecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String username);
}

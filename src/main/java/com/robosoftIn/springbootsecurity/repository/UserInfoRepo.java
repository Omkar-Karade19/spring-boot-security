package com.robosoftIn.springbootsecurity.repository;

import com.robosoftIn.springbootsecurity.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRepo extends JpaRepository<UserInfo,Integer> {
    Optional<UserInfo> findByUserName(String username);
}

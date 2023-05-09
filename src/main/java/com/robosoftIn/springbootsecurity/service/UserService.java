package com.robosoftIn.springbootsecurity.service;

import com.robosoftIn.springbootsecurity.entity.UserInfo;
import com.robosoftIn.springbootsecurity.repository.UserInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserInfoRepo repo;

    @Autowired
    private PasswordEncoder encoder;

    public String adduser(UserInfo userInfo){
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        repo.save(userInfo);
        return "User added";
    }
}

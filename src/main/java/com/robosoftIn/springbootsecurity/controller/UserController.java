package com.robosoftIn.springbootsecurity.controller;

import com.robosoftIn.springbootsecurity.entity.UserInfo;
import com.robosoftIn.springbootsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController{
    @Autowired
    private UserService service;
    @PostMapping("/signUp")
    public ResponseEntity<String> addNewUser(@RequestBody UserInfo info){
        service.adduser(info);
        return ResponseEntity.ok().build();
    }
}
package com.robosoftIn.springbootsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class HomeController {

    @GetMapping("/home")
    public String Home(){
        return "Home Controller";
    }

    @GetMapping("/list")
    //Method Level
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ArrayList<String> list(){
        ArrayList<String> newList = new ArrayList<>();
        newList.add("Value 1");
        newList.add("Value 2");
        newList.add("Value 3");
        newList.add("Value 4");

        return newList;
    }

    @GetMapping("/user")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String user(){
        return "End Point for User";
    }



}

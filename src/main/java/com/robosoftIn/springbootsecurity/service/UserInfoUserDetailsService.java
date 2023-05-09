package com.robosoftIn.springbootsecurity.service;

import com.robosoftIn.springbootsecurity.config.UserInfoUserDetails;
import com.robosoftIn.springbootsecurity.entity.UserInfo;
import com.robosoftIn.springbootsecurity.repository.UserInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {
    @Autowired
    private UserInfoRepo repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = repository.findByUserName(username);
        return userInfo.map(UserInfoUserDetails::new)
                .orElseThrow(()->new UsernameNotFoundException("User not Found "+ username ));

    }
}

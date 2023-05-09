package com.robosoftIn.springbootsecurity.config;

import com.robosoftIn.springbootsecurity.service.UserInfoUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {

    @Bean
    public UserDetailsService userDetailsService(){
//        UserDetails admin = User.withUsername("Omkar")
//                .password(passwordEncoder().encode("passw"))
//                .roles("ADMIN")
//                .build();
//
//        UserDetails user = User.withUsername("Ronit")
//                .password(passwordEncoder().encode("pass"))
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(admin,user);

        return new UserInfoUserDetailsService();

    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/home","/signUp")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic()
                .and()
                .build();

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
}

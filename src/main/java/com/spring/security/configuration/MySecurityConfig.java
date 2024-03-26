package com.spring.security.configuration;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;


@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 1 - In-Memory Authentication
        UserBuilder userBuilder = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(userBuilder.username("dmitriy")
                        .password("dmitriy123")
                        .roles("EMPLOYEE"))
                .withUser(userBuilder.username("elena")
                        .password("elena123")
                        .roles("HR"))
                .withUser(userBuilder.username("ivan")
                        .password("ivan123")
                        .roles("MANAGER", "HR"));
    }
}

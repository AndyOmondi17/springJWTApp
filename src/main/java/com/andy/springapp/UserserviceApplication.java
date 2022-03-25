package com.andy.springapp;


import com.andy.springapp.repo.AddressRepo;
import com.andy.springapp.repo.CityRepo;
import com.andy.springapp.repo.CountryRepo;
import com.andy.springapp.repo.StoreRepo;
import com.andy.springapp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class UserserviceApplication  {

    @Autowired
    CountryRepo countryRepo;

    @Autowired
    CityRepo cityRepo;

    @Autowired
    AddressRepo addressRepo;

    @Autowired
    StoreRepo storeRepo;

    public static void main(String[] args) {
        SpringApplication.run(UserserviceApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner runner(UserService userService){
        return args -> {};
    }
}


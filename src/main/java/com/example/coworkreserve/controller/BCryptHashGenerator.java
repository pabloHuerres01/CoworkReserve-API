package com.example.coworkreserve.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptHashGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println("adminpassword: " + encoder.encode("adminpassword"));
        System.out.println("userpassword: " + encoder.encode("userpassword"));
    }
}

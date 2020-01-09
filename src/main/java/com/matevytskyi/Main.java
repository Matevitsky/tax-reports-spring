package com.matevytskyi;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Main {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("inspector"));

    }

    //TODO:CHECK All classes
}
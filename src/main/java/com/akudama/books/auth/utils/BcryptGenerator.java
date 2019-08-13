package com.akudama.books.auth.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public final class BcryptGenerator {

    private final String password;

    public BcryptGenerator(String password) {
        this.password = password;
    }

    public String encrypt() {
        return new BCryptPasswordEncoder().encode(password);
    }
}

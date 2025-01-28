package com.breno.envhazardtracker.security;

import com.breno.envhazardtracker.user.ports.PasswordEncoderService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderServiceImpl implements PasswordEncoderService {
    @Override
    public String encodePassword(String plainPassword) {
        return new BCryptPasswordEncoder().encode(plainPassword);
    }

    @Override
    public boolean checkPassword(String plainPassword, String hashedPassword) {
        return new BCryptPasswordEncoder().matches(plainPassword, hashedPassword);
    }
}

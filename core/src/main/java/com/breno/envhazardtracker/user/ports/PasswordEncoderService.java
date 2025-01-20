package com.breno.envhazardtracker.user.ports;

public interface PasswordEncoderService {

    public String encodePassword(String plainPassword);

    boolean checkPassword(String plainPassword, String hashedPassword);

}

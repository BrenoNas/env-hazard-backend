package com.breno.envhazardtracker.user.ports;

import com.breno.envhazardtracker.user.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryService {

    public void saveUser(User user) ;

    public Boolean doesUserAlreadyExist(String userName);

    public Optional<User> findByEmail(String email);

}

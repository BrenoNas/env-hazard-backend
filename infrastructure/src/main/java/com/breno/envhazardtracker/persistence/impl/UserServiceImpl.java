package com.breno.envhazardtracker.persistence.impl;

import com.breno.envhazardtracker.persistence.converters.UserRepositoryConverter;
import com.breno.envhazardtracker.persistence.repositories.UserRepository;
import com.breno.envhazardtracker.user.User;
import com.breno.envhazardtracker.user.ports.UserRepositoryService;
import lombok.AllArgsConstructor;

import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
public class UserServiceImpl implements UserRepositoryService {

    private final UserRepositoryConverter userRepositoryConverter;
    private final UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.save(userRepositoryConverter.mapToTable(user));
    }

    @Override
    public Boolean doesUserAlreadyExist(String userName) {
        return userRepository.findByUsername(userName).isPresent();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

}

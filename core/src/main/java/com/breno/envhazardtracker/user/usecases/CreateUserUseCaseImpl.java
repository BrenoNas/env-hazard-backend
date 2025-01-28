package com.breno.envhazardtracker.user.usecases;

import com.breno.envhazardtracker.user.User;
import com.breno.envhazardtracker.user.exceptions.UserAlreadyExistException;
import com.breno.envhazardtracker.user.ports.PasswordEncoderService;
import com.breno.envhazardtracker.user.ports.UserRepositoryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserRepositoryService userRepositoryService;
    private final PasswordEncoderService passwordEncoderService;

    @Override
    public void execute(User user) throws UserAlreadyExistException {
        if(userRepositoryService.doesUserAlreadyExist(user.getUsername())) {
            throw new UserAlreadyExistException();
        }
        user.setPassword(passwordEncoderService.encodePassword(user.getPassword()));
        userRepositoryService.saveUser(user);
    }
}

package com.breno.envhazardtracker.user.usecases;

import com.breno.envhazardtracker.user.User;
import com.breno.envhazardtracker.user.exceptions.UserAlreadyExistException;
import com.breno.envhazardtracker.user.ports.UserRepositoryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserRepositoryService userRepositoryService;

    @Override
    public void execute(User user) throws UserAlreadyExistException {
        if(userRepositoryService.doesUserAlreadyExist(user.getUsername())) {
            throw new UserAlreadyExistException();
        }
        userRepositoryService.saveUser(user);
    }
}

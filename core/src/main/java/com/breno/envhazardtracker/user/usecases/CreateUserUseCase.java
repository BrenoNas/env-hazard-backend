package com.breno.envhazardtracker.user.usecases;


import com.breno.envhazardtracker.user.User;
import com.breno.envhazardtracker.user.exceptions.UserAlreadyExistException;

public interface CreateUserUseCase {

    public void execute(User user) throws UserAlreadyExistException;

}

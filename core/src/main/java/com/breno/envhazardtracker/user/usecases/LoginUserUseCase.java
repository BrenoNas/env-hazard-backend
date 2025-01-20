package com.breno.envhazardtracker.user.usecases;

import com.breno.envhazardtracker.user.User;
import com.breno.envhazardtracker.user.exceptions.NotAllowedException;

public interface LoginUserUseCase {

    public User execute(final String email, final String password) throws NotAllowedException;

}

package com.breno.envhazardtracker.user.usecases;

import com.breno.envhazardtracker.user.User;
import com.breno.envhazardtracker.user.exceptions.NotAllowedException;
import com.breno.envhazardtracker.user.ports.PasswordEncoderService;
import com.breno.envhazardtracker.user.ports.UserRepositoryService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoginUserUseCaseImpl implements LoginUserUseCase {

    private final UserRepositoryService userRepositoryService;
    private final PasswordEncoderService passwordEncoderService;

    @Override
    public User execute(final String email, final String password) throws NotAllowedException {
        var user = userRepositoryService.findByEmail(email).orElseThrow(NotAllowedException::new);

        var hashedPassword = passwordEncoderService.encodePassword(password);
        if (!user.getPasswordHash().equals(hashedPassword)) throw new NotAllowedException();
        return user;
    }
}

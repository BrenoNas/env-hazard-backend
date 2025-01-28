package com.breno.envhazardtracker.configuration;

import com.breno.envhazardtracker.delivery.converters.UserRestConverter;
import com.breno.envhazardtracker.persistence.converters.UserRepositoryConverter;
import com.breno.envhazardtracker.persistence.impl.UserServiceImpl;
import com.breno.envhazardtracker.persistence.repositories.UserRepository;
import com.breno.envhazardtracker.security.PasswordEncoderServiceImpl;
import com.breno.envhazardtracker.user.usecases.CreateUserUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public UserRepositoryConverter createUserRepositoryConverter() {
        return new UserRepositoryConverter();
    }

    @Bean
    public UserRestConverter createUserRestConverter() {
        return new UserRestConverter();
    }

    @Bean
    public UserServiceImpl createUserServiceImpl() {
        return new UserServiceImpl(createUserRepositoryConverter(), userRepository);
    }

    @Bean
    public PasswordEncoderServiceImpl createPasswordEncoderServiceImpl(){
        return new PasswordEncoderServiceImpl();
    }

    @Bean
    public CreateUserUseCaseImpl createCreateUserUseCase() {
        return new CreateUserUseCaseImpl(createUserServiceImpl(), createPasswordEncoderServiceImpl());
    }

}

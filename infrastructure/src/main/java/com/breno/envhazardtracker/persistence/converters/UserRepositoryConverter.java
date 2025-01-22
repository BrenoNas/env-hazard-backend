package com.breno.envhazardtracker.persistence.converters;

import com.breno.envhazardtracker.persistence.entities.UserEntity;
import com.breno.envhazardtracker.shared.RepositoryConverter;
import com.breno.envhazardtracker.user.User;

public class UserRepositoryConverter implements RepositoryConverter<UserEntity, User> {

    @Override
    public UserEntity mapToTable(final User persistenceObject) {
        return new UserEntity(persistenceObject.getId(), persistenceObject.getUsername(),
                persistenceObject.getEmail(), persistenceObject.getPasswordHash(), persistenceObject.getCreatedAt());
    }

    @Override
    public User mapToEntity(final UserEntity entityObject) {
        return new User(entityObject.getId(), entityObject.getUsername(), entityObject.getEmail(),
                entityObject.getPasswordHash(), entityObject.getCreatedAt());
    }

}

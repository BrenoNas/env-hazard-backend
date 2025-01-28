package com.breno.envhazardtracker.delivery.converters;

import com.breno.envhazardtracker.delivery.rest.UserRest;
import com.breno.envhazardtracker.shared.RestConverter;
import com.breno.envhazardtracker.user.User;

public class UserRestConverter implements RestConverter<UserRest, User> {

    @Override
    public User mapToEntity(final UserRest rest) {
        return new User(rest.getUsername(), rest.getEmail(), rest.getPassword());
    }
}

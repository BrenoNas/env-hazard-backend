package com.breno.envhazardtracker.delivery.converters;

import com.breno.envhazardtracker.delivery.rest.HazardRest;
import com.breno.envhazardtracker.hazard.Hazard;
import com.breno.envhazardtracker.persistence.entities.UserEntity;
import com.breno.envhazardtracker.shared.RestConverter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.UUID;

public class HazardRestConverter implements RestConverter<HazardRest, Hazard> {

    @Override
    public Hazard mapToEntity(final HazardRest rest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserEntity userEntity = (UserEntity)authentication.getPrincipal();
        UUID userId = userEntity.getId();
        return new Hazard(userId, rest.getHazardTypeId(), rest.getDescription(), rest.getLatitude(), rest.getLongitude());
    }
}

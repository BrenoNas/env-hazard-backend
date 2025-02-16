package com.breno.envhazardtracker.persistence.converters;

import com.breno.envhazardtracker.hazard.Hazard;
import com.breno.envhazardtracker.persistence.entities.HazardEntity;
import com.breno.envhazardtracker.persistence.entities.HazardTypeEntity;
import com.breno.envhazardtracker.persistence.entities.UserEntity;
import com.breno.envhazardtracker.persistence.repositories.UserRepository;
import com.breno.envhazardtracker.shared.RepositoryConverter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HazardRepositoryConverter implements RepositoryConverter<HazardEntity, Hazard> {

    private UserRepository userRepository;

    @Override
    public HazardEntity mapToTable(final Hazard persistenceObject) {

        UserEntity user = userRepository.findById(persistenceObject.getUserId()) .orElseThrow(() ->
                new IllegalArgumentException("User not found"));

        HazardTypeEntity hazardType = new HazardTypeEntity(persistenceObject.getHazardTypeId(), null);

        return new HazardEntity(persistenceObject.getId(), user,  hazardType,
                persistenceObject.getDescription(), persistenceObject.getLatitude(),
                persistenceObject.getLongitude(), persistenceObject.getCreatedAt());
    }

    @Override
    public Hazard mapToEntity(final HazardEntity entityObject) {
        return new Hazard(entityObject.getUser().getId(), entityObject.getHazardType().getId(), entityObject.getDescription(),
                entityObject.getLatitude(), entityObject.getLongitude());
    }
}

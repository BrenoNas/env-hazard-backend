package com.breno.envhazardtracker.persistence.converters;

import com.breno.envhazardtracker.hazard.Hazard;
import com.breno.envhazardtracker.persistence.entities.HazardEntity;
import com.breno.envhazardtracker.persistence.entities.HazardTypeEntity;
import com.breno.envhazardtracker.persistence.entities.UserEntity;
import com.breno.envhazardtracker.persistence.repositories.HazardTypeRepository;
import com.breno.envhazardtracker.persistence.repositories.UserRepository;
import com.breno.envhazardtracker.shared.RepositoryConverter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HazardRepositoryConverter implements RepositoryConverter<HazardEntity, Hazard> {

    private UserRepository userRepository;

    private HazardTypeRepository hazardTypeRepository;

    @Override
    public HazardEntity mapToTable(final Hazard persistenceObject) {

        UserEntity user = userRepository.findById(persistenceObject.getUserId()) .orElseThrow(() ->
                new IllegalArgumentException("User not found"));

        HazardTypeEntity hazardType = hazardTypeRepository.findById(persistenceObject.getHazardTypeId()).orElseThrow(() ->
                new IllegalArgumentException("Hazard type not found"));

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

package com.breno.envhazardtracker.persistence.impl;

import com.breno.envhazardtracker.hazard.Hazard;
import com.breno.envhazardtracker.hazard.ports.HazardRepositoryService;
import com.breno.envhazardtracker.persistence.converters.HazardRepositoryConverter;
import com.breno.envhazardtracker.persistence.entities.HazardEntity;
import com.breno.envhazardtracker.persistence.repositories.HazardRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
public class HazardServiceImpl implements HazardRepositoryService {

    private final HazardRepositoryConverter hazardRepositoryConverter;
    private final HazardRepository hazardRepository;

    @Override
    public void saveHazard(Hazard hazard) {
        hazardRepository.save(hazardRepositoryConverter.mapToTable(hazard));
    }

    @Override
    public List<Hazard> findAll() {
        List<Hazard> hazards = new java.util.ArrayList<>();
        List<HazardEntity> hazardEntities = hazardRepository.findAll();
        for (HazardEntity hazardEntity : hazardEntities) {
            hazards.add(hazardRepositoryConverter.mapToEntity(hazardEntity));
        }
        return hazards;
    }

    @Override
    public Optional<Hazard> findById(UUID id) {
        return hazardRepository.findById(id).map(hazardRepositoryConverter::mapToEntity);
    }

    @Override
    public void deleteById(UUID id) {
        hazardRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        hazardRepository.deleteAll();
    }

    @Override
    public Boolean existsById(UUID id) {
        return hazardRepository.existsById(id);
    }
}

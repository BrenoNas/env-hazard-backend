package com.breno.envhazardtracker.persistence.impl;

import com.breno.envhazardtracker.hazard.Hazard;
import com.breno.envhazardtracker.hazard.ports.HazardRepositoryService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
public class HazardServiceImpl implements HazardRepositoryService {

    @Override
    public void saveHazard(Hazard hazard) {

    }

    @Override
    public List<Hazard> findAll() {
        return List.of();
    }

    @Override
    public Optional<Hazard> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(UUID id) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Boolean existsById(UUID id) {
        return null;
    }
}

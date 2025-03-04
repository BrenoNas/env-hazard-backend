package com.breno.envhazardtracker.hazard.ports;

import com.breno.envhazardtracker.hazard.Hazard;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface HazardRepositoryService {
    public UUID saveHazard(Hazard hazard);
    public List<Hazard> findAll();
    public Optional<Hazard> findById(UUID id);
    public void deleteById(UUID id);
    public void deleteAll();
    public Boolean existsById(UUID id);
}


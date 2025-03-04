package com.breno.envhazardtracker.persistence.impl;

import com.breno.envhazardtracker.hazardmedia.HazardMedia;
import com.breno.envhazardtracker.hazardmedia.ports.HazardMediaRepositoryService;
import com.breno.envhazardtracker.persistence.converters.HazardMediaRepositoryConverter;
import com.breno.envhazardtracker.persistence.repositories.HazardMediaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HazardMediaServiceImpl implements HazardMediaRepositoryService {

    private HazardMediaRepository hazardMediaRepository;
    private HazardMediaRepositoryConverter hazardMediaRepositoryConverter;

    @Override
    public void SaveHazardMedia(HazardMedia hazardMedia) {
        hazardMediaRepository.save(hazardMediaRepositoryConverter.mapToTable(hazardMedia));
    }
}

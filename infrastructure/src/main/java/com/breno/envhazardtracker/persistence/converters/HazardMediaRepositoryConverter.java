package com.breno.envhazardtracker.persistence.converters;

import com.breno.envhazardtracker.hazardmedia.HazardMedia;
import com.breno.envhazardtracker.persistence.entities.HazardMediaEntity;
import com.breno.envhazardtracker.shared.RepositoryConverter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HazardMediaRepositoryConverter implements RepositoryConverter<HazardMediaEntity, HazardMedia> {

    private final HazardRepositoryConverter hazardRepositoryConverter;
    private final MediaRepositoryConverter mediaRepositoryConverter;

    @Override
    public HazardMediaEntity mapToTable(final HazardMedia persistenceObject) {
        return new HazardMediaEntity(persistenceObject.getId(),
                hazardRepositoryConverter.mapToTable(persistenceObject.getHazard()),
                mediaRepositoryConverter.mapToTable(persistenceObject.getMedia()));
    }

    @Override
    public HazardMedia mapToEntity(final HazardMediaEntity entityObject) {
        return new HazardMedia(entityObject.getId(), hazardRepositoryConverter.mapToEntity(entityObject.getHazard()),
                mediaRepositoryConverter.mapToEntity(entityObject.getMedia()));
    }
}

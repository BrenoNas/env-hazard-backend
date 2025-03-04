package com.breno.envhazardtracker.persistence.converters;

import com.breno.envhazardtracker.media.Media;
import com.breno.envhazardtracker.persistence.entities.MediaEntity;
import com.breno.envhazardtracker.shared.RepositoryConverter;

public class MediaRepositoryConverter implements RepositoryConverter<MediaEntity, Media> {

    @Override
    public MediaEntity mapToTable(final Media persistenceObject) {
        return new MediaEntity(persistenceObject.getId(), persistenceObject.getUrl());
    }

    @Override
    public Media mapToEntity(final MediaEntity entityObject) {
        return new Media(entityObject.getId(), null, "" , entityObject.getUrl());
    }

}

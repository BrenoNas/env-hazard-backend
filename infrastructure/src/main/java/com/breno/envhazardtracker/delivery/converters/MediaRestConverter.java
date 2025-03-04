package com.breno.envhazardtracker.delivery.converters;

import com.breno.envhazardtracker.delivery.rest.MediaRest;
import com.breno.envhazardtracker.media.Media;
import com.breno.envhazardtracker.shared.RestConverter;

import java.io.IOException;

public class MediaRestConverter implements RestConverter<MediaRest, Media> {

    @Override
    public Media mapToEntity(final MediaRest rest) {
        byte[] content = null;
        try {
            content = rest.getImage().getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Media(content, rest.getImage().getOriginalFilename());
    }
}

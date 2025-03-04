package com.breno.envhazardtracker.hazardmedia;

import com.breno.envhazardtracker.hazard.Hazard;
import com.breno.envhazardtracker.media.Media;
import com.breno.envhazardtracker.shared.SelfValidating;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HazardMedia extends SelfValidating<HazardMedia> implements Serializable {

    private UUID id;

    @NotNull
    private Hazard hazard;

    @NotNull
    private Media media;

    public HazardMedia(Hazard hazard, Media media) {
        this.hazard = hazard;
        this.media = media;
    }
}

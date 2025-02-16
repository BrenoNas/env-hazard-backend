package com.breno.envhazardtracker.hazard;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import com.breno.envhazardtracker.shared.SelfValidating;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hazard extends SelfValidating<Hazard> implements Serializable {

    private UUID id;

    @NotNull
    private UUID userId;

    @NotNull
    private Integer hazardTypeId;

    @Size(max = 500)
    private String description;

    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;

    private LocalDateTime createdAt;

    public Hazard(UUID userId, Integer hazardTypeId, String description, Double latitude, Double longitude) {
        this.userId = userId;
        this.hazardTypeId = hazardTypeId;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.createdAt = LocalDateTime.now();
    }
}
package com.breno.envhazardtracker.delivery.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HazardRest implements Serializable {

    @Serial
    private static final long serialVersionUID = -6600537541142882346L;

    private Integer hazardTypeId;

    private String description;

    private Double latitude;

    private Double longitude;
}

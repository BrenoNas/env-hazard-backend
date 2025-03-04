package com.breno.envhazardtracker.delivery.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MediaRest implements Serializable {

    @Serial
    private static final long serialVersionUID = 7624797630170106445L;

    private MultipartFile image;
}

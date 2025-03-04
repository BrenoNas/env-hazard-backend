package com.breno.envhazardtracker.media;

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
public class Media extends SelfValidating<Media> implements Serializable {

    protected UUID id;

    @NotNull
    protected byte[] content;

    @NotNull
    protected String fileName;

    @NotNull
    protected String url;

    public Media(byte[] content, String fileName) {
        this.content = content;
        this.fileName = fileName;
    }
}

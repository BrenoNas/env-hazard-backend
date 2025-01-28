package com.breno.envhazardtracker.delivery.responses;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class EnvHazardResponse<T> implements Serializable {

    private String status;
    private String code;
    private String message;
    private T data;

    @Serial
    private static final long serialVersionUID = 7302319210373510173L;

    public EnvHazardResponse() {
        super();
    }

    public EnvHazardResponse(String status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public EnvHazardResponse(String status, String code, String message, T data) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
    }

}

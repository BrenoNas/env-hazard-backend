package com.breno.envhazardtracker.delivery.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRest implements Serializable {

    @Serial
    private static final long serialVersionUID = 7809559376441998463L;

    private String username;

    private String email;

    private String password;
}

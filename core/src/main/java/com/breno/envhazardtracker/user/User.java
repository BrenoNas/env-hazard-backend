package com.breno.envhazardtracker.user;



import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.breno.envhazardtracker.shared.SelfValidating;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends SelfValidating<User> implements Serializable {

    private String Id;

    @NotBlank()
    @Size(max = 50)
    private String username;

    @NotBlank()
    @Email()
    private String email;

    private String passwordHash;

    private LocalDateTime createdAt;
}

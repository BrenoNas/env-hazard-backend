package com.breno.envhazardtracker.user;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import com.breno.envhazardtracker.shared.SelfValidating;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends SelfValidating<User> implements Serializable {

    private UUID Id;

    @NotBlank()
    @Size(max = 50)
    private String username;

    @NotBlank()
    @Email()
    private String email;

    private String password;

    private LocalDateTime createdAt;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        createdAt = LocalDateTime.now();
    }
}

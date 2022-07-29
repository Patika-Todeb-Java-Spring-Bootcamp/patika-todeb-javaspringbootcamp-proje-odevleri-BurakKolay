package com.todeb.bkolay.usedvehiclesaleapplication.model.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class UserDataDTO implements Serializable {

    @Size(min = 5, max = 15)
    private String username;

    @NotBlank
    @Email(message = "Email not valid")
    private String email;

    @NotBlank
    @Size(min = 8, max = 20)
    private String password;
}

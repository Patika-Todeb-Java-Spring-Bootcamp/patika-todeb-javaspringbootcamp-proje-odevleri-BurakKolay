package com.todeb.bkolay.usedvehiclesaleapplication.model.dto;

import com.todeb.bkolay.usedvehiclesaleapplication.model.entity.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserResponseDTO {
    private Integer id;
    private String username;
    private String email;
    private List<Role> roles;
}

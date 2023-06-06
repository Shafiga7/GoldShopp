package com.example.goldshop.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record RegisterRequest(
        @Email(message = "Email daxil etmelisiniz")
        String email,
        @Size(min=8)
        String password
){

}

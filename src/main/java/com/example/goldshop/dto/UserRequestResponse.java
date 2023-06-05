package com.example.goldshop.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record UserRequestResponse (
        @Email(message = "Email daxil olunmalidir")
        @Size(min = 6,message = "minuzunluq 6")
        String fullname
) {
}

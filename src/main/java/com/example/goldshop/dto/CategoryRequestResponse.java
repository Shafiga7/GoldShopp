package com.example.goldshop.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CategoryRequestResponse (

        @NotNull
        String fullName,

        LocalDate age
) {
}

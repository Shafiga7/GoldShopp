package com.example.goldshop.dto;

import java.util.List;

public record CategoryPageResponse (
        List<CategoryDTO> category,
        long totalElements,
        int totalPages,
        boolean hasNextPage
) {
}

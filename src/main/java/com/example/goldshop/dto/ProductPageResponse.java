package com.example.goldshop.dto;

import java.util.List;

public record ProductPageResponse (
        List<ProductDTO> product,
        long totalElements,
        int totalPages,
        boolean hasNextPage
) {
}

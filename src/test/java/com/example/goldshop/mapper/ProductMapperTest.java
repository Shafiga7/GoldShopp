package com.example.goldshop.mapper;

import com.example.goldshop.dto.ProductDTO;
import com.example.goldshop.entity.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductMapperTest {

    private final ProductMapper productMapper = new ProductMapperImpl();

    @Test
    void toProductDTO() {
        Product product = Product.builder()
                .name("Qolbaq")
                .price(135.50)
                .carat(18)
                .build();
        ProductDTO expected = new ProductDTO("Qolbaq", 135.50, 18);

        ProductDTO actual = productMapper.toProductDTO(product);

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void toEntity() {
        ProductDTO productDTO = new ProductDTO("Qolbaq", 135.50, 18);
        Product expected = new Product(1, "Qolbaq", 135.50, 18);
        Product actual = productMapper.toEntity(productDTO);

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
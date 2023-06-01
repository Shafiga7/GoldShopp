package com.example.goldshop.dto;

import com.example.goldshop.entity.Category;
import com.example.goldshop.entity.Product;
import org.springframework.stereotype.Service;

import java.util.function.Function;


@Service
public class ProductDTOManager implements Function<Product, ProductDTO> {

    public ProductDTO apply(Product product) {
        return new ProductDTO(
               product.getProduct_name(),
                product.getPrice(),
                product.getCarat());
    }
}

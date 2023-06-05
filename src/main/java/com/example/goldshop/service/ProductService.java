package com.example.goldshop.service;

import com.example.goldshop.dto.ProductDTO;
import com.example.goldshop.dto.ProductPageResponse;

public interface ProductService {
    ProductPageResponse getAll(int page, int count);
    ProductDTO getById(int id);
    void addProduct(ProductDTO productDTO);
    void deleteProduct(int id);


}

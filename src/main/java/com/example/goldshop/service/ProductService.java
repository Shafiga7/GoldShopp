package com.example.goldshop.service;

import com.example.goldshop.dto.ProductDTO;
import com.example.goldshop.entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAll();
    ProductDTO getById(int id);
    void addProduct(Product product);
    void deleteProduct(int id);


}

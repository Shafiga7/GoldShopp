package com.example.goldshop.manager;

import com.example.goldshop.dto.ProductDTO;
import com.example.goldshop.dto.ProductDTOManager;
import com.example.goldshop.entity.Product;
import com.example.goldshop.exception.ProductNotFoundException;
import com.example.goldshop.mapper.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.goldshop.repository.ProductRepository;
import com.example.goldshop.service.ProductService;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {

    private final ProductRepository productRepository;

    private final ProductDTOManager productDTOManager;

    private final ProductMapper productMapper;

    @Override
    public List<ProductDTO> getAll() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toProductDTO)
                .toList();
    }

    @Override
    public ProductDTO getById(int id) { return productRepository.findById(id)
            .stream()
            .map(productMapper::toProductDTO)
            .findFirst().orElseThrow(()->new ProductNotFoundException("Mehsul tapilmadi"));
    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }



}

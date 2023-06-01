package com.example.goldshop.manager;

import com.example.goldshop.entity.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.goldshop.repository.ProductRepository;
import com.example.goldshop.service.ProductService;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {

    private final ProductRepository productRepository;
    @Override
    public List<Product> getAll() { return productRepository.findAll();
    }

    @Override
    public Product getById(int id) { return productRepository.findById(id).get();
    }

    @Override
    public void addProduct(Product product) {  productRepository.save(product);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}

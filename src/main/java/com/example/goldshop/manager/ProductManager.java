package com.example.goldshop.manager;

import com.example.goldshop.dto.ProductDTO;
import com.example.goldshop.dto.ProductDTOManager;
import com.example.goldshop.dto.ProductPageResponse;
import com.example.goldshop.entity.Product;
import com.example.goldshop.exception.ProductNotFoundException;
import com.example.goldshop.mapper.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public ProductPageResponse getAll(int page, int count) {
        Page<Product> productPage=productRepository.findAll(PageRequest.of(page,count));


        return new ProductPageResponse(
                productPage.getContent().stream().map(productMapper::toProductDTO).toList(),
                productPage.getTotalElements(),
                productPage.getTotalPages(),
                productPage.hasNext()
        );
    }

    @Override
    public ProductDTO getById(int id) { return productRepository.findById(id)
            .stream()
            .map(productMapper::toProductDTO)
            .findFirst().orElseThrow(()->new ProductNotFoundException("Mehsul tapilmadi"));
    }

    @Override
    public void addProduct(ProductDTO productDTO) {
        productRepository.save(productMapper.toEntity(productDTO));
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }



}

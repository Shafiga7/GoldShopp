package com.example.goldshop.controller;
import com.example.goldshop.dto.ProductDTO;
import com.example.goldshop.dto.ProductPageResponse;
import com.example.goldshop.entity.Product;
import com.example.goldshop.manager.ProductManager;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductManager productManager;
    public ProductController(ProductManager productManager) {
        this.productManager = productManager;
    }

    @GetMapping
    public ProductPageResponse getAll(@RequestParam (value="page")int page, @RequestParam(value="count")int count) {
        return productManager.getAll(page,count);

    }

    @GetMapping("/{id}")
    public ProductDTO getById(@PathVariable int id){ return productManager.getById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public void addCategory (@RequestBody ProductDTO productDTO){
        productManager.addProduct(productDTO);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteUser(@PathVariable int id){
        productManager.deleteProduct(id);
    }
}

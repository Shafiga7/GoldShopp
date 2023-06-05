package com.example.goldshop.controller;
import com.example.goldshop.dto.ProductDTO;
import com.example.goldshop.entity.Product;
import com.example.goldshop.manager.ProductManager;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private final ProductManager productManager;


    @GetMapping
    public List<ProductDTO> getAll(){ return productManager.getAll();
    }

    @GetMapping("/{id}")
    public ProductDTO getById(@PathVariable int id){ return productManager.getById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addCategory (@RequestBody Product product){
        System.out.println(product.getCategory());
        productManager.addProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        productManager.deleteProduct(id);
    }
}

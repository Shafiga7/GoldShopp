package com.example.goldshop.controller;

import com.example.goldshop.dto.CategoryDTO;
import com.example.goldshop.entity.Category;
import com.example.goldshop.manager.CategoryManager;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

    Logger logger = LoggerFactory.getLogger(CategoryController.class);
    private final CategoryManager categoryManager;



    @GetMapping
    public List<CategoryDTO> getAll(){
        logger.info("getAll request accepted");
        return categoryManager.getAll();
    }

    @GetMapping("/{id}")
    public CategoryDTO getById(@PathVariable int id){
        return categoryManager.getById(id);
    }

    @PostMapping
    public void addCategory(@RequestBody Category category){
        categoryManager.addCategory(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable int id){
        categoryManager.deleteCategory(id);
    }
}

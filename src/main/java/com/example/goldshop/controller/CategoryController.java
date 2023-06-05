package com.example.goldshop.controller;

import com.example.goldshop.dto.CategoryDTO;
import com.example.goldshop.dto.CategoryPageResponse;
import com.example.goldshop.manager.CategoryManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    Logger logger= LoggerFactory.getLogger(CategoryController.class);
    private final CategoryManager categoryManager;



    public CategoryController(CategoryManager categoryManager) {
        this.categoryManager = categoryManager;
    }
    @GetMapping
    public CategoryPageResponse getAll(@RequestParam(value = "page") int page, @RequestParam(value="count") int count){
        logger.info("getAll request accepted");
        return categoryManager.getAll(page,count);

    }

    @GetMapping("/{id}")
    public CategoryDTO getById(@PathVariable int id){
        return categoryManager.getById(id);
    }

    @PostMapping
    @ResponseStatus(code= HttpStatus.CREATED)
    public void addCategory(@RequestBody CategoryDTO categoryDTO){
        categoryManager.addCategory(categoryDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable int id){
        categoryManager.deleteCategory(id);
    }
}

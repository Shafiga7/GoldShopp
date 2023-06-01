package com.example.goldshop.controller;

import com.example.goldshop.dto.CategoryDTO;
import com.example.goldshop.entity.Category;
import com.example.goldshop.manager.CategoryManager;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryManager categoryManager;
//jhbjb


    @GetMapping
    public List<CategoryDTO> getAll(){
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

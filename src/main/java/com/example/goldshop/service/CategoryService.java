package com.example.goldshop.service;

import com.example.goldshop.dto.CategoryDTO;
import com.example.goldshop.entity.Category;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getAll();
    CategoryDTO getById( int id);
    void addCategory(Category category);
    void deleteCategory(int id);
}

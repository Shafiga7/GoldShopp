package com.example.goldshop.service;

import com.example.goldshop.dto.CategoryDTO;
import com.example.goldshop.dto.CategoryPageResponse;
import com.example.goldshop.entity.Category;

import java.util.List;

public interface CategoryService {

    CategoryPageResponse getAll(int page, int count);
    CategoryDTO getById( int id);
    void addCategory(CategoryDTO categoryDTO);

    void deleteCategory(int id);
}

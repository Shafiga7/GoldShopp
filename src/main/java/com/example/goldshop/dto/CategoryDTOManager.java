package com.example.goldshop.dto;

import com.example.goldshop.entity.Category;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class CategoryDTOManager implements Function<Category, CategoryDTO> {

    public CategoryDTO apply(Category category) {
        return new CategoryDTO(
                category.getName());
    }
}

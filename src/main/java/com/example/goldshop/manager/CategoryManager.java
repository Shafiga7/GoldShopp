package com.example.goldshop.manager;

import com.example.goldshop.dto.CategoryDTO;
import com.example.goldshop.dto.CategoryDTOManager;
import com.example.goldshop.entity.Category;
import com.example.goldshop.exception.CategoryNotFoundException;
import com.example.goldshop.mapper.CategoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.goldshop.repository.CategoryRepository;
import com.example.goldshop.service.CategoryService;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryDTOManager categoryDTOManager;

    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryDTO> getAll() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toCategoryDto)
                .toList();
    }

    @Override
    public CategoryDTO getById(int id) { return categoryRepository.findById(id)
            .stream()
            .map(categoryMapper::toCategoryDto)
            .findFirst().orElseThrow(()->new CategoryNotFoundException("Kateqoriya tapilmadi"));
    }

    @Override
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(int id) {
        categoryRepository.deleteById(id);
    }



}


package com.example.goldshop.manager;

import com.example.goldshop.dto.CategoryDTO;
import com.example.goldshop.dto.CategoryDTOManager;
import com.example.goldshop.dto.CategoryPageResponse;
import com.example.goldshop.entity.Category;
import com.example.goldshop.exception.CategoryNotFoundException;
import com.example.goldshop.mapper.CategoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.example.goldshop.repository.CategoryRepository;
import com.example.goldshop.service.CategoryService;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryDTOManager categoryDTOManager;

    private final CategoryMapper categoryMapper;

    @Override
    public CategoryPageResponse getAll(int page, int count) {

        Page<Category> categoryPage=categoryRepository.findAll(PageRequest.of(page,count));

        return new CategoryPageResponse(
                categoryPage.getContent().stream().map(categoryMapper::toCategoryDTO).toList(),
                categoryPage.getTotalElements(),
                categoryPage.getTotalPages(),
                categoryPage.hasNext()
        );
    }

    @Override
    public CategoryDTO getById(int id) { return categoryRepository.findById(id)
            .stream()
            .map(categoryMapper::toCategoryDTO)
            .findFirst().orElseThrow(()->new CategoryNotFoundException("Kateqoriya tapilmadi"));
    }

    @Override
    public void addCategory(CategoryDTO categoryDTO) {
        categoryRepository.save(categoryMapper.toEntity(categoryDTO));
    }

    @Override
    public void deleteCategory(int id) {
        categoryRepository.deleteById(id);
    }



}


package com.example.goldshop.mapper;


import com.example.goldshop.dto.CategoryDTO;
import com.example.goldshop.entity.Category;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper {
    Category toEntity(CategoryDTO categoryDTO);

   CategoryDTO toCategoryDto(Category category);
}

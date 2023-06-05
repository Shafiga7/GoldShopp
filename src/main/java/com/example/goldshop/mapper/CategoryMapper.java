package com.example.goldshop.mapper;


import com.example.goldshop.dto.CategoryDTO;
import com.example.goldshop.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDTO toCategoryDTO (Category category);

    Category toEntity (CategoryDTO categoryDTO);
}

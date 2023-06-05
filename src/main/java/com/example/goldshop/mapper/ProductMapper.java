package com.example.goldshop.mapper;

import com.example.goldshop.dto.ProductDTO;
import com.example.goldshop.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toProductDTO(Product product);

    Product toEntity(ProductDTO productDTO);


}

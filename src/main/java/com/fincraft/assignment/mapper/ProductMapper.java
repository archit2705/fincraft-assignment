package com.fincraft.assignment.mapper;

import com.fincraft.assignment.dtos.ProductDto;
import com.fincraft.assignment.dtos.UserDto;
import com.fincraft.assignment.entities.Product;
import com.fincraft.assignment.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "id", ignore = true) // Ignore mapping for the "id" field
    Product dtoToEntity(ProductDto productDto);

    ProductDto entityToDto(Product product);
}

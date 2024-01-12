package com.fincraft.assignment.mapper;

import com.fincraft.assignment.dtos.UserDto;
import com.fincraft.assignment.entities.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "id", ignore = true) // Ignore mapping for the "id" field
    User dtoToEntity(UserDto userDto);


    UserDto entityToDto(User user);

}

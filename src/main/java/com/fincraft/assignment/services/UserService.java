package com.fincraft.assignment.services;

import com.fincraft.assignment.dtos.UserDto;
import com.fincraft.assignment.entities.User;
import com.fincraft.assignment.exceptions.BadRequest;
import com.fincraft.assignment.mapper.UserMapper;
import com.fincraft.assignment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository=userRepository;
        this.userMapper = userMapper;
    }

    public User saveUser(UserDto userDto) throws Exception{
        if (userRepository.findByUsername(userDto.getUsername()).get().size() > 0) {
            throw new BadRequest("Username already exists");
        }

        User user = userMapper.INSTANCE.dtoToEntity(userDto);
        userRepository.save(user);
        return user;

    }
}

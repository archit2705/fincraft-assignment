package com.fincraft.assignment.controllers;

import com.fincraft.assignment.dtos.UserDto;
import com.fincraft.assignment.entities.User;
import com.fincraft.assignment.exceptions.BadRequest;
import com.fincraft.assignment.services.UserService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;


@Component
@RestController
@RequestMapping("v1/productCatalog")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService=userService;
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody @Valid UserDto userDto) throws Exception{
        // Additional validation or logic can be added before saving
        try {
            return userService.saveUser(userDto);
        } catch (RuntimeException ex) {
            throw ex;
        }
    }
}

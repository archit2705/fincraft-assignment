package com.fincraft.assignment.dtos;

import com.fincraft.assignment.validation.ValidUserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@Validated
@AllArgsConstructor
@Builder
@ValidUserDto
public class UserDto {

    private Long id;
    @NotEmpty(message = "user's name cannot be be blank/empty")
    private String name;
    @NotEmpty(message = "user's username cannot be blank/empty")
    private String username;
    @NotEmpty(message = "user's email cannot be blank/empty")
    private String email;
    @NotEmpty(message = "user's password cannot be blank/empty")
    private String password; // For now storing password as a string, can be converted to hash going forwards

}

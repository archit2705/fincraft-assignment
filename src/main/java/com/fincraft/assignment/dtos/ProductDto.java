package com.fincraft.assignment.dtos;

import com.fincraft.assignment.validation.ValidProductDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@Validated
@AllArgsConstructor
@Builder
@ValidProductDto
public class ProductDto {

    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "description is required")
    private String description;

    private Integer inventory;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than zero")
    private Double price;

    private String brand;

    private String imageUrl;

    private Long createdDate;

    @NotEmpty(message = "createdBy is required where createdBy = username")
    private String createdBy;
}

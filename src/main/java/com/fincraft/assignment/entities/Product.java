package com.fincraft.assignment.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@Data
@AllArgsConstructor
public class Product {

    @Id
    private String id;
    private String name;
    private String description;
    private Integer inventory;
    private Double price;
    private String brand;
    private String imageUrl;
    @CreatedDate
    private Long createdDate;
    private String createdBy;
}

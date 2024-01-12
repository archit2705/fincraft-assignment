package com.fincraft.assignment.repository;

import com.fincraft.assignment.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {
    Optional<Product> getProductById(String id);
}

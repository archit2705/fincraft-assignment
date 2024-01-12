package com.fincraft.assignment.services;

import com.fincraft.assignment.dtos.ProductDto;
import com.fincraft.assignment.entities.Product;
import com.fincraft.assignment.exceptions.BadRequest;
import com.fincraft.assignment.exceptions.NotFound;
import com.fincraft.assignment.mapper.ProductMapper;
import com.fincraft.assignment.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@Service
public class ProductService {
    private ProductRepository productRepository;
    private ProductMapper productMapper;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository=productRepository;
        this.productMapper=productMapper;
    }

    public Product createProduct(ProductDto productDto) {
        Product product = productMapper.INSTANCE.dtoToEntity(productDto);
        productRepository.save(product);
        return product;
    }

    public Page<Product> getAllProducts(PageRequest pageable) {
        return productRepository.findAll(pageable);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    public long getTotalProducts() {
        return productRepository.count();
    }

    public Product findProductById(String id) {
        Optional<Product> product = productRepository.findById(id);
        if(!product.isPresent())
            throw new NotFound("Product with id = " + id + " not found");
        return product.get();
    }

}

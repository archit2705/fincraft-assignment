package com.fincraft.assignment.controllers;


import com.fincraft.assignment.dtos.ProductDto;
import com.fincraft.assignment.entities.Product;
import com.fincraft.assignment.exceptions.BadRequest;
import com.fincraft.assignment.exceptions.NoContent;
import com.fincraft.assignment.exceptions.NotFound;
import com.fincraft.assignment.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Component
@RestController
@RequestMapping("v1/productCatalog/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService=productService;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductDto product) {
        Product createdProduct = productService.createProduct(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "10") int size
    ) {
        if (page >= 0 && size > 0) {

            Page<Product> products = productService.getAllProducts(PageRequest.of(page, size));

            if (page >= products.getTotalPages()) {
                throw new BadRequest("asked page is not available");
            }

            long totalProducts = productService.getTotalProducts();
            return ResponseEntity.ok()
                    .header("X-Total-Count", String.valueOf(totalProducts))
                    .body(products.getContent());
        } else {
            List<Product> products = productService.getAllProducts();
            if(products.size() == 0)
                throw new NoContent("No Products found in the database");
            return ResponseEntity.ok().body(products);
        }
    }

    @GetMapping("/{productId}")
    public ResponseEntity<?> getProductById(@PathVariable String productId) {
        try {
            Product product = productService.findProductById(productId);
            return ResponseEntity.ok(product);
        } catch (NotFound ex) {
            throw ex;
        }
    }




}

package com.umutyenidil.springcommerce2.controller;

import com.umutyenidil.springcommerce2.dto.ProductCreateRequest;
import com.umutyenidil.springcommerce2.dto.ProductResponse;
import com.umutyenidil.springcommerce2.model.Product;
import com.umutyenidil.springcommerce2.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
@RestController
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(
            @RequestBody ProductCreateRequest request
    ) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productService.saveProduct(request));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAllProducts() {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.findAllProducts());
    }
}

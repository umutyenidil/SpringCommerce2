package com.umutyenidil.springcommerce2.service;

import com.umutyenidil.springcommerce2.dto.ProductCreateRequest;
import com.umutyenidil.springcommerce2.dto.ProductResponse;
import com.umutyenidil.springcommerce2.model.Product;
import com.umutyenidil.springcommerce2.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponse saveProduct(ProductCreateRequest request) {

        var product = Product.builder()
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .build();

        var savedProduct = productRepository.save(product);

        log.info("Product saved");

        return ProductResponse.builder()
                .id(savedProduct.getId())
                .name(savedProduct.getName())
                .description(savedProduct.getDescription())
                .price(savedProduct.getPrice())
                .build();
    }

    public List<ProductResponse> findAllProducts() {

        return productRepository.findAll()
                .stream()
                .map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice()))
                .toList();
    }
}

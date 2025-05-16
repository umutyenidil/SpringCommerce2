package com.umutyenidil.springcommerce2.repository;

import com.umutyenidil.springcommerce2.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}

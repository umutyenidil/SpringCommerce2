package com.umutyenidil.springcommerce2.repository;

import com.umutyenidil.springcommerce2.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}

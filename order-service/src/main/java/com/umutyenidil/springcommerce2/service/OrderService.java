package com.umutyenidil.springcommerce2.service;

import com.umutyenidil.springcommerce2.client.InventoryClient;
import com.umutyenidil.springcommerce2.dto.OrderCreateRequest;
import com.umutyenidil.springcommerce2.model.Order;
import com.umutyenidil.springcommerce2.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    public void placeOrder(OrderCreateRequest request) {
        var isProductInStock = inventoryClient.isInStock(request.sku(), request.quantity());

        if(!isProductInStock) throw new RuntimeException("Product is not in stock");

        var order = Order.builder()
                .no(UUID.randomUUID().toString())
                .sku(request.sku())
                .quantity(request.quantity())
                .price(request.price())
                .build();

        orderRepository.save(order);
    }
}

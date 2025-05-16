package com.umutyenidil.springcommerce2.controller;

import com.umutyenidil.springcommerce2.dto.OrderCreateRequest;
import com.umutyenidil.springcommerce2.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
@RestController
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<?> saveOrder(
            @RequestBody OrderCreateRequest request
    ) {

        orderService.placeOrder(request);

        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }
}

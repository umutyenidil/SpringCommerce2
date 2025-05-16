package com.umutyenidil.springcommerce2.dto;

import java.math.BigDecimal;

public record ProductCreateRequest(

        String id,
        String name,
        String description,
        BigDecimal price
) {
}

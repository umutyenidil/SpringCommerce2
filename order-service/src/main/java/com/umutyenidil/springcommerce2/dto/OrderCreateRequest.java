package com.umutyenidil.springcommerce2.dto;

import java.math.BigDecimal;

public record OrderCreateRequest(

        String sku,
        Integer quantity,
        BigDecimal price
) {
}

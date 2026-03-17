package co.istad.wattana.a01a1webmvc.dto;

import java.math.BigDecimal;

public record CreateProductRequest(
        String name,
        BigDecimal price,
        Integer categoryId
) {
}

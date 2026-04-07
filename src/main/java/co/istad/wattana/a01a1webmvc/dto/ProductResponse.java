package co.istad.wattana.a01a1webmvc.dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductResponse(
        String code,
        String name,
        BigDecimal price,
        boolean status,
        String categoryName
) {
}

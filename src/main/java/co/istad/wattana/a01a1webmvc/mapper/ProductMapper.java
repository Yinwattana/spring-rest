package co.istad.wattana.a01a1webmvc.mapper;


import co.istad.wattana.a01a1webmvc.domain.Product;
import co.istad.wattana.a01a1webmvc.dto.ProductResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductResponse prodcutToProductResponse(Product product){
        return ProductResponse.builder()
                .code(product.getCode())
                .name(product.getName())
                .price(product.getPrice())
                .status(product.getStatus())
                .categoryName(product.getCategory().getName())
                .build();
    }
}

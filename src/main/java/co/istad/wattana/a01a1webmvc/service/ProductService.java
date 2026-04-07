package co.istad.wattana.a01a1webmvc.service;

import co.istad.wattana.a01a1webmvc.dto.CreateProductRequest;
import co.istad.wattana.a01a1webmvc.dto.ProductResponse;
import co.istad.wattana.a01a1webmvc.dto.UpdateProductRequest;
import org.springframework.data.domain.Page;

public interface ProductService {

    ProductResponse patchProductByCode(String code, UpdateProductRequest updateProductRequest);

    ProductResponse getProductByCode(String code);

    Page<ProductResponse>getProducts(int pageNumber, int pageSize);

    ProductResponse createNewProduct(CreateProductRequest createProductRequest);
}

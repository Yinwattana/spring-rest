package co.istad.wattana.a01a1webmvc.service;

import co.istad.wattana.a01a1webmvc.dto.CreateProductRequest;
import co.istad.wattana.a01a1webmvc.dto.ProductResponse;

public interface ProductService {
    ProductResponse createNewProduct(CreateProductRequest createProductRequest);
}

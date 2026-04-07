package co.istad.wattana.a01a1webmvc.controller;


import co.istad.wattana.a01a1webmvc.dto.CreateProductRequest;
import co.istad.wattana.a01a1webmvc.dto.ProductResponse;
import co.istad.wattana.a01a1webmvc.dto.UpdateProductRequest;
import co.istad.wattana.a01a1webmvc.service.ProductService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@Slf4j
public class ProductController
{
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public ProductResponse getProductByCode(@PathVariable String code){
        log.info("getProductBycode: {}", code);
        return productService.getProductByCode(code);
    }

    @GetMapping
    public Page<ProductResponse> getProducts(
            @RequestParam(required = false, defaultValue = "0") int pageNumber,
            @RequestParam(required = false, defaultValue = "20") int pageSize
    ) {
        log.info("page Number :{}, pageSize :{}",
                 pageNumber,
                 pageSize);
        return productService.getProducts(pageNumber,pageSize);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ProductResponse createNewProduct(
           @Valid @RequestBody CreateProductRequest productCreateRequest
    ){
        log.info("createProductRequest :{}",productCreateRequest);
        return null;
    }

    @PutMapping("/{code}")
    public void updateProductByCode(
            @PathVariable String code,
            @RequestBody UpdateProductRequest updateProductRequest
    ){
        log.info("updateProductByCode :{}", code);
        log.info("updateProductRequest :{}", updateProductRequest);
    }


    @PatchMapping("/{code}")
    public ProductResponse patchProductByCode(
            @PathVariable String code,
           @Valid @RequestBody UpdateProductRequest updateProductRequest
    ){log.info("patchProductByCode :{}", code);
        log.info("patchProductRequest :{}", updateProductRequest);
        return productService.patchProductByCode(code, updateProductRequest);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{code}")
    public void deleteProductByCode(@PathVariable  String code){
        log.info("deleteProductByCode :{}", code);
    }
}

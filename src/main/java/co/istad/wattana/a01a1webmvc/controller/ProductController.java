package co.istad.wattana.a01a1webmvc.controller;


import co.istad.wattana.a01a1webmvc.dto.ProductCreateRequest;
import co.istad.wattana.a01a1webmvc.dto.ProductResponse;
import co.istad.wattana.a01a1webmvc.dto.UpdateProductRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@Slf4j
public class ProductController
{
    public ProductResponse getProductByCode(@PathVariable String code){
        log.info("getProductBycode: {}", code);
        return null;
    }

    @GetMapping
    public List<ProductResponse>  getProducts(
            @RequestParam(required = false, defaultValue = "0") int PageNumber,
            @RequestParam(required = false, defaultValue = "20") int PageSize,
            @RequestParam(required = false,defaultValue = "")String name
    ) {
        log.info("Page Number :{}, PageSize :{}, name: {}"
                , name
                , PageNumber
                , PageSize);
        return List.of();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createNewProduct(
            @RequestBody ProductCreateRequest productCreateRequest
    ){
        log.info("createProductRequest :{}",productCreateRequest);
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
    public void patchProductByCode(
            @PathVariable String code,
            @RequestBody UpdateProductRequest updateProductRequest
    ){log.info("patchProductByCode :{}", code);
        log.info("patchProductRequest :{}", updateProductRequest);

    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{code}")
    public void deleteProductByCode(@PathVariable  String code){
        log.info("deleteProductByCode :{}", code);
    }
}

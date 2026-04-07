package co.istad.wattana.a01a1webmvc.service;

import co.istad.wattana.a01a1webmvc.domain.Category;
import co.istad.wattana.a01a1webmvc.domain.Product;
import co.istad.wattana.a01a1webmvc.dto.CreateProductRequest;
import co.istad.wattana.a01a1webmvc.dto.ProductResponse;
import co.istad.wattana.a01a1webmvc.dto.UpdateProductRequest;
import co.istad.wattana.a01a1webmvc.mapper.ProductMapper;
import co.istad.wattana.a01a1webmvc.repository.CategoryRepository;
import co.istad.wattana.a01a1webmvc.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
public class ProductSeviceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    public ProductSeviceImpl(CategoryRepository categoryRepository,
                             ProductRepository productRepository,
                             ProductMapper productMapper) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductResponse patchProductByCode(String code, UpdateProductRequest updateProductRequest) {
        //Todo
        Product foundProduct = productRepository.findById(code)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Product code not found"
                ));
        if (updateProductRequest.name() != null)
            foundProduct.setName(updateProductRequest.name());

        if (updateProductRequest.price() != null)
            foundProduct.setPrice(updateProductRequest.price());

        if (updateProductRequest.status() != null)
            foundProduct.setStatus(updateProductRequest.status());

        if (updateProductRequest.categoryId() != null) {
            Category foundCategory = categoryRepository
                    .findById(updateProductRequest.categoryId())
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                            "Category ID doesn't exist"
                    ));
            foundProduct.setCategory(foundCategory);
        }
        Product updateProduct = productRepository.save(foundProduct);

        return productMapper.prodcutToProductResponse(updateProduct);

    }

    @Override
    public ProductResponse getProductByCode(String code) {
        // TODO: Select a product from database by code
        return productRepository.findById(code)
                .map(productMapper::prodcutToProductResponse)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Product code not found!"
                ));
    }

    public Page<ProductResponse> getProducts(int pageNumber, int pageSize){
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        Page<Product> productPage = productRepository.findAll(pageable);

        return productPage.map(productMapper::prodcutToProductResponse);
    }

    @Override
    public ProductResponse createNewProduct(CreateProductRequest createProductRequest) {

        Category category = categoryRepository
                .findById(createProductRequest.categoryId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Category ID doesn't exist"
                ));


        log.info("Category: {}", category.getId());
        return null;
    }
}

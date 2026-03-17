package co.istad.wattana.a01a1webmvc.service;

import co.istad.wattana.a01a1webmvc.domain.Category;
import co.istad.wattana.a01a1webmvc.dto.CreateProductRequest;
import co.istad.wattana.a01a1webmvc.dto.ProductResponse;
import co.istad.wattana.a01a1webmvc.repository.CategoryRepository;
import co.istad.wattana.a01a1webmvc.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductSeviceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductSeviceImpl(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }


    @Override
    public ProductResponse createNewProduct(CreateProductRequest createProductRequest) {

        Category category = categoryRepository
                .findById(createProductRequest.categoryId())
                .orElseThrow(() -> new RuntimeException("Category ID doesn't exist"));
        log.info("Category: {}", category.getId());
        return null;
    }
}

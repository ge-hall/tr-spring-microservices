package io.integrant.productservice.service;

import io.integrant.productservice.dto.ProductRequest;
import io.integrant.productservice.dto.ProductResponse;
import io.integrant.productservice.model.Product;
import io.integrant.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
   private final ProductRepository productRepository;
    public void createProduct(ProductRequest productRequest) {
        Product product =  Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        log.info("Product created: {}", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products =  productRepository.findAll();
        return products.stream().map(product -> {
            return ProductResponse.builder()
                   .id(product.getId())
                   .name(product.getName())
                   .description(product.getDescription())
                   .price(product.getPrice())
                   .build();
        }).toList();
    }
}

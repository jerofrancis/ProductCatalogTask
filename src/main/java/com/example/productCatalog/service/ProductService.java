package com.example.productCatalog.service;

import com.example.productCatalog.dto.ProductDto;
import com.example.productCatalog.entity.Product;

import java.util.List;

public interface ProductService {

    void save(ProductDto productDto);

    ProductDto getById(Long id);

    List<Product> getAllProduct();

}

package com.example.productCatalog.service.impl;

import com.example.productCatalog.dto.ProductDto;
import com.example.productCatalog.entity.Product;
import com.example.productCatalog.repository.ProductRepository;
import com.example.productCatalog.service.ProductService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelmapper;

    Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Override
    public void save(ProductDto productDto) {
        productRepository.save(modelmapper.map(productDto, Product.class));
    }

    @Override
    public ProductDto getById(Long id) {

        Optional<Product> optionalEmployee = productRepository.findById(id);
        Product product = null;

        if(optionalEmployee.isPresent()){
            product = optionalEmployee.get();
        }else {
            throw new RuntimeException("Employee not Fount for id : " + id);
        }

        return modelmapper.map(productRepository.getById(id), ProductDto.class);
    }

    @Override
    public List<Product> getAllProduct() {
        logger.info("Inside Product Service Impl");
        return productRepository.findAll();
    }

}

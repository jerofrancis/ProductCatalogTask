package com.example.productCatalog.controller;

import com.example.productCatalog.dto.ProductDto;
import com.example.productCatalog.entity.Product;
import com.example.productCatalog.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @GetMapping("/")
    public String viewHomePage(Model model){
        return "index";
    }

    @GetMapping("/ProductsView")
    public String viewProduct(Model model){
        logger.trace("Trace");
        logger.info("Info Level");
        logger.debug("Debug level");
        logger.error("Error level");
        logger.warn("Warning level");
        model.addAttribute("allproductlist", productService.getAllProduct());
        logger.info("Completed save & returning back :" + model.getAttribute("allemplist"));
        return "showProduct";
    }



    @GetMapping("/addnew")
    public String addNewEmployee(Model model){
        //map to dto & handle entity
        Product product = new Product();
        model.addAttribute("product", product);
        return "newproduct";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("product") ProductDto productDto){
        productService.save(productDto);
        return "redirect:/";
    }
}

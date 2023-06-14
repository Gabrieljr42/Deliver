package com.deadManWalking.demo.controller;

import com.deadManWalking.demo.entity.Product;
import com.deadManWalking.demo.service.ProductService;
import com.deadManWalking.demo.service.ImageGenerationService;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;



@Controller
public class ProductController {



    private final ImageGenerationService imageGenerationService;
    private final ProductService productService;
    
    public ProductController(ProductService productService,  ImageGenerationService imageGenerationService) {
        this.productService = productService;
        this.imageGenerationService = imageGenerationService;
    }

    @PostMapping("/products")  
    public String createProduct(@ModelAttribute Product product, Model model) {  
    
        String imageUrl = imageGenerationService.generateImage(product.getDescription());
        
        product.setImageUrl(imageUrl);

        productService.saveProduct(product);  
        model.addAttribute("products", productService.findAll());
        return "productList";  
    }
    @GetMapping("/addProduct")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "addProduct";
    }
    @GetMapping("/products")
    public String getAllProducts(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "productList";
    }
    @GetMapping("/home")
    public String getProductsHome(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "home";
    }
   
}
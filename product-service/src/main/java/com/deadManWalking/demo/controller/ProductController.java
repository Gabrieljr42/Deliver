package com.deadManWalking.demo.controller;

import com.deadManWalking.demo.entity.Product;
import com.deadManWalking.demo.service.ProductService;
import com.deadManWalking.demo.service.ImageGenerationService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


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
        // Generate an image based on the product description
        // String imageUrl = imageGenerationService.generateImage(product.getDescription());
        String imageUrl = "https://oaidalleapiprodscus.blob.core.windows.net/private/org-aVxxwbvScHivlhw3hDK9qcWM/user-HC8m5fl5Nw0rxKuROLdnjGLs/img-8LXiT9lCzCwaIbqwJTn0fHrc.png?st=2023-05-28T13%3A54%3A24Z&se=2023-05-28T15%3A54%3A24Z&sp=r&sv=2021-08-06&sr=b&rscd=inline&rsct=image/png&skoid=6aaadede-4fb3-4698-a8f6-684d7786b067&sktid=a48cca56-e6da-484e-a814-9c849652bcb3&skt=2023-05-28T08%3A48%3A26Z&ske=2023-05-29T08%3A48%3A26Z&sks=b&skv=2021-08-06&sig=3Xi8fHP83vG0OJK%2BpdJP71kyPwssqkMzzQBbuipc6wY%3D";
        // Set the image URL on the product
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
    // additional endpoints...
}
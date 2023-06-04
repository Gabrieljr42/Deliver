package com.deadManWalking.demo.controller;


import com.deadManWalking.demo.entity.Product;
import com.deadManWalking.demo.service.ImageGenerationService;
import com.deadManWalking.demo.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.mockito.Mockito.*;

public class ProductControllerTest {

    @Mock
    private ProductService productService;

    @Mock
    private ImageGenerationService imageGenerationService;

    @Mock
    private Model model;

    private ProductController productController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        productController = new ProductController(productService, imageGenerationService);
    }

    @Test
    public void testCreateProduct() {
        
        Product product = new Product();
        product.setDescription("test description");
        when(imageGenerationService.generateImage(product.getDescription())).thenReturn("imageUrl");
        when(productService.saveProduct(any(Product.class))).thenReturn(product);

       
        productController.createProduct(product, model);
        verify(productService).saveProduct(product);
        verify(imageGenerationService).generateImage(product.getDescription());
    }

}

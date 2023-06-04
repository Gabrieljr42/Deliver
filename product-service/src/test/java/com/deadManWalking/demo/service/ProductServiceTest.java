package com.deadManWalking.demo.service;

import com.deadManWalking.demo.entity.Product;
import com.deadManWalking.demo.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    private ProductService productService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        productService = new ProductService(productRepository);
    }

    @Test
    public void testSaveProduct() {

        Product product = new Product();
        product.setDescription("test description");
        when(productRepository.save(product)).thenReturn(product);


        productService.saveProduct(product);
        verify(productRepository).save(product);
    }


}

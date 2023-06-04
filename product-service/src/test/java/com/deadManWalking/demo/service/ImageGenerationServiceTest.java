package com.deadManWalking.demo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

import java.io.IOException;

public class ImageGenerationServiceTest {

    @Mock
    private RestTemplate restTemplate;

    private ImageGenerationService imageGenerationService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        imageGenerationService = new ImageGenerationService(restTemplate);
    }

    @Test
    public void testGenerateImage() throws IOException {
        
        String responseBody = "{\"data\": [{\"url\": \"testImageUrl\"}]}";
        ResponseEntity<String> responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);

        when(restTemplate.exchange(
                anyString(), 
                any(HttpMethod.class), 
                any(HttpEntity.class),
                eq(String.class)
        )).thenReturn(responseEntity);


        String imageUrl = imageGenerationService.generateImage("test prompt");

      
        assertNotNull(imageUrl);
        assertEquals("testImageUrl", imageUrl);
    }
}


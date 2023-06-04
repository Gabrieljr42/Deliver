package com.deadManWalking.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Collections;

@Service
public class ImageGenerationService {
    private final RestTemplate restTemplate;

    @Value("${openai.api.key}")
    private String apiKey;

    public ImageGenerationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String generateImage(String prompt) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    headers.set("Authorization", "Bearer " + apiKey);

    String body = "{ \"prompt\": \"" + prompt + "\", \"n\":1, \"size\":\"512x512\" }";

    HttpEntity<String> entity = new HttpEntity<>(body, headers);

    ResponseEntity<String> response = restTemplate.exchange(
            "https://api.openai.com/v1/images/generations",
            HttpMethod.POST,
            entity,
            String.class);
    String responseBody = response.getBody();
    ObjectMapper mapper = new ObjectMapper();
    try {
        JsonNode rootNode = mapper.readTree(responseBody);
        String imageUrl = rootNode.path("data").get(0).path("url").asText();
        return imageUrl;
    } catch (IOException e) {
        // Handle the exception
        e.printStackTrace();
        return null;
    }
}

}

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

    @Value("${openai.api.key}")
    private String apiKey;

    public String generateImage(String prompt) {
        return "https://oaidalleapiprodscus.blob.core.windows.net/private/org-aVxxwbvScHivlhw3hDK9qcWM/user-HC8m5fl5Nw0rxKuROLdnjGLs/img-GDR75CxFN86Es6mf7Ns0PrJU.png?st=2023-05-28T15%3A10%3A33Z&se=2023-05-28T17%3A10%3A33Z&sp=r&sv=2021-08-06&sr=b&rscd=inline&rsct=image/png&skoid=6aaadede-4fb3-4698-a8f6-684d7786b067&sktid=a48cca56-e6da-484e-a814-9c849652bcb3&skt=2023-05-28T06%3A52%3A57Z&ske=2023-05-29T06%3A52%3A57Z&sks=b&skv=2021-08-06&sig=0Ic4e8FRDZD%2BMvYbkWuGyEaA%2BfGfkAwOf6FOoQ14GhY%3D";
        // RestTemplate restTemplate = new RestTemplate();

        // HttpHeaders headers = new HttpHeaders();
        // headers.setContentType(MediaType.APPLICATION_JSON);
        // headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        // headers.set("Authorization", "Bearer " + apiKey);

        // String body = "{ \"prompt\": \"" + prompt + "\", \"n\":1, \"size\":\"512x512\" }";

        // HttpEntity<String> entity = new HttpEntity<>(body, headers);
         
        // ResponseEntity<String> response = restTemplate.exchange(
        //         "https://api.openai.com/v1/images/generations",
        //         HttpMethod.POST,
        //         entity,
        //         String.class);
        // String responseBody = response.getBody();
        // ObjectMapper mapper = new ObjectMapper();
        // try {
        //     JsonNode rootNode = mapper.readTree(responseBody);
        //     String imageUrl = rootNode.path("data").get(0).path("url").asText();
        //     return imageUrl;
        // } catch (IOException e) {
        //     // Handle the exception
        //     e.printStackTrace();
        //     return null;
        // }
    }
}

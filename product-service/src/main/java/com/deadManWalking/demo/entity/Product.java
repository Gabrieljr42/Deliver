package com.deadManWalking.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Column(length = 1000)
    private String description;
    private Double price;

    @Column(length = 1000)  // Increase the length to 1000
    private String url;

    public Product() {
       //silence is golden 
    }
    
    public Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    
    public String getUrl() {
        return url;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageUrl(String url){
        this.url = url;
    }
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
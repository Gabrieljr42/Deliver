package com.deadManWalking.demo.service;


import com.deadManWalking.demo.entity.Product;
import com.deadManWalking.demo.repository.ProductRepository;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
    
    public List<Product> findAll() {
        return productRepository.findAll();
    }
    
    // @Bean
    // public CommandLineRunner demo() {
    //     return args -> {
    //         productRepository.save(new Product("Cheeseburger", "Suculento hambúrguer de carne bovina coberto com queijo derretido, servido com alface, tomate e picles", 9.99));
    //         productRepository.save(new Product("Pizza Margherita", "Pizza clássica com molho de tomate, queijo mussarela e folhas frescas de manjericão", 12.99));
    //         productRepository.save(new Product("Salada Caesar", "Alface romana crocante temperada com molho cremoso Caesar, queijo parmesão e croutons", 7.99));
    //         productRepository.save(new Product("Salmão Grelhado", "Filé de salmão fresco grelhado no ponto, servido com legumes no vapor e molho de manteiga de limão", 15.99));
    //         productRepository.save(new Product("Pasta Carbonara", "Espaguete cozido com um molho cremoso à base de bacon, queijo parmesão e pimenta preta", 10.99));
    //         productRepository.save(new Product("Frango Tikka Masala", "Pedaços de frango macios cozidos em um saboroso molho curry à base de tomate, servido com pão naan e arroz", 13.99));
    //         productRepository.save(new Product("Sundae Brownie de Chocolate", "Brownie de chocolate quente coberto com sorvete de baunilha, calda de chocolate e chantilly", 6.99));
    //         productRepository.save(new Product("Manga Lassi", "Bebida refrescante à base de iogurte misturado com manga fresca e um toque de cardamomo", 3.99));
    //         productRepository.save(new Product("Steak Frites", "Bife grelhado servido com batatas fritas crocantes e um acompanhamento de molho aioli de alho cremoso", 18.99));
    //         productRepository.save(new Product("Prato de Sushi", "Variedade de rolinhos de sushi frescos, incluindo atum, salmão, rolo Califórnia e rolo de camarão empanado", 22.99));
    //         productRepository.save(new Product("Camarão Grelhado", "Camarões suculentos grelhados e temperados com ervas, servidos com arroz e legumes", 16.99));
    //         productRepository.save(new Product("Lasanha de Vegetais", "Camadas de macarrão, legumes frescos e queijo, assadas ao forno em um molho de tomate", 11.99));
    //         productRepository.save(new Product("Hambúrguer Vegano", "Hambúrguer vegetariano à base de plantas, acompanhado de alface, tomate e cebola caramelizada", 8.99));
    //         productRepository.save(new Product("Frango à Parmegiana", "Peito de frango empanado, coberto com molho de tomate, queijo derretido e servido com espaguete", 14.99));
    //         productRepository.save(new Product("Risoto de Cogumelos", "Risoto cremoso preparado com uma mistura de cogumelos frescos e queijo parmesão", 12.99));
    //         productRepository.save(new Product("Tacos de Peixe", "Tortilhas de milho macias recheadas com filé de peixe grelhado, repolho, molho de iogurte e coentro", 9.99));
    //         productRepository.save(new Product("Sopa de Cebola Gratinada", "Sopa de cebola com caldo rico, coberta com queijo derretido e torradas crocantes", 6.99));
    //         productRepository.save(new Product("Molho de Queijo e Nachos", "Nachos crocantes acompanhados de um cremoso molho de queijo para mergulhar", 5.99));
    //         productRepository.save(new Product("Frango Teriyaki", "Frango grelhado com molho teriyaki, servido com arroz frito e legumes salteados", 13.99));
    //         productRepository.save(new Product("Ravioli de Queijo", "Massa recheada com queijo ricota e espinafre, servida com molho de tomate fresco", 10.99));
    //         productRepository.save(new Product("Bife à Moda do Chef", "Bife suculento grelhado a seu gosto, acompanhado de batatas assadas e legumes da estação", 19.99));
    //         productRepository.save(new Product("Salada Caprese", "Tomate fatiado, queijo mussarela fresco, manjericão e azeite de oliva extra virgem", 8.99));
    //         productRepository.save(new Product("Ceviche de Camarão", "Camarões frescos marinados em suco de limão cítrico, pimenta e temperos, servidos com tortilhas crocantes", 12.99));
    //         productRepository.save(new Product("Wrap de Frango Caesar", "Tortilha macia recheada com tiras de frango grelhado, alface crocante e molho Caesar", 9.99));
    //         productRepository.save(new Product("Tiramisu", "Sobremesa clássica italiana com camadas de biscoitos de champanhe, café, queijo mascarpone e cacau", 7.99));
    //         productRepository.save(new Product("Chá Gelado de Pêssego", "Chá gelado refrescante com sabor de pêssego natural e um toque de limão", 3.99));
    //         productRepository.save(new Product("Molho BBQ com Costelas", "Costelas suculentas grelhadas e cobertas com molho barbecue defumado, servidas com batatas fritas", 17.99));
    //         productRepository.save(new Product("Wrap Vegetariano", "Tortilha recheada com legumes frescos, hummus e molho de iogurte, acompanhado de batatas fritas", 8.99));
    //         productRepository.save(new Product("Frango ao Curry", "Pedacinhos de frango cozidos em um delicioso molho de curry, servidos com arroz basmati", 13.99));
    //         productRepository.save(new Product("Poke Bowl de Salmão", "Tigela de arroz coberta com cubos de salmão fresco, abacate, pepino e molho de soja", 11.99));
    //         productRepository.save(new Product("Sopa de Tomate", "Sopa de tomate cremosa com um toque de manjericão fresco, servida com croutons crocantes", 5.99));
    //     };
    // }
    
    // additional methods...
}
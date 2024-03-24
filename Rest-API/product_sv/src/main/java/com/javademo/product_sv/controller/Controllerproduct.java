package com.javademo.product_sv.controller;

import com.javademo.product_sv.entity.Product;
import com.javademo.product_sv.entity.User;
import com.javademo.product_sv.repo.Repoproduct;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Controllerproduct {
    @Autowired
    private Repoproduct repoproduct;
    RestTemplate restTemplate = new RestTemplate();
    @GetMapping("/listsp")
    public List<Product> danhsachsp(){
        List<Product> list = new ArrayList<>();
        repoproduct.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @PostMapping("/listsp")
    public Product themsp(Product product){
        repoproduct.save(product);
        return product;
    }
    @GetMapping("/listsp/{id}")
    Product getUserbyID(@PathVariable long id){
        String url = "http://localhost:8081/api/listuser1" + id;
        ResponseEntity<User> reponse = restTemplate.getForEntity(url, User.class);
        Optional<Product> optional = repoproduct.findById(id);
        Product product = null;
        if (optional.isPresent()) {
            product = optional.get();
        } else {
            new RuntimeException("Khong co user theo id này");
        }
        User user = reponse.getBody();
        product.setUser(user);
        return product;
//        User user = restTemplate.getForObject("http://localhost:8081/api/listuser1" + id, User.class);
//        Product product = repoproduct.findById(id).get();
//        product.setUser(user);
//        return product;

    }

//    @PostConstruct
//    public void themSPid1(){
//        Product product = new Product();
//        User user = new User();
//        product.setId(1);
//        product.setName("Xa phong");
//        product.setGia(2000);
//        product.setUser(new User(3,"Nguyen Vi"));
//        repoproduct.save(product);
//    }

}

package com.javademo.product.controller;

import com.javademo.product.entity.EntityProduct;
import com.javademo.product.repo.RepoProduct;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/myservice")
public class ControllerProduct {
    @Autowired
    RepoProduct repoProduct;

    @GetMapping("/listproduct")
    public List<EntityProduct> listProducts(){
        List<EntityProduct> list = new ArrayList<>();
        repoProduct.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

@PostConstruct
    public void saveSP(){
    EntityProduct product = new EntityProduct();
    product.setId(1);
    product.setTenSP("Sua tam");
    product.setGia(20);
    repoProduct.save(product);

}
@PostMapping("/listproduct")
    public EntityProduct listProduct(@RequestBody EntityProduct entityProduct){
        repoProduct.save(entityProduct);
        return entityProduct;
}





}

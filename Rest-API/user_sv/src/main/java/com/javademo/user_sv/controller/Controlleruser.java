package com.javademo.user_sv.controller;

import com.javademo.user_sv.entity.User;
import com.javademo.user_sv.repositori.RepoUser;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Controlleruser {
    @Autowired
    RepoUser repoUser;
    @GetMapping("/listuser1")

    public List<User> listUSer(){
        List<User> list = new ArrayList<>();
        repoUser.findAll().iterator().forEachRemaining(list::add);
        return list;
    }
    @PostConstruct
    public void taoUser(){
        User user = new User();
        user.setId(1);
        user.setName("Tuong Vi");
        repoUser.save(user);
    }
    @PostMapping("listuser1")
    public User themuser(@RequestBody User user){
        repoUser.save(user);
        return user;
    }
    @GetMapping("/listuser1/{id}")
    User getUserbyID(@PathVariable Long id) {
        Optional<User> optional = repoUser.findById(id);
        User user = null;
        if (optional.isPresent()) {
            user = optional.get();
        } else {
            new RuntimeException("Khong co user theo id này");
        }
        return user;
    }

}

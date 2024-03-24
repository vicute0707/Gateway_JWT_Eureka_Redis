package com.javademo.user.controller;

import com.javademo.user.entity.EntityUser;
import com.javademo.user.repo.RepoUser;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/myservice")
public class ControllerUser {
    @Autowired
    RepoUser repouser;

    @GetMapping("/listuser")

    public List<EntityUser> listUser(){
        List<EntityUser> list= new ArrayList<>();
        repouser.findAll().iterator().forEachRemaining(list::add);
        return list;
    }
@PostConstruct
    public void saveUser(){
    EntityUser user = new EntityUser();
    user.setId(1);
    user.setUsename("Nguyen Thi Tuong Vi");
    user.setAge(18);
    repouser.save(user);
}
@PostMapping("/listuser")
    public EntityUser listUser(@RequestBody EntityUser entityUser){
        repouser.save(entityUser);
        return entityUser;
}

}

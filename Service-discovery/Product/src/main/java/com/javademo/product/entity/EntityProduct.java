package com.javademo.product.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@AllArgsConstructor
@Data
@NoArgsConstructor
@RedisHash("entityuser")
public class EntityProduct {
    @Id
    private int id;
    private String tenSP;
    private float gia;




}

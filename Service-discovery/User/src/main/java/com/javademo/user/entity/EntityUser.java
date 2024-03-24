package com.javademo.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@AllArgsConstructor
@Data
@NoArgsConstructor
@RedisHash("entityuser")
public class EntityUser {
    @Id
    private int id;
    private String usename;
    private int age;
}

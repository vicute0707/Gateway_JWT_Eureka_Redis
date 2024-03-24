package com.javademo.product_sv.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "product")

public class Product {
    @Id
    @Column(name = "product_id")
    private long id;
    @Column(name ="product_name")
    private String name;
    @Column (name = "product_gia")
    private double gia;
    @OneToOne
    private User user;
}

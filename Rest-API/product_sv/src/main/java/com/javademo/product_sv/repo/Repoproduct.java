package com.javademo.product_sv.repo;

import com.javademo.product_sv.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repoproduct extends JpaRepository<Product,Long> {
}

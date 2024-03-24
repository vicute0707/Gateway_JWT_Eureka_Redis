package com.javademo.product.repo;

import com.javademo.product.entity.EntityProduct;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoProduct extends CrudRepository<EntityProduct,Integer> {
}

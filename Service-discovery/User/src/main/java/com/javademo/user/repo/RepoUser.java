package com.javademo.user.repo;

import com.javademo.user.entity.EntityUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoUser extends CrudRepository<EntityUser,Integer> {
}

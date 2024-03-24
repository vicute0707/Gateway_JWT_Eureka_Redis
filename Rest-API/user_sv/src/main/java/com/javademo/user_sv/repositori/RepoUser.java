package com.javademo.user_sv.repositori;

import com.javademo.user_sv.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoUser extends JpaRepository<User,Long> {
}

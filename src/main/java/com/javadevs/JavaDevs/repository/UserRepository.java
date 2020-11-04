package com.javadevs.JavaDevs.repository;

import com.javadevs.JavaDevs.entity.Admin;
import com.javadevs.JavaDevs.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByEmail(String email);
    List<User> findAllUserByEmail(String email);
}

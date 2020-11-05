package com.javadevs.JavaDevs.repository;

import com.javadevs.JavaDevs.entity.Admin;
import com.javadevs.JavaDevs.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AdminRepository  extends CrudRepository<Admin, Integer> {

}

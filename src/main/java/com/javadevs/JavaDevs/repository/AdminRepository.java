package com.javadevs.JavaDevs.repository;

import com.javadevs.JavaDevs.entity.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface AdminRepository  extends CrudRepository<Admin, Integer> {

}

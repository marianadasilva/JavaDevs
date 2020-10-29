package com.javadevs.JavaDevs.repository;

import com.javadevs.JavaDevs.entity.ActorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ActorRepository extends CrudRepository<ActorEntity, Integer>  {

}

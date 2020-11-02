package com.javadevs.JavaDevs.repository;

import com.javadevs.JavaDevs.entity.Actor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ActorRepository extends CrudRepository<Actor, Integer>  {

}

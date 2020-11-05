package com.javadevs.JavaDevs.repository;

import com.javadevs.JavaDevs.entity.Actor;
import com.javadevs.JavaDevs.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Component
public interface ActorRepository extends CrudRepository<Actor, Integer>  {
    @Query(value = "SELECT TOP :quantity * FROM actors " +
            "WHERE amount >= :amount and gender LIKE '%:gender%'", nativeQuery = true)
    List<Actor> findAllActor(@Param("amount") double amount, @Param("quantity") int quantity, @Param("gender") String gender);
}



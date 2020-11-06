package com.javadevs.JavaDevs.repository;

import com.javadevs.JavaDevs.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByEmail(String email);
    List<User> findAllUserByEmail(String email);

    @Query("SELECT c.id, c.name, c.email, a.id as actor_id FROM User c JOIN c.actor a WHERE a.id = :actor_id")
    //@Query(value = "SELECT c.name, c.email FROM users c INNER JOIN actors a ON c.actor_id = a.id WHERE a.id = :actor_id", nativeQuery = true)
    //@Query("SELECT c.name, c.email FROM User c JOIN user_info_actor a WHERE a.id = :actor_id")
    List<Object[]> findAllActorUserById(@Param("actor_id") int actor_id);

    @Query("SELECT c.id, c.name, c.email, a.id as actor_id, a.gender, a.genre, a.amount FROM User c JOIN c.actor a")
    List<Object[]> findAllActorUser();
}

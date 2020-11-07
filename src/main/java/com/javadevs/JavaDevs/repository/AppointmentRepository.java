package com.javadevs.JavaDevs.repository;

import com.javadevs.JavaDevs.entity.Actor;
import com.javadevs.JavaDevs.entity.Appointment;
import com.javadevs.JavaDevs.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {
    @Query(value = "SELECT * FROM appointments " +
            "WHERE actor_id = :actor_id and status = :status and date = :date ", nativeQuery = true)
    Appointment verifyAppointmentExists(@Param("actor_id") int actor_id,
                                              @Param("status") boolean status,
                                              @Param("date") Date date);

    @Query(value = "SELECT count(*) FROM appointments WHERE actor_id = :actor_id", nativeQuery = true)
    long verifyAppointmentExistsToActor(@Param("actor_id") int actor_id);
}

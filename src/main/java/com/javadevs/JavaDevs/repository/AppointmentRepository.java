package com.javadevs.JavaDevs.repository;

import com.javadevs.JavaDevs.entity.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//ele comunicará com o banco
@Repository
public interface AppointmentRepository extends CrudRepository<Appointment,Integer> {



}

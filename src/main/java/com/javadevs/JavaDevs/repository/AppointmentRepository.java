package com.javadevs.JavaDevs.repository;

import com.javadevs.JavaDevs.entity.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface AppointmentRepository extends CrudRepository<Appointment,Integer> {


}

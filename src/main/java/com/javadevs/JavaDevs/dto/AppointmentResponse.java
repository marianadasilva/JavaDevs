package com.javadevs.JavaDevs.dto;

import com.javadevs.JavaDevs.entity.Appointment;

public class AppointmentResponse {

    private Appointment appointment;

    public AppointmentResponse(Appointment appointment) {
        this.appointment = appointment;
    }

    public AppointmentResponse() {
    }

    public static AppointmentResponse toDTO(Appointment appointment) {
        return new AppointmentResponse(appointment);
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

}

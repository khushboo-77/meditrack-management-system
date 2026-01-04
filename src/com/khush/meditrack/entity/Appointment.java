package com.khush.meditrack.entity;

import com.khush.meditrack.util.DateUtil;

import java.time.LocalDateTime;

public class Appointment {

    private final int id;
    private final Doctor doctor;
    private final Patient patient;
    private final LocalDateTime dateTime;
    private AppointmentStatus status;

    public Appointment(int id, Doctor doctor, Patient patient, LocalDateTime dateTime) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.dateTime = dateTime;
        this.status = AppointmentStatus.CONFIRMED;
    }

    public int getId() {
        return id;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void cancel() {
        this.status = AppointmentStatus.CANCELLED;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", doctor=" + doctor.getName() +
                ", patient=" + patient.getName() +
                ", time=" + DateUtil.format(dateTime) +
                ", status=" + getStatus() +
                '}';
    }

    public Doctor getDoctor() {
        return doctor;
    }

}

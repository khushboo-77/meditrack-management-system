package com.khush.meditrack.service;

import com.khush.meditrack.entity.Appointment;
import com.khush.meditrack.exception.AppointmentNotFoundException;
import com.khush.meditrack.observer.AppointmentObserver;

import java.util.ArrayList;
import java.util.List;

public class AppointmentService {

    private final List<Appointment> appointments = new ArrayList<>();

    private final List<AppointmentObserver> observers = new ArrayList<>();

    public void create(Appointment appointment) {
        appointments.add(appointment);
    }

    public List<Appointment> getAll() {
        return appointments;
    }

    public void cancelById(int id) {
        for (Appointment a : appointments) {
            if (a.getId() == id) {
                a.cancel();
                notifyObservers(a); // 🔔 observer notified
                return;
            }
        }
        throw new AppointmentNotFoundException(
                "Appointment with ID " + id + " not found"
        );
    }

    public void addObserver(AppointmentObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers(Appointment appointment) {
        for (AppointmentObserver observer : observers) {
            observer.update(appointment);
        }
    }

}

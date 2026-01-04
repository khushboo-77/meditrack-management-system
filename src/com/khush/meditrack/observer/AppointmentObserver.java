package com.khush.meditrack.observer;

import com.khush.meditrack.entity.Appointment;

public interface AppointmentObserver {
    void update(Appointment appointment);
}

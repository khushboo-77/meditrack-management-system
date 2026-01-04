package com.khush.meditrack.observer;

import com.khush.meditrack.entity.Appointment;

public class ConsoleNotificationObserver
        implements AppointmentObserver {

    @Override
    public void update(Appointment appointment) {
        System.out.println(
                "[NOTIFICATION] Appointment status changed: "
                        + appointment
        );
    }
}

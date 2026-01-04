package com.khush.meditrack.test;

import com.khush.meditrack.entity.*;

public class TestRunner {

    static {
        System.out.println("MediTrack loading...");
    }

    public static void main(String[] args) {

        Doctor d = new Doctor(
                1, "Dr Test", 45, "9999999999",
                Specialization.CARDIOLOGY, 700
        );

        Patient p = new Patient(
                101, "Test Patient", 30, "8888888888",
                "Fever"
        );

        System.out.println(d.getName());
        System.out.println(p.getName());
    }
}

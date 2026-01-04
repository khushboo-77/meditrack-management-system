package com.khush.meditrack.entity;

public class Doctor extends Person {

    private final Specialization specialization;
    private final double consultationFee;

    public Doctor(int id, String name, int age, String phone,
                  Specialization specialization, double consultationFee) {
        super(id, name, age, phone);
        this.specialization = specialization;
        this.consultationFee = consultationFee;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public double getConsultationFee() {
        return consultationFee;
    }
}

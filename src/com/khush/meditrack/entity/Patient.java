package com.khush.meditrack.entity;

public class Patient extends Person {

    private String disease;

    public Patient(int id, String name, int age, String phone, String disease) {
        super(id, name, age, phone);
        this.disease = disease;
    }

    public String getDisease() {
        return disease;
    }
}

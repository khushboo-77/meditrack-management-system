package com.khush.meditrack.entity;

import com.khush.meditrack.util.Validator;

import java.util.Objects;

public abstract class Person {

    protected final int id;
    protected String name;
    protected int age;
    protected String phone;

    protected Person(int id, String name, int age, String phone) {
        Validator.validateName(name);
        Validator.validateAge(age);
        Validator.validatePhone(phone);

        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getPhone() { return phone; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

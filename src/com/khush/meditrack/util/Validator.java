package com.khush.meditrack.util;

import com.khush.meditrack.exception.InvalidDataException;

public class Validator {

    private Validator() {
        // Prevent instantiation
    }

    public static void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    public static void validateAge(int age) {
        if (age <= 0 || age > 120) {
            throw new InvalidDataException("Age must be between 1 and 120");
        }
    }

    public static void validatePhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Invalid phone number");
        }
    }
}

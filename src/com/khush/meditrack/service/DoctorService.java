package com.khush.meditrack.service;

import com.khush.meditrack.entity.Doctor;
import com.khush.meditrack.interfaces.Searchable;
import com.khush.meditrack.util.DataStore;

import java.util.List;
import java.util.stream.Collectors;

public class DoctorService implements Searchable<Doctor> {
    private final DataStore<Doctor> doctorStore = new DataStore<>();

    public void addDoctor(Doctor doctor) {
        doctorStore.add(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return doctorStore.getAll();
    }

    @Override
    public List<Doctor> searchById(int id) {
        return doctorStore.getAll()
                .stream()
                .filter(d -> d.getId() == id)
                .collect(Collectors.toList());
    }

    @Override
    public List<Doctor> searchByName(String name) {
        if (!isValidSearch(name)) {
            return List.of();
        }

        return doctorStore.getAll()
                .stream()
                .filter(d -> d.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }
}


package com.khush.meditrack.service;

import com.khush.meditrack.entity.Patient;
import com.khush.meditrack.interfaces.Searchable;
import com.khush.meditrack.util.DataStore;

import java.util.List;
import java.util.stream.Collectors;

public class PatientService implements Searchable<Patient> {

    private final DataStore<Patient> patientStore = new DataStore<>();

    public void addPatient(Patient patient) {
        patientStore.add(patient);
    }

    @Override
    public List<Patient> searchById(int id) {
        return patientStore.getAll()
                .stream()
                .filter(d -> d.getId() == id)
                .collect(Collectors.toList());
    }

    @Override
    public List<Patient> searchByName(String name) {
        if (!isValidSearch(name)) {
            return List.of();
        }

        return patientStore.getAll()
                .stream()
                .filter(d -> d.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public List<Patient> getAll() {
        return patientStore.getAll();
    }
}

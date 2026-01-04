package com.khush.meditrack.util;

import com.khush.meditrack.entity.Patient;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVUtil {

    private CSVUtil() {}

    public static void savePatients(List<Patient> patients, String filePath) {

        try {
            File file = new File(filePath);
            file.getParentFile().mkdirs(); // ✅ create directory if missing

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                for (Patient p : patients) {
                    bw.write(p.getId() + "," +
                            p.getName() + "," +
                            p.getAge() + "," +
                            p.getPhone() + "," +
                            p.getDisease());
                    bw.newLine();
                }
            }

        } catch (IOException e) {
            System.out.println("Error saving patients: " + e.getMessage());
        }
    }


    public static List<Patient> loadPatients(String filePath) {

        List<Patient> patients = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                Patient p = new Patient(
                        Integer.parseInt(data[0]),
                        data[1],
                        Integer.parseInt(data[2]),
                        data[3],
                        data[4]
                );
                patients.add(p);
            }

        } catch (IOException e) {
            System.out.println("Error loading patients: " + e.getMessage());
        }

        return patients;
    }
}

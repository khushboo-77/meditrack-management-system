package com.khush.meditrack.util;

import com.khush.meditrack.entity.Specialization;

public class AIHelper {

    private AIHelper() {}

    public static Specialization suggestSpecialization(String symptom) {

        if (symptom == null) return Specialization.ORTHOPEDICS;

        symptom = symptom.toLowerCase();

        if (symptom.contains("heart")) return Specialization.CARDIOLOGY;
        if (symptom.contains("skin")) return Specialization.DERMATOLOGY;
        if (symptom.contains("brain")) return Specialization.NEUROLOGY;

        return Specialization.ORTHOPEDICS;
    }
}

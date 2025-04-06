package services;

import model.entity.Patient;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class PatientService {
    private static final List<Patient> patientList = new ArrayList<>();

    public void addPatient(Patient patient) {
        int age = calcAge(patient.getBirthDate());
        if (age < 18) {
            patient.setDUI("000000000");
        }

        patientList.add(patient);
    }

    public Patient getPatientById(String dui) {
        return patientList.stream().filter(pt -> pt.getDUI().equals(dui))
                .findFirst().orElse(null);
    }

    private int calcAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public List<Patient> getAllPatients() {
        return patientList;
    }
}
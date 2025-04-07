package services;

import model.entity.Patient;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class PatientService {
    private final List<Patient> patientList = new ArrayList<>();
    private static int childID = 0;

    public void addPatient(Patient patient) {
        int age = calcAge(patient.getBirthDate());
        if (age < 18) {
            patient.setDUI("00000000-0:"+ childID++);
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
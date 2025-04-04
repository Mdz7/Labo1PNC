package services;

import model.entity.Doctor;

import java.util.*;
import java.util.stream.Collectors;

public class DoctorService {
    private final List<Doctor> doctorList = new ArrayList<>();
    private final Random random = new Random();

    public void addDoctor(Doctor doctor) {
        String generatedId = generateDoctorId();
        doctor.setDoctorid(generatedId);
        doctorList.add(doctor);
        System.out.println("Doctor agregado, el ID del doctor es: " + generatedId);
    }

    private String generateDoctorId() {
        return "ZNH-" +
                generateRandomL() + generateRandomN() + generateRandomL() + "-MD-" + generateRandomL() + generateRandomN();
    }

    private char generateRandomL() {
        return (char) ('A' + random.nextInt(26));
    }

    private int generateRandomN() {
        return random.nextInt(10);
    }

    public Map<String, List<Doctor>> groupBySpecialty() {
        return doctorList.stream()
                .collect(Collectors.groupingBy(Doctor::getSpecialty));
    }

    public List<Doctor> getAllDoctors() {
        return doctorList;
    }

    public List<Doctor> getDoctorsBySpecialty(String specialty) {
        return doctorList.stream()
                .filter(doctor -> doctor.getSpecialty().equalsIgnoreCase(specialty))
                .collect(Collectors.toList());
    }
}
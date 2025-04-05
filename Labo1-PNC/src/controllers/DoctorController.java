package controllers;

import model.entity.Doctor;
import services.DoctorService;
import utils.Collectors.CollectDrData;

import java.util.Scanner;

public class DoctorController {

    private final DoctorService service = new DoctorService();
    private final Scanner sc = new Scanner(System.in);

    public void doctorArea(){
        boolean flag = true;

        while (flag){
            System.out.println("1. Add Doctor");
            System.out.println("2. See all Doctors");
            System.out.println("3. See all Doctors by specialities");
            System.out.println("4. Exit");

            switch (sc.nextInt()){
                case 1:
                    sc.nextLine();
                    Doctor doctor = new Doctor();
                    CollectDrData collector = new CollectDrData();
                    collector.basicInformation(doctor);
                    collector.specialtyCollector(doctor);
                    service.addDoctor(doctor);
                    break;
                case 2:
                    sc.nextLine();
                    for (Doctor dr : service.getAllDoctors()){
                        System.out.println(dr.getFirstName() + " " + dr.getLastName() + " " + dr.getDoctorid());
                    }
                    break;
                case 3:
                    sc.nextLine();
                    System.out.println("Enter Specialty: ");
                    String specialty = sc.nextLine();
                    for (Doctor dr : service.getDoctorsBySpecialty(specialty)){
                        System.out.println(dr.getFirstName() + " " + dr.getLastName() + " " + dr.getDoctorid());
                    }
                    break;
                default:
                    flag = false;
                    break;
            }
        }
    }
}
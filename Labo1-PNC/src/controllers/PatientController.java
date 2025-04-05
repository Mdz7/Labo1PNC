package controllers;

import model.entity.Patient;
import services.PatientService;
import utils.Collectors.CollectData;

import java.util.Scanner;

public class PatientController {

    private final PatientService service = new PatientService();
    private final Scanner sc = new Scanner(System.in);

    public void patientArea(){
        boolean flag = true;

        while (flag){
            System.out.println("1. Add Patient");
            System.out.println("2. See all Patients");
            System.out.println("3. Exit");

            switch (sc.nextInt()){
                case 1:
                    sc.nextLine();
                    Patient patient = new Patient();
                    CollectData collector = new CollectData();
                    collector.basicInformation(patient);
                    service.addPatient(patient);
                    break;
                case 2:
                    sc.nextLine();
                    for (Patient pt : service.getAllPatients()){
                        System.out.println(pt.getFirstName() + " " + pt.getLastName() + " " + pt.getDUI());
                    }
                    break;
                default:
                    flag = false;
                    break;
            }
        }
    }
}

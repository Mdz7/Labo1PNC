package controllers;

import model.entity.Patient;
import services.PatientService;
import utils.Collectors.CollectData;
import utils.Printers.PrintPt;

import java.util.Scanner;

public class PatientController {

    private final PatientService service = new PatientService();
    private final PrintPt printer = new PrintPt();
    private final Scanner sc = new Scanner(System.in);

    public void patientArea(){
        boolean flag = true;

        while (flag){
            System.out.println(" ");
            System.out.println("1. Agregar paciente");
            System.out.println("2. Ver todos los pacientes");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opcion: ");

            switch (sc.nextInt()){
                case 1:
                    sc.nextLine();
                    Patient patient = new Patient();
                    CollectData collector = new CollectData();
                    collector.basicInformation(patient);
                    service.addPatient(patient);
                    printer.printPt(patient);
                    break;
                case 2:
                    sc.nextLine();
                    for (Patient pt : service.getAllPatients()){
                        printer.printPt(pt);
                    }
                    break;
                default:
                    flag = false;
                    break;
            }
        }
    }
}

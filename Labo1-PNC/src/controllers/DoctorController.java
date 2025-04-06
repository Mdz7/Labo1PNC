package controllers;

import model.entity.Doctor;
import services.DoctorService;
import utils.Collectors.CollectDrData;
import utils.Printers.PrintDr;

import java.util.Scanner;

public class DoctorController {

    protected final DoctorService service = new DoctorService();
    private final Scanner sc = new Scanner(System.in);
    private final PrintDr printer = new PrintDr();

    public void doctorArea(){
        boolean flag = true;

        while (flag){
            System.out.println(" ");
            System.out.println("1. Agregar Doctor");
            System.out.println("2. Ver todos los Doctores");
            System.out.println("3. Filtrar Doctores por especialidad");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opcion: ");

            switch (sc.nextInt()){
                case 1:
                    sc.nextLine();
                    Doctor doctor = new Doctor();
                    CollectDrData collector = new CollectDrData();

                    collector.basicInformation(doctor);
                    collector.specialtyCollector(doctor);

                    service.addDoctor(doctor);
                    printer.printDrInfo(doctor);
                    break;
                case 2:
                    for (Doctor dr : service.getAllDoctors()){
                        printer.printDrInfo(dr);
                    }
                    break;
                case 3:
                    sc.nextLine();
                    System.out.println("Ingresar especialidad: ");
                    String specialty = sc.nextLine();

                    for (Doctor dr : service.getDoctorsBySpecialty(specialty)){
                        printer.printDrInfo(dr);
                    }
                    break;
                default:
                    flag = false;
                    break;
            }
        }
    }

}
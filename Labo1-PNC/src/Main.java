import controllers.DoctorController;
import controllers.MedAppointmentController;
import controllers.PatientController;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int option;
        boolean flag = true;

        Scanner scanner = new Scanner(System.in);
        DoctorController drController = new DoctorController();
        PatientController ptController = new PatientController();
        MedAppointmentController apController = new MedAppointmentController();

        while (flag) {

            //Agregar id a cita para eliminarlo

            System.out.println(" ");
            System.out.println("1. Doctores");
            System.out.println("2. Pacientes");
            System.out.println("3. Citas");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opcion: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    drController.doctorArea();
                    break;
                case 2:
                    ptController.patientArea();
                    break;
                case 3:
                    apController.appointmentArea();
                    break;
                default:
                    flag = false;
                    break;
            }
        }
    }

}
package controllers;

import model.entity.MedAppointment;
import services.MedAppointmentService;
import utils.Collectors.CollectApData;
import utils.Format.DateTimeFormat;
import utils.Printers.PrintAp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class MedAppointmentController {

    private final MedAppointmentService service = new MedAppointmentService();
    private final DateTimeFormat formatter = new DateTimeFormat();
    private final PrintAp printer = new PrintAp();
    private final Scanner sc = new Scanner(System.in);

    public void appointmentArea(){
        boolean flag = true;
        boolean apFlag;

        while (flag){
            System.out.println(" ");
            System.out.println("1. Agregar cita");
            System.out.println("2. Ver todas las citas");
            System.out.println("3. Buscar cita por fecha");
            System.out.println("4. Filtrar cita por ID de doctor");
            System.out.println("5. Fecha con mas citas");
            System.out.println("6. Eliminar cita");
            System.out.println("7. Salir");
            System.out.print("Selecciona una opcion: ");

            switch (sc.nextInt()){
                case 1:
                    sc.nextLine();
                    MedAppointment ap = new MedAppointment();
                    CollectApData collectAp = new CollectApData();
                    collectAp.basicApInformation(ap);

                    if (ap.getDate().isEqual(LocalDate.now())){
                        apFlag = service.scheduleTodayAppointment(ap);
                    }else{
                        apFlag = service.scheduleFutureAppointment(ap);
                    }

                    if (apFlag){
                        printer.printAppointment(ap);
                    }else{
                        printer.printErrorAppointment();
                    }
                    break;
                case 2:
                    sc.nextLine();
                    for (MedAppointment _ap : service.getAllAppointments()){
                        printer.printAppointment(_ap);
                    }
                    break;
                case 3:
                    sc.nextLine();
                    System.out.println("Ingresa la fecha: ");
                    for (MedAppointment _ap :
                           service.getAppointmentListByDate(LocalDate.parse(sc.nextLine(), formatter.setDateFormat()))){
                        printer.printAppointment(_ap);
                    }
                    break;
                case 4:
                    sc.nextLine();
                    System.out.println("Ingresa el Id del Doctor: ");
                    for (MedAppointment _ap : service.getAppointmentListByDrId(sc.nextLine())){
                        printer.printAppointment(_ap);
                    }
                    break;
                case 5:
                    sc.nextLine();
                    System.out.println(service.getDateWithMostAppointment());
                    break;
                case 6:
                    sc.nextLine();
                    System.out.println("Ingresa la fecha: ");
                    LocalDate dateToDelete = LocalDate.parse(sc.nextLine(), formatter.setDateFormat());
                    System.out.println("Ingresa la hora: ");
                    LocalTime timeToDelete = LocalTime.parse(sc.nextLine(), formatter.setTimeFormat());

                    if (service.deleteAppointment(dateToDelete, timeToDelete)){
                        System.out.println("cita eliminada debido a ausencia");
                    }else{
                        System.out.println("No se puede eliminar cita");
                    }
                    break;
                default:
                    flag = false;
                    break;
            }
        }
    }
}
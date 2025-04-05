package controllers;

import model.entity.MedAppointment;
import services.MedAppointmentService;
import utils.Appointment.PrintAp;
import utils.Collectors.CollectApData;
import utils.Format.DateTimeFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class MedAppointmentController {

    private final MedAppointmentService service = new MedAppointmentService();
    private final Scanner sc = new Scanner(System.in);
    private final DateTimeFormat formatter = new DateTimeFormat();
    private final PrintAp showAp = new PrintAp();

    public void appointmentArea(){
        boolean flag = true;
        boolean apFlag;

        while (flag){
            System.out.println("1. Add appointment");
            System.out.println("2. See all appointments");
            System.out.println("3. Search appointment by date");
            System.out.println("4. Search appointment by Doctor Id");
            System.out.println("5. Search by day with more appointments");
            System.out.println("6. Exit");

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
                        System.out.println("cita agendada");
                    }
                    break;
                case 2:
                    sc.nextLine();
                    for (MedAppointment _ap : service.getAllAppointments()){
                        showAp.printAppointment(_ap);
                    }
                    break;
                case 3:
                    sc.nextLine();
                    System.out.println("Enter Date: ");
                    for (MedAppointment _ap :
                           service.getAppointmentListByDate(LocalDate.parse(sc.nextLine(), formatter.setDateFormat()))){
                        showAp.printAppointment(_ap);
                    }
                    break;
                case 4:
                    sc.nextLine();
                    System.out.println("Enter Dr ID: ");
                    for (MedAppointment _ap : service.getAppointmentListByDrId(sc.nextLine())){
                        showAp.printAppointment(_ap);
                    }
                    break;
                case 5:
                    System.out.println(service.getDateWithMostAppointment());
                    break;
                default:
                    flag = false;
                    break;
            }
        }
    }

}

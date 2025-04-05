package utils.Collectors;

import model.entity.MedAppointment;

import java.time.LocalDate;
import java.time.LocalTime;

public class CollectApData extends CollectData {

    public void basicApInformation(MedAppointment ap) {
        System.out.print("Enter Dr Name: ");
        ap.setDrName(sc.nextLine());
        System.out.print("Enter Dr ID: ");
        ap.setDrId(sc.nextLine());
        System.out.print("Enter Patient Name: ");
        ap.setPtName(sc.nextLine());
        System.out.print("Enter Patient ID: ");
        ap.setPtDui(sc.nextLine());
        System.out.print("Enter Specialty: ");
        ap.setSpecialty(sc.nextLine());
        System.out.print("Enter Date: ");
        ap.setDate(LocalDate.parse(sc.nextLine(), formatter.setDateFormat()));
        if (ap.getDate().isEqual(LocalDate.now())) {
            System.out.print("Enter Time: ");
            ap.setTime(LocalTime.parse(sc.nextLine(), formatter.setTimeFormat()));
        }
        System.out.print("Enter Attendance: ");
        ap.setAttendance(Boolean.parseBoolean(sc.nextLine()));
}

}

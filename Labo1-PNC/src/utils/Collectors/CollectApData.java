package utils.Collectors;

import model.entity.MedAppointment;

import java.time.LocalDate;
import java.time.LocalTime;

public class CollectApData extends CollectData {

    public void basicApInformation(MedAppointment ap) {
        System.out.print("Ingresa nombre del Doctor: ");
        ap.setDrName(sc.nextLine());
        System.out.print("Ingresa ID del Doctor: ");
        ap.setDrId(sc.nextLine());
        System.out.print("Ingresa nombre del paciente: ");
        ap.setPtName(sc.nextLine());
        System.out.print("Ingresa DUI del paciente: ");
        ap.setPtDui(sc.nextLine());
        System.out.print("Ingresa Especialidad: ");
        ap.setSpecialty(sc.nextLine());
        System.out.print("Ingresa fecha: ");
        ap.setDate(LocalDate.parse(sc.nextLine(), formatter.setDateFormat()));
        if (!(ap.getDate().isEqual(LocalDate.now()))) {
            System.out.print("Ingresa hora: ");
            ap.setTime(LocalTime.parse(sc.nextLine(), formatter.setTimeFormat()));
        }
        System.out.print("Ingresa asistencia: ");
        ap.setAttendance(Boolean.parseBoolean(sc.nextLine()));
        System.out.print(" ");
}

}

package utils.Collectors;

import model.entity.MedAppointment;
import model.entity.Patient;
import services.DoctorService;
import services.PatientService;

import java.time.LocalDate;
import java.time.LocalTime;

public class CollectApData extends CollectData {

    private final DoctorService drService = new DoctorService();
    private final PatientService ptService = new PatientService();

    public void basicApInformation(MedAppointment ap) {
        System.out.print("Ingresa ID del Doctor: ");
        ap.setDrId(sc.nextLine());
        ap.setDrName(drService.getDoctorById(ap.getDrId()).getFirstName());
        System.out.print("Ingresa DUI del paciente: ");
        ap.setPtDui(sc.nextLine());
        ap.setPtName(ptService.getPatientById(ap.getPtDui()).getFirstName());
        ap.setSpecialty(drService.getDoctorById(ap.getDrId()).getSpecialty());
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

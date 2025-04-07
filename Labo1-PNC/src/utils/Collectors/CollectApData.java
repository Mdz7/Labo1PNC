package utils.Collectors;

import controllers.DoctorController;
import controllers.PatientController;
import model.entity.MedAppointment;
import model.entity.Patient;
import services.DoctorService;
import services.PatientService;

import java.time.LocalDate;
import java.time.LocalTime;

public class CollectApData extends CollectData {

    public void basicApInformation(MedAppointment ap, DoctorService dr, PatientService pt) {
        ap.setId();

        System.out.print("Ingresa ID del Doctor: ");
        ap.setDrId(sc.nextLine());
        ap.setDrName(dr.getDoctorById(ap.getDrId()).getFirstName());
        ap.setSpecialty(dr.getDoctorById(ap.getDrId()).getSpecialty());

        System.out.print("Ingresa DUI del paciente: ");
        ap.setPtDui(sc.nextLine());
        ap.setPtName(pt.getPatientById(ap.getPtDui()).getFirstName());

        System.out.print("Ingresa fecha (dd/mm/yyyy): ");
        ap.setDate(LocalDate.parse(sc.nextLine(), formatter.setDateFormat()));
        if (!(ap.getDate().isEqual(LocalDate.now()))) {
            System.out.print("Ingresa hora: ");
            ap.setTime(LocalTime.parse(sc.nextLine(), formatter.setTimeFormat()));
        }
    }
}

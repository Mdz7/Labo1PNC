package utils.Collectors;

import model.entity.Patient;
import utils.Format.DateTimeFormat;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class CollectData {

    public final Scanner sc = new Scanner(System.in);
    public final DateTimeFormat formatter = new DateTimeFormat();

    public void basicInformation(Patient patient) {
        System.out.print("Ingresa el nombre: ");
        patient.setFirstName(sc.nextLine());
        System.out.print("Ingresa el apellido: ");
        patient.setLastName(sc.nextLine());
        System.out.print("Ingresa la fecha de nacimiento (dd/mm/yyyy): ");
        patient.setBirthDate(LocalDate.parse(sc.nextLine(), formatter.setDateFormat()));
        if (Period.between(patient.getBirthDate(), LocalDate.now()).getYears() >= 18) {
            System.out.print("Ingresa el DUI: ");
            patient.setDUI(sc.nextLine());
        }
    }
}

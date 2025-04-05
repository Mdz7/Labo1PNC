package utils.Collectors;

import model.entity.Patient;
import utils.Format.DateTimeFormat;

import java.time.LocalDate;
import java.util.Scanner;

public class CollectData {

    public final Scanner sc = new Scanner(System.in);
    public final DateTimeFormat formatter = new DateTimeFormat();

    public void basicInformation(Patient patient) {
        System.out.print("Enter Name: ");
        patient.setFirstName(sc.nextLine());
        System.out.print("Enter Last Name: ");
        patient.setLastName(sc.nextLine());
        System.out.print("Enter Birth Date: ");
        patient.setBirthDate(LocalDate.parse(sc.nextLine(), formatter.setDateFormat()));
        System.out.print("Enter DUI: ");
        patient.setDUI(sc.nextLine());
    }
}

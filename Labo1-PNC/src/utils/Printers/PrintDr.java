package utils.Printers;

import model.entity.Doctor;

public class PrintDr {

    public void printDrInfo (Doctor dr) {
        System.out.println("------------------------------");
        System.out.println("ID: " + dr.getID());
        System.out.println("Dr. " + dr.getFirstName() + " " + dr.getLastName());
        System.out.println("Especialidad: " +  dr.getSpecialty());
        System.out.println("Contratado el " + dr.getRecruitment());
    }

}

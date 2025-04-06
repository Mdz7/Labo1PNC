package utils.Printers;

import model.entity.Patient;

public class PrintPt {

    public void printPt(Patient p) {
        System.out.println("------------------------------");
        System.out.println("Nombre: " + p.getFirstName() + " " + p.getLastName());
        System.out.println("Dui: " + p.getDUI());
    }

}

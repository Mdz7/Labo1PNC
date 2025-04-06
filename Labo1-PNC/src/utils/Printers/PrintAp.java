package utils.Printers;

import model.entity.MedAppointment;

public class PrintAp {

    public void printAppointment (MedAppointment ap) {
        System.out.println("-------------------------------------------");
        System.out.println("Dr: " + ap.getDrName() + " Especialidad: "+ ap.getSpecialty());
        System.out.println("Paciente: " + ap.getPtName());
        System.out.println("Fecha: " + ap.getDate() + " Hora: " + ap.getTime());
    }

    public void printErrorAppointment () {
        System.out.println("Error: Dia y hora no disponibles");
    }

}

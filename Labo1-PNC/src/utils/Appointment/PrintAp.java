package utils.Appointment;

import model.entity.MedAppointment;

public class PrintAp {

    public void printAppointment (MedAppointment ap) {
        System.out.println("-------------------------------------------");
        System.out.print("Dr: " + ap.getDrName() + " ");
        System.out.print("Paciente: " + ap.getPtName() + " ");
        System.out.print("Especialidad: " + ap.getSpecialty() + " ");
        System.out.print("Fecha: " + ap.getDate() + " ");
        System.out.print("Hora: " + ap.getTime() + " ");
    }

}

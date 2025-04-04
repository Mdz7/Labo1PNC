package services;

import model.entity.MedAppointment;
import model.entity.Doctor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class MedAppointmentService {
    private final List<MedAppointment> appointmentList = new ArrayList<>();

    public List<MedAppointment> getAllAppointments() {
        return appointmentList;
    }

    public boolean scheduleAppointment(String patientDui, String specialty, Doctor doctor, LocalDate date, LocalTime time) {
        for (MedAppointment appointment : appointmentList) {

            if (appointment.getSpecialty().equalsIgnoreCase(specialty)
                    && appointment.getPatientDui().equals(patientDui)
                    && appointment.getDate().equals(date)
                    && appointment.getTime().equals(time)) {
                System.out.println("error: el paciente ya tiene una cita agendada ");
                return false;
            }

            if (appointment.getSpecialty().equalsIgnoreCase(specialty)
                    && appointment.getDate().equals(date)
                    && appointment.getTime().equals(time)) {
                System.out.println("error: el especialista ya tiene una cita agendada ");
                return false;
            }

            if (appointment.getPatientDui().equals(patientDui)
                    && appointment.getDate().equals(date)
                    && appointment.getTime().equals(time)) {
                System.out.println("error: el paciente ya tiene una cita agendada");
                return false;
            }
        }

        MedAppointment newAppointment = new MedAppointment(specialty, patientDui, date, time, false);
        appointmentList.add(newAppointment);
        System.out.println("cita programada");
        return true;
    }
}
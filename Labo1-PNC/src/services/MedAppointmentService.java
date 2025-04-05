package services;

import model.entity.MedAppointment;
import model.entity.Doctor;
import model.entity.Patient;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MedAppointmentService {
    private final LocalTime startTime = LocalTime.of(8, 0);
    private final LocalTime endTime = LocalTime.of(16, 0);
    private final LocalDate today = LocalDate.now();

    private final List<MedAppointment> appointmentList = new ArrayList<>();

    public List<MedAppointment> getAllAppointments() {
        return appointmentList;
    }

    public List<MedAppointment> getAppointmentListByDate(LocalDate date) {
        return appointmentList.stream()
                .filter(ap -> ap.getDate().equals(date))
                .collect(Collectors.toList());
    }

    public List<MedAppointment> getAppointmentListByDrId(String drId) {
        return appointmentList.stream()
                .filter(ap -> ap.getDrId().equals(drId))
                .collect(Collectors.toList());
    }

    public LocalDate getDateWithMostAppointment() {
            return appointmentList.stream().collect(
                    Collectors.groupingBy(MedAppointment::getDate, Collectors.counting()))
                    .entrySet()
                    .stream()
                    .max(Map.Entry.comparingByValue())
                    .map(Map.Entry::getKey).orElse(today);
    }

    public boolean scheduleTodayAppointment(MedAppointment ap) {
        for (MedAppointment appointment : appointmentList) {

            if (appointment.getPtDui().equals(ap.getPtDui())
                        && appointment.getDate().equals(ap.getDate())
                        && appointment.getTime().equals(ap.getTime())) {
                    System.out.println("error: el paciente ya tiene una cita agendada ");
                    return false;
            }

            if (appointment.getSpecialty().equalsIgnoreCase(ap.getSpecialty())
                        && appointment.getDate().equals(ap.getDate())
                        && appointment.getTime().equals(ap.getTime())
                        && appointment.getDrId().equals(ap.getDrId())
            ) {
                    System.out.println("error: el especialista ya tiene una cita agendada ");
                    return false;
            }

            if (ap.getTime().isBefore(startTime) || ap.getTime().isAfter(endTime) ) {
                    System.out.println("error: la clínica no atiende en esa hora ");
                    return false;
            }
        }

        appointmentList.add(ap);
        return true;
    }

    public boolean scheduleFutureAppointment(MedAppointment ap) {
        int lastIndex = appointmentList.size()-1;
        LocalDate lastDate = appointmentList.get(lastIndex).getDate();
        LocalTime lastTime = appointmentList.get(lastIndex).getTime();

        if (lastDate.isEqual(today)){
            ap.setTime(LocalTime.of(8,0));
            appointmentList.add(ap);
            return true;
        }

        if(lastTime.isBefore(endTime)){
            ap.setTime(lastTime.plusHours(1));
            appointmentList.add(ap);
            return true;
        }else{
            System.out.println("error: agenda llena");
            return false;
        }
    }

}
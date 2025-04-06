package services;

import model.entity.MedAppointment;
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

    public boolean scheduleTodayAppointment(MedAppointment ap) {
        for (MedAppointment appointment : appointmentList) {

            if (appointment.getPtDui().equals(ap.getPtDui())
                        && appointment.getDate().equals(ap.getDate())
                        && appointment.getTime().equals(ap.getTime())) {
                    return false;
            }

            if (appointment.getSpecialty().equalsIgnoreCase(ap.getSpecialty())
                        && appointment.getDate().equals(ap.getDate())
                        && appointment.getTime().equals(ap.getTime())
                        && appointment.getDrId().equals(ap.getDrId())
            ) {
                    return false;
            }

            if (ap.getTime().isBefore(startTime) || ap.getTime().isAfter(endTime) ) {
                    return false;
            }
        }

        appointmentList.add(ap);
        return true;
    }

    public boolean scheduleFutureAppointment(MedAppointment ap) {

        if (appointmentList.isEmpty()) {
            ap.setTime(LocalTime.of(8,0));
            appointmentList.add(ap);
            return true;
        }else{

            if (appointmentList.getLast().getDate().isEqual(today)){;
                appointmentList.add(ap);
                return true;
            }

            if(appointmentList.getLast().getTime().isBefore(endTime)){
                ap.setTime(appointmentList.getLast().getTime().plusHours(1));
                appointmentList.add(ap);
                return true;
            }else{
                return false;
            }
        }
    }

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

    public boolean deleteAppointment(LocalDate date, LocalTime time) {
        return appointmentList.removeIf(ap -> ap.getDate().equals(date) && ap.getTime().equals(time));
    }
}
package model.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class MedAppointment {
    private String Specialty;
    private String PatientDui;
    private LocalDate Date;
    private LocalTime Time;
    private boolean Attendace;

    public MedAppointment(String specialty, String patientDui, LocalDate date, LocalTime time, boolean attendace) {
        this.Specialty = specialty;
        this.PatientDui = patientDui;
        this.Date = date;
        this.Time = time;
        this.Attendace = attendace;
    }

    public String getSpecialty() {
        return Specialty;
    }

    public void setSpecialty(String specialty) {
        this.Specialty = specialty;
    }

    public String getPatientDui() {
        return PatientDui;
    }

    public void setPatientDui(String patientDui) {
        this.PatientDui = patientDui;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        this.Date = date;
    }

    public LocalTime getTime() {
        return Time;
    }

    public void setTime(LocalTime time) {
        this.Time = time;
    }

    public boolean isAttendace() {
        return Attendace;
    }

    public void setAttendace(boolean attendace) {
        this.Attendace = attendace;
    }
}

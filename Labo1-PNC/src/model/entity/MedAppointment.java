package model.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class MedAppointment {
    private String drName;
    private String drId;
    private String ptName;
    private String ptDui;
    private String Specialty;
    private LocalDate Date;
    private LocalTime Time;
    private boolean Attendance;

    public MedAppointment() {}

    public MedAppointment(String drName, String drId, String ptDui, String ptName, String specialty, LocalDate date, LocalTime time, boolean attendance) {
        this.drName = drName;
        this.drId = drId;
        this.ptDui = ptDui;
        this.ptName = ptName;
        this.Specialty = specialty;
        this.Date = date;
        this.Time = time;
        this.Attendance = attendance;
    }

    public String getDrName() {
        return drName;
    }

    public void setDrName(String drName) {
        this.drName = drName;
    }

    public String getDrId() {
        return drId;
    }

    public void setDrId(String drId) {
        this.drId = drId;
    }

    public String getPtName() {
        return ptName;
    }

    public void setPtName(String ptName) {
        this.ptName = ptName;
    }

    public String getPtDui() {
        return ptDui;
    }

    public void setPtDui(String ptDui) {
        this.ptDui = ptDui;
    }

    public String getSpecialty() {
        return Specialty;
    }

    public void setSpecialty(String specialty) {
        Specialty = specialty;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public LocalTime getTime() {
        return Time;
    }

    public void setTime(LocalTime time) {
        Time = time;
    }

    public boolean isAttendance() {
        return Attendance;
    }

    public void setAttendance(boolean attendance) {
        Attendance = attendance;
    }
}

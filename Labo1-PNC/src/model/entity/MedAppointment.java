package model.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class MedAppointment {
    private static int _numberAppointment = 0;
    private int id;
    private String drName;
    private String drId;
    private String ptName;
    private String ptDui;
    private String Specialty;
    private LocalDate Date;
    private LocalTime Time;
    private boolean Attendance;

    public MedAppointment() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = _numberAppointment++;
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

package model.entity;

import java.time.LocalDate;

public class Doctor extends Patient {
    private String Specialty;
    private LocalDate Recruitment;
    private String ID;

    public Doctor() {
    }

    public String getSpecialty() {
        return Specialty;
    }

    public void setSpecialty(String specialty) {
        this.Specialty = specialty;
    }

    public LocalDate getRecruitment() {
        return Recruitment;
    }

    public void setRecruitment() {
        this.Recruitment = LocalDate.now();
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}

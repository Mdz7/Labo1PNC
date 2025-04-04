package model.entity;

import java.time.LocalDate;

public class Patient {
    private String FirstName;
    private String LastName;
    private LocalDate BirthDate;
    private String DUI;

    public Patient(String firstName, String lastName, LocalDate birthDate, String dui) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.BirthDate = birthDate;
        this.DUI = dui;
    }


    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public LocalDate getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.BirthDate = birthDate;
    }

    public String getDUI() {
        return DUI;
    }

    public void setDUI(String dui) {
        this.DUI = dui;
    }
}



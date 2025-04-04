package model.entity;

import java.time.LocalDate;

public class Doctor extends Patient {
    private String Specialty;
    private LocalDate Recruitment;
    private String  Doctorid;

    public Doctor(String firstName, String lastName, LocalDate birthDate, String dui, String specialty) {
        super(firstName, lastName, birthDate, dui);
        this.Specialty = specialty;
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

        public void setRecruitment(LocalDate recruitment) {
                this.Recruitment = recruitment;
        }

        public String getDoctorid() {
                return Doctorid;
        }

        public void setDoctorid(String doctorid) {
                this.Doctorid = doctorid;
        }
}

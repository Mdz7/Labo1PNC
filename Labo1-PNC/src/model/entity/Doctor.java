package model.entity;

import java.time.LocalDate;

public class Doctor extends Patient {
    private String Specialty;
    private LocalDate Recruitment;
    private String Doctorid;

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

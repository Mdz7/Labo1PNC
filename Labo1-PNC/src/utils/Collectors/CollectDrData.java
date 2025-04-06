package utils.Collectors;

import model.entity.Doctor;

public class CollectDrData extends CollectData {

    public void specialtyCollector(Doctor doctor) {
        System.out.print("Ingresa especialidad: ");
        doctor.setSpecialty(sc.nextLine());
    }

}

package com.homeopathyforall.dto;

import com.homeopathyforall.model.Doctor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class DoctorDTO {

    private String id;

    private String firstName;
    private String lastName;
    private String email;
    private String specialization;

    private String username;

    private String password;
    private String yearsOfExperience ;
    private String contactInfo;


    public DoctorDTO(Doctor doctor) {
        this.id = doctor.getId();
        this.firstName = doctor.getFirstName();
        this.lastName = doctor.getLastName();
        this.email = doctor.getEmail();
        this.specialization = doctor.getSpecialization();
        this.username = doctor.getUsername();
        this.password = doctor.getPassword();
        this.yearsOfExperience = doctor.getYearsOfExperience();
        this.contactInfo = doctor.getContactInfo();
    }


}

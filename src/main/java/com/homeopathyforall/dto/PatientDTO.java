package com.homeopathyforall.dto;


import com.homeopathyforall.model.Patient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {


    private String id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String medicalHistory;


}

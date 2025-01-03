package com.homeopathyforall.dto;

import com.homeopathyforall.model.Prescription;
import lombok.Data;

@Data
public class PrescriptionDTO {

    private String id;
    private String doctorId;
    private String patientId;
    private String remedyName;
    private String dosageInstructions;
    private String prescribedAt;
    private String dosage ;
    private String medicine;

}

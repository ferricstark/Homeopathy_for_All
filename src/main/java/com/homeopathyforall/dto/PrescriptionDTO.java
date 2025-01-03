package com.homeopathyforall.dto;

import com.homeopathyforall.model.Patient;
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

    public PrescriptionDTO(Prescription prescription) {
        this.id = prescription.getId();
        this.doctorId = prescription.getDoctorId();
        this.patientId = prescription.getPatientId();
        this.remedyName = prescription.getRemedyName();
        this.dosageInstructions = prescription.getDosageInstructions();
        this.prescribedAt = prescription.getPrescribedAt();
        this.dosage = prescription.getDosage();
        this.medicine = prescription.getMedicine();
    }
}

package com.homeopathyforall.service;

import com.homeopathyforall.dto.PrescriptionDTO;
import com.homeopathyforall.model.Prescription;
import com.homeopathyforall.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    // Prescribe medicine
    public PrescriptionDTO prescribeMedicine(PrescriptionDTO prescriptionDTO) {
        Prescription prescription = new Prescription();
        prescription.setPatientId(prescriptionDTO.getPatientId());
        prescription.setDoctorId(prescriptionDTO.getDoctorId());
        prescription.setMedicine(prescriptionDTO.getMedicine());
        prescription.setDosage(prescriptionDTO.getDosage());
        prescription.setPrescribedAt(prescriptionDTO.getPrescribedAt());
        prescription = prescriptionRepository.save(prescription);
        return new PrescriptionDTO(prescription);
    }

    // Get prescriptions by doctor ID
    public List<PrescriptionDTO> getPrescriptionsByDoctor(String doctorId) {
        List<Prescription> prescriptions = prescriptionRepository.findByDoctorId(doctorId);
        return prescriptions.stream().map(PrescriptionDTO::new).collect(Collectors.toList());
    }

    // Get prescriptions by patient ID
    public List<PrescriptionDTO> getPrescriptionsByPatient(String patientId) {
        List<Prescription> prescriptions = prescriptionRepository.findByPatientId(patientId);
        return prescriptions.stream().map(PrescriptionDTO::new).collect(Collectors.toList());
    }
}

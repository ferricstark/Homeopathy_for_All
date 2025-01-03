package com.homeopathyforall.controller;


import com.homeopathyforall.dto.PrescriptionDTO;
import com.homeopathyforall.service.PrescriptionService;
import com.homeopathyforall.util.ApiResponse;
import com.homeopathyforall.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    // Prescribe Medicine
    @PostMapping("/prescribe")
    public ResponseEntity<ApiResponse<PrescriptionDTO>> prescribeMedicine(@RequestBody PrescriptionDTO prescriptionDTO) {
        PrescriptionDTO prescribedMedicine = prescriptionService.prescribeMedicine(prescriptionDTO);
        return ResponseUtil.created(prescribedMedicine, "Prescription created successfully.");
    }

    // Get Prescriptions by Doctor ID
    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<ApiResponse<List<PrescriptionDTO>>> getPrescriptionsByDoctor(@PathVariable String doctorId) {
        List<PrescriptionDTO> prescriptions = prescriptionService.getPrescriptionsByDoctor(doctorId);
        return ResponseUtil.success(prescriptions, "Prescriptions retrieved successfully.");
    }

    // Get Prescriptions by Patient ID
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<ApiResponse<List<PrescriptionDTO>>> getPrescriptionsByPatient(@PathVariable String patientId) {
        List<PrescriptionDTO> prescriptions = prescriptionService.getPrescriptionsByPatient(patientId);
        return ResponseUtil.success(prescriptions, "Prescriptions retrieved successfully.");
    }
}

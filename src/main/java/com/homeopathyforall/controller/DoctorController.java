package com.homeopathyforall.controller;

import com.homeopathyforall.dto.DoctorDTO;
import com.homeopathyforall.service.DoctorService;
import com.homeopathyforall.util.ApiResponse;
import com.homeopathyforall.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // Get Doctor Details by ID
    @GetMapping("/{doctorId}")
    public ResponseEntity<ApiResponse<DoctorDTO>> getDoctorById(@PathVariable String doctorId) {
        DoctorDTO doctorDTO = doctorService.getDoctorById(doctorId);
        return ResponseUtil.success(doctorDTO, "Doctor details retrieved successfully.");
    }

    // Update Doctor Details
    @PutMapping("/{doctorId}")
    public ResponseEntity<ApiResponse<DoctorDTO>> updateDoctor(@PathVariable String doctorId, @RequestBody DoctorDTO doctorDTO) {
        DoctorDTO updatedDoctor = doctorService.updateDoctor(doctorId, doctorDTO);
        return ResponseUtil.success(updatedDoctor, "Doctor details updated successfully.");
    }
}

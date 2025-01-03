package com.homeopathyforall.controller;

import com.homeopathyforall.dto.DoctorDTO;
import com.homeopathyforall.dto.PatientDTO;
import com.homeopathyforall.service.UserService;
import com.homeopathyforall.util.ApiResponse;
import com.homeopathyforall.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register/patient")
    public ResponseEntity<ApiResponse<PatientDTO>> registerPatient(@RequestBody PatientDTO patientDTO) {
        PatientDTO registeredPatient = userService.registerPatient(patientDTO);
        return ResponseUtil.created(registeredPatient, "Patient registered successfully.");
    }

    @PostMapping("/register/doctor")
    public ResponseEntity<ApiResponse<DoctorDTO>> registerDoctor(@RequestBody DoctorDTO doctorDTO) {
        DoctorDTO registeredDoctor = userService.registerDoctor(doctorDTO);

        return ResponseUtil.created(registeredDoctor, "Doctor registered successfully.");
    }

    // Patient Login
    @PostMapping("/login/patient")
    public ResponseEntity<ApiResponse<PatientDTO>> patientLogin(@RequestParam String username, @RequestParam String password) {
        PatientDTO patientDTO = userService.loginPatient(username, password);
        if (patientDTO == null) {
            return ResponseUtil.error("Invalid username or password", HttpStatus.UNAUTHORIZED);
        }
        return ResponseUtil.success(patientDTO, "Patient logged in successfully.");
    }

    // Doctor Login
    @PostMapping("/login/doctor")
    public ResponseEntity<ApiResponse<DoctorDTO>> doctorLogin(@RequestParam String username, @RequestParam String password) {
        DoctorDTO doctorDTO = userService.loginDoctor(username, password);
        if (doctorDTO == null) {
            return ResponseUtil.error("Invalid username or password", HttpStatus.UNAUTHORIZED);
        }
        return ResponseUtil.success(doctorDTO, "Doctor logged in successfully.");
    }

    // Request password reset (Forgot Password)
    @PostMapping("/forgot-password")
    public ResponseEntity<ApiResponse<String>> forgotPassword(@RequestParam String username) {
        try {
            String response = userService.generatePasswordResetToken(username);
            return ResponseUtil.success(response, "Password reset email sent.");
        } catch (RuntimeException e) {
            return ResponseUtil.error(e.getMessage());
        }
    }

    // Reset password using the token
    @PostMapping("/reset-password")
    public ResponseEntity<ApiResponse<String>> resetPassword(@RequestParam String token, @RequestParam String newPassword) {
        try {
            String response = userService.resetPassword(token, newPassword);
            return ResponseUtil.success(response, "Password has been reset successfully.");
        } catch (RuntimeException e) {
            return ResponseUtil.error(e.getMessage());
        }
    }
}
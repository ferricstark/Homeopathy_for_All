package com.homeopathyforall.controller;

import com.homeopathyforall.dto.AppointmentDTO;
import com.homeopathyforall.service.AppointmentService;
import com.homeopathyforall.util.ApiResponse;
import com.homeopathyforall.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    // Book an Appointment
    @PostMapping("/book")
    public ResponseEntity<ApiResponse<AppointmentDTO>> bookAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        AppointmentDTO bookedAppointment = appointmentService.bookAppointment(appointmentDTO);
        return ResponseUtil.created(bookedAppointment, "Appointment booked successfully.");
    }

    // Get Appointments by Patient ID
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<ApiResponse<List<AppointmentDTO>>> getAppointmentsByPatient(@PathVariable String patientId) {
        List<AppointmentDTO> appointments = appointmentService.getAppointmentsByPatient(patientId);
        return ResponseUtil.success(appointments, "Appointments retrieved successfully.");
    }

    // Get Appointments by Doctor ID
    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<ApiResponse<List<AppointmentDTO>>> getAppointmentsByDoctor(@PathVariable String doctorId) {
        List<AppointmentDTO> appointments = appointmentService.getAppointmentsByDoctor(doctorId);
        return ResponseUtil.success(appointments, "Appointments retrieved successfully.");
    }

    // Cancel Appointment
    @DeleteMapping("/{appointmentId}")
    public ResponseEntity<ApiResponse<Void>> cancelAppointment(@PathVariable String appointmentId) {
        appointmentService.cancelAppointment(appointmentId);
        return ResponseUtil.noContent("Appointment canceled successfully.");
    }
}
package com.homeopathyforall.service;

import com.homeopathyforall.dto.AppointmentDTO;
import com.homeopathyforall.model.Appointment;
import com.homeopathyforall.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    // Book an appointment
    public AppointmentDTO bookAppointment(AppointmentDTO appointmentDTO) {
        Appointment appointment = new Appointment();
        appointment.setPatientId(appointmentDTO.getPatientId());
        appointment.setDoctorId(appointmentDTO.getDoctorId());
        appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
        appointment = appointmentRepository.save(appointment);
        return new AppointmentDTO(appointment);
    }

    // Get appointments by patient ID
    public List<AppointmentDTO> getAppointmentsByPatient(String patientId) {
        List<Appointment> appointments = appointmentRepository.findByPatientId(patientId);
        return appointments.stream().map(AppointmentDTO::new).collect(Collectors.toList());
    }

    // Get appointments by doctor ID
    public List<AppointmentDTO> getAppointmentsByDoctor(String doctorId) {
        List<Appointment> appointments = appointmentRepository.findByDoctorId(doctorId);
        return appointments.stream().map(AppointmentDTO::new).collect(Collectors.toList());
    }

    // Cancel appointment
    public void cancelAppointment(String appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }
}

package com.homeopathyforall.service;

import com.homeopathyforall.dto.DoctorDTO;
import com.homeopathyforall.model.Doctor;
import com.homeopathyforall.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    // Get doctor details by ID
    public DoctorDTO getDoctorById(String doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(() -> new RuntimeException("Doctor not found"));
        return new DoctorDTO(doctor);
    }

    // Update doctor profile
    public DoctorDTO updateDoctor(String doctorId, DoctorDTO doctorDTO) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(() -> new RuntimeException("Doctor not found"));
        doctor.setFirstName(doctorDTO.getFirstName());
        doctor.setLastName(doctorDTO.getLastName());
        doctor.setSpecialization(doctorDTO.getSpecialization());
        doctor.setYearsOfExperience(doctorDTO.getYearsOfExperience());
        doctor.setContactInfo(doctorDTO.getContactInfo());
        doctor = doctorRepository.save(doctor);
        return new DoctorDTO(doctor);
    }
}

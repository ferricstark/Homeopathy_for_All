package com.homeopathyforall.service;

import com.homeopathyforall.dto.DoctorDTO;
import com.homeopathyforall.dto.PatientDTO;
import com.homeopathyforall.model.Doctor;
import com.homeopathyforall.model.PasswordResetToken;
import com.homeopathyforall.model.Patient;
import com.homeopathyforall.repository.DoctorRepository;
import com.homeopathyforall.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Component
public class UserService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    // Register a new patient
    public PatientDTO registerPatient(PatientDTO patientDTO) {
        if (patientRepository.existsByUsername(patientDTO.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        Patient patient = new Patient();
        patient.setUsername(patientDTO.getUsername());

        // Hashing the password before saving it
        patient.setPassword(passwordEncoder.encode(patientDTO.getPassword()));
        patient.setEmail(patientDTO.getEmail());

        patient = patientRepository.save(patient);
        return new PatientDTO(patient);
    }

    // Register a new doctor
    public DoctorDTO registerDoctor(DoctorDTO doctorDTO) {
        if (doctorRepository.existsByUsername(doctorDTO.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        Doctor doctor = new Doctor();
        doctor.setUsername(doctorDTO.getUsername());
        // Hashing the password before saving it
        doctor.setPassword(passwordEncoder.encode(doctorDTO.getPassword()));
        doctor.setFirstName(doctorDTO.getFirstName());
        doctor.setLastName(doctorDTO.getLastName());
        doctor.setEmail(doctorDTO.getEmail());
        doctor.setSpecialization(doctorDTO.getSpecialization());
        doctor.setYearsOfExperience(doctorDTO.getYearsOfExperience());
        doctor.setContactInfo(doctorDTO.getContactInfo());

        doctor = doctorRepository.save(doctor);
        System.out.println(doctor);
        return new DoctorDTO(doctor);
    }

    // Verify patient password
    public boolean verifyPatientPassword(String username, String password) {
        Patient patient = patientRepository.findByUsername(username).orElse(null);
        return patient != null && passwordEncoder.matches(password, patient.getPassword());
    }

    // Verify doctor password
    public boolean verifyDoctorPassword(String username, String password) {
        Doctor doctor = doctorRepository.findByUsername(username).orElse(null);
        return doctor != null && passwordEncoder.matches(password, doctor.getPassword());
    }

    // Generate password reset token
    public String generatePasswordResetToken(String username) {
        // Check if username exists for patient or doctor
        Patient patient = patientRepository.findByUsername(username).orElse(null);
        Doctor doctor = doctorRepository.findByUsername(username).orElse(null);

        if (patient == null && doctor == null) {
            throw new RuntimeException("User not found");
        }

        String token = UUID.randomUUID().toString(); // Generate random token
        PasswordResetToken resetToken = new PasswordResetToken();
        resetToken.setUsername(username);
        resetToken.setToken(token);
        resetToken.setExpirationDate(new Date(System.currentTimeMillis() + 3600000)); // Token valid for 1 hour

        passwordResetTokenRepository.save(resetToken);

        // Here you would send the email with the token (mock function for now)
        sendPasswordResetEmail(username, token);

        return "Password reset email sent.";
    }

    // Mock function to simulate sending a password reset email
    private void sendPasswordResetEmail(String username, String token) {
        // Send email logic (using your email service e.g., SendGrid)
        System.out.println("Sending email to " + username + " with token: " + token);
    }

    // Reset password using token
    public String resetPassword(String token, String newPassword) {
        PasswordResetToken resetToken = passwordResetTokenRepository.findByToken(token);
        if (resetToken == null || resetToken.getExpirationDate().before(new Date())) {
            throw new RuntimeException("Invalid or expired token");
        }

        // Find user by username
        Patient patient = patientRepository.findByUsername(resetToken.getUsername()).orElse(null);
        Doctor doctor = doctorRepository.findByUsername(resetToken.getUsername()).orElse(null);

        if (patient != null) {
            patient.setPassword(passwordEncoder.encode(newPassword));
            patientRepository.save(patient);
        } else if (doctor != null) {
            doctor.setPassword(passwordEncoder.encode(newPassword));
            doctorRepository.save(doctor);
        }

        // Delete the reset token after successful password reset
        passwordResetTokenRepository.delete(resetToken);

        return "Password has been reset successfully.";
    }

    public PatientDTO findByUsername(String username) {
        Optional<Patient> patient = patientRepository.findByUsername(username);
        return patient.map(PatientDTO::new).orElse(null);
    }

    public DoctorDTO findDoctorByUsername(String username) {
        Optional<Doctor> doctor = doctorRepository.findByUsername(username);
        return doctor.map(DoctorDTO::new).orElse(null);
    }
}
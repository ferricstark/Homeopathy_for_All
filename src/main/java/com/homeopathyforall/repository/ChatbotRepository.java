package com.homeopathyforall.repository;

import com.homeopathyforall.model.Chatbot;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatbotRepository extends MongoRepository<Chatbot, String> {

    // Find all chat responses for a specific patient
    List<Chatbot> findByPatientId(String patientId);

    // Find all chat responses for a specific doctor
    List<Chatbot> findByDoctorId(String doctorId);
}

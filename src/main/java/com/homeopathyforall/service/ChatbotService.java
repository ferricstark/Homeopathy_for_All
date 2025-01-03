package com.homeopathyforall.service;

import com.homeopathyforall.dto.ChatbotDTO;
import com.homeopathyforall.model.Chatbot;
import com.homeopathyforall.repository.ChatbotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ChatbotService {

    @Autowired
    private ChatbotRepository chatbotRepository;

    // Simulate generating a response for a given question
    private String generateResponse(String question) {
        // Here you can integrate an actual chatbot logic or AI model
        // For simplicity, let's return a predefined response
        if (question.toLowerCase().contains("remedy")) {
            return "For your symptoms, try remedies like XYZ.";
        } else {
            return "I am not sure. Please consult with your doctor.";
        }
    }

    // Ask the chatbot a question
    public ChatbotDTO askQuestion(ChatbotDTO chatbotDTO) {
        String response = generateResponse(chatbotDTO.getQuestion());

        // Create and save the chatbot interaction in the database
        Chatbot chatbot = new Chatbot(
                chatbotDTO.getPatientId(),
                chatbotDTO.getDoctorId(),
                chatbotDTO.getQuestion(),
                response,
                LocalDateTime.now().toString()
        );
        chatbot = chatbotRepository.save(chatbot);

        // Return the response wrapped in DTO
        return new ChatbotDTO(chatbot.getPatientId(), chatbot.getDoctorId(), chatbot.getQuestion(), chatbot.getAnswer(), chatbot.getTimestamp());
    }

    // Get all interactions for a specific patient
    public List<ChatbotDTO> getInteractionsByPatient(String patientId) {
        List<Chatbot> chatbotList = chatbotRepository.findByPatientId(patientId);
        return chatbotList.stream()
                .map(chatbot -> new ChatbotDTO(chatbot.getPatientId(), chatbot.getDoctorId(), chatbot.getQuestion(), chatbot.getAnswer(), chatbot.getTimestamp()))
                .collect(Collectors.toList());
    }

    // Get all interactions for a specific doctor
    public List<ChatbotDTO> getInteractionsByDoctor(String doctorId) {
        List<Chatbot> chatbotList = chatbotRepository.findByDoctorId(doctorId);
        return chatbotList.stream()
                .map(chatbot -> new ChatbotDTO(chatbot.getPatientId(), chatbot.getDoctorId(), chatbot.getQuestion(), chatbot.getAnswer(), chatbot.getTimestamp()))
                .collect(Collectors.toList());
    }
}

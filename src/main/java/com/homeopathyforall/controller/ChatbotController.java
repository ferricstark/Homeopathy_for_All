package com.homeopathyforall.controller;

import com.homeopathyforall.dto.ChatbotDTO;
import com.homeopathyforall.service.ChatbotService;
import com.homeopathyforall.util.ApiResponse;
import com.homeopathyforall.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chatbot")
public class ChatbotController {

    @Autowired
    private ChatbotService chatbotService;

    // Ask a question to the chatbot
    @PostMapping("/ask")
    public ResponseEntity<ApiResponse<ChatbotDTO>> askQuestion(@RequestBody ChatbotDTO chatbotDTO) {
        ChatbotDTO response = chatbotService.askQuestion(chatbotDTO);
        return ResponseUtil.success(response, "Chatbot response generated.");
    }

    // Get all interactions for a specific patient
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<ApiResponse<List<ChatbotDTO>>> getInteractionsByPatient(@PathVariable String patientId) {
        List<ChatbotDTO> interactions = chatbotService.getInteractionsByPatient(patientId);
        return ResponseUtil.success(interactions, "Chatbot interactions retrieved.");
    }

    // Get all interactions for a specific doctor
    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<ApiResponse<List<ChatbotDTO>>> getInteractionsByDoctor(@PathVariable String doctorId) {
        List<ChatbotDTO> interactions = chatbotService.getInteractionsByDoctor(doctorId);
        return ResponseUtil.success(interactions, "Chatbot interactions retrieved.");
    }
}

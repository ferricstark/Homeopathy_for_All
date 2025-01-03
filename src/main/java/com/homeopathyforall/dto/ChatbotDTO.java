package com.homeopathyforall.dto;

import com.homeopathyforall.model.Chatbot;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatbotDTO {
    private String patientId;
    private String doctorId;
    private String question;
    private String answer;
    private String timestamp;

   public ChatbotDTO(Chatbot chatbot){
         this.patientId = chatbot.getPatientId();
         this.doctorId = chatbot.getDoctorId();
         this.question = chatbot.getQuestion();
         this.answer = chatbot.getAnswer();
         this.timestamp = chatbot.getTimestamp();
   }




}

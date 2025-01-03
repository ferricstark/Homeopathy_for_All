package com.homeopathyforall.dto;

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



}

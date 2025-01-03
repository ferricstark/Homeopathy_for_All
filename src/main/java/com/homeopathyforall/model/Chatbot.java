package com.homeopathyforall.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "chatbot_responses")
public class Chatbot {
    @Id
    private String id;
    private String patientId;
    private String doctorId;
    private String question;
    private String answer;
    private String timestamp;



}

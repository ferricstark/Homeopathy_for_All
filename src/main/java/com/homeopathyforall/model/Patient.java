package com.homeopathyforall.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

    @Data
    @Document(collection = "patients")
    public class Patient {

        @Id
        private String id;

        @Indexed(unique = true)
        private String username;
        private String password;
        private String firstName;
        private String lastName;
        private String email;
        private String medicalHistory;
        private String contactInfo;
    }

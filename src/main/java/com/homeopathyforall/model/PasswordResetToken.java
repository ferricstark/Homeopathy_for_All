package com.homeopathyforall.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;

@AllArgsConstructor @NoArgsConstructor @Setter @Getter
public class PasswordResetToken {

    @Id
    private String id;
    private String username;


    private String token;
    private Date expirationDate;


}
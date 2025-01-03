package com.homeopathyforall.service;

import com.homeopathyforall.model.PasswordResetToken;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PasswordResetTokenRepository extends MongoRepository<PasswordResetToken, String> {

    PasswordResetToken findByToken(String token);
    PasswordResetToken findByUsername(String username);
}

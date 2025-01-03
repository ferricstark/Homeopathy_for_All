package com.homeopathyforall.repository;

import com.homeopathyforall.model.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface DoctorRepository extends MongoRepository<Doctor, String> {
    boolean existsByUsername(String username);
    Optional<Doctor> findByUsername(String username);
}

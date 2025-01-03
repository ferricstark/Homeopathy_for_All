package com.homeopathyforall.repository;

import com.homeopathyforall.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {
  boolean existsByUsername(String username);
  Optional<Patient> findByUsername(String username);
}

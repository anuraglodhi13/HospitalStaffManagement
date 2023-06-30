package com.astrotalk.hospitalmanagement.repository;

import com.astrotalk.hospitalmanagement.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    boolean existsByDoctorRegistrationNumber(String roomNumber);

}

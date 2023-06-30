package com.astrotalk.hospitalmanagement.repository;

import com.astrotalk.hospitalmanagement.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("SELECT p FROM Patient p WHERE p.admitInfo.status = 'ADMITTED'")
    List<Patient> findAllAdmittedPatients();
//    @Query(value = "SELECT * FROM Patient p WHERE p.patient_status = ?1", nativeQuery = true)
//    List<Patient> findAdmittedPatients(String status);
//    @Modifying
//    @Query(value = "UPDATE Patient p SET p.patient_status = ?1 WHERE p.patient_id = ?2")
//    void dischargePatient(String status, Long patientId);
}

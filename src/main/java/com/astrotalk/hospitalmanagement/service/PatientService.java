package com.astrotalk.hospitalmanagement.service;

import com.astrotalk.hospitalmanagement.model.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    Patient save(Patient patient);

    void deleteById(Long patientId);

    Optional<Patient> findById(Long patientId);

    List<Patient> findAll();

    List<Patient> findAdmittedPatients();

}

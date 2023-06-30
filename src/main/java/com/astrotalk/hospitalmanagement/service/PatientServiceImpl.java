package com.astrotalk.hospitalmanagement.service;

import com.astrotalk.hospitalmanagement.model.Patient;
import com.astrotalk.hospitalmanagement.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService{
    @Autowired
    PatientRepository patientRepository;

    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public void deleteById(Long patientId) {
        patientRepository.deleteById(patientId);
    }

    @Override
    public Optional<Patient> findById(Long patientId) {
        return patientRepository.findById(patientId);
    }

    @Override
    public List<Patient> findAdmittedPatients() {
        return patientRepository.findAllAdmittedPatients();
    }

//    @Override
//    public void dischargePatient(String status, Long patient_id) {
//        patientRepository.dischargePatient(status, patient_id);
//    }

}

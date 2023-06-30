package com.astrotalk.hospitalmanagement.service;

import com.astrotalk.hospitalmanagement.model.Doctor;
import com.astrotalk.hospitalmanagement.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class DoctorServiceImpl implements  DoctorService{
    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Boolean isDoctorExists(String doctorRegistrationNumber) {
        return doctorRepository.existsByDoctorRegistrationNumber(doctorRegistrationNumber);
    }

}

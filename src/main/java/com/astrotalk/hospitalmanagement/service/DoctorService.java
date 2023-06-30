package com.astrotalk.hospitalmanagement.service;

import com.astrotalk.hospitalmanagement.model.Doctor;
import com.astrotalk.hospitalmanagement.model.Room;

import javax.print.Doc;
import java.util.Optional;

public interface DoctorService {
    Doctor saveDoctor(Doctor doctor);

    Boolean isDoctorExists(String doctorRegistrationNumber);
}

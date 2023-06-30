package com.astrotalk.hospitalmanagement.controller;

import com.astrotalk.hospitalmanagement.constants.Constants;
import com.astrotalk.hospitalmanagement.model.Doctor;
import com.astrotalk.hospitalmanagement.response.ResponseHandler;
import com.astrotalk.hospitalmanagement.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/hospital/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @PostMapping("")
    public ResponseEntity<Object> createDoctor(@RequestBody Doctor doctor) {
        try {
            if (!doctorService.isDoctorExists(doctor.getDoctorRegistrationNumber())) {

                Doctor saveDoctor = doctorService.saveDoctor(doctor);

                if (saveDoctor != null) {
                    return ResponseHandler.generateResponse(Constants.SUCCESS_ADD_MESSAGE, HttpStatus.CREATED,
                            saveDoctor);
                }
            }
            return ResponseHandler.generateResponse(Constants.CONFLICT_MESSAGE_PATIENT_EXIST, HttpStatus.CONFLICT, null);
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
            return ResponseHandler.generateResponse(Constants.CONFLICT_MESSAGE, HttpStatus.CONFLICT, null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

}

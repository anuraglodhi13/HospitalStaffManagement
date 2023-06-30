package com.astrotalk.hospitalmanagement.controller;

import com.astrotalk.hospitalmanagement.constants.Constants;
import com.astrotalk.hospitalmanagement.model.Patient;
import com.astrotalk.hospitalmanagement.response.ResponseHandler;
import com.astrotalk.hospitalmanagement.service.AdmitInfoService;
import com.astrotalk.hospitalmanagement.service.DoctorService;
import com.astrotalk.hospitalmanagement.service.PatientService;
import com.astrotalk.hospitalmanagement.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hospital/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @Autowired
    private AdmitInfoService admitInfoService;

    @Autowired
    private RoomService roomService;

    @Autowired
    DoctorService doctorService;

    @GetMapping("/all")
    public ResponseEntity<Object> getAllPatients() {
        try {
            List<Patient> patients = patientService.findAll();
            if (patients.isEmpty() || patients.size() == 0) {
                return ResponseHandler.generateResponse(Constants.NO_DATA_MESSAGE, HttpStatus.NO_CONTENT, null);
            }
            return ResponseHandler.generateResponse(Constants.SUCCESS_GET_MESSAGE, HttpStatus.OK, patients);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/all/admitted")
    public ResponseEntity<Object> getAllAdmittedPatients() {
        try {
            List<Patient> patients = patientService.findAdmittedPatients();
            if (patients.isEmpty() || patients.size() == 0) {
                return ResponseHandler.generateResponse(Constants.NO_ADMITTED_PATIENT_MESSAGE, HttpStatus.OK, null);
            }
            return ResponseHandler.generateResponse(Constants.SUCCESS_GET_MESSAGE, HttpStatus.OK, patients);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<Object> getPatient(@PathVariable Long patientId) {
        try {
            Optional<Patient> searchedPatient = patientService.findById(patientId);
            if (searchedPatient.isEmpty()) {
                return ResponseHandler.generateResponse(Constants.NO_DATA_MESSAGE, HttpStatus.NO_CONTENT, null);
            }
            return ResponseHandler.generateResponse(Constants.SUCCESS_GET_MESSAGE, HttpStatus.OK, searchedPatient.get());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PostMapping("")
    public ResponseEntity<Object> createPatient(@RequestBody Patient patient) {
        try {
            if(!roomService.isRoomExists(patient.getRoom().getRoomNumber())) {
                return ResponseHandler.generateResponse(Constants.ROOM_NOT_PRESENT, HttpStatus.BAD_REQUEST,
                        null);
            }

            if(!doctorService.isDoctorExists(patient.getDoctor().getDoctorRegistrationNumber())) {
                return ResponseHandler.generateResponse(Constants.DOCTOR_NOT_PRESENT, HttpStatus.BAD_REQUEST,
                        null);
            }

                admitInfoService.saveAdmitInfo(patient.getAdmitInfo());

                Patient savedPatient = patientService.save(patient);

                if (savedPatient != null) {
                    return ResponseHandler.generateResponse(Constants.SUCCESS_ADD_MESSAGE, HttpStatus.CREATED,
                            savedPatient);
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

    @PutMapping("/{patientId}")
    public ResponseEntity<Object> updatePatient(@RequestBody Patient patient, @PathVariable Long patientId) {
        try {
            Optional<Patient> existPatient = patientService.findById(patientId);
            if (existPatient.isPresent()) {
                Patient searchedPatient = existPatient.get();
                searchedPatient.setDoctor(patient.getDoctor());
                searchedPatient.setRoom(patient.getRoom());
                searchedPatient.setAdmitInfo(patient.getAdmitInfo());
                Patient updatedPatient = patientService.save(searchedPatient);
                return ResponseHandler.generateResponse(Constants.UPDATE_SUCCESS_MESSAGE, HttpStatus.OK, updatedPatient);
            }
            return ResponseHandler.generateResponse(Constants.CONFLICT_MESSAGE_PATIENT_NOT_PRESENT, HttpStatus.CONFLICT,
                    null);
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
            return ResponseHandler.generateResponse(Constants.CONFLICT_MESSAGE, HttpStatus.CONFLICT, null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PutMapping("/discharge/{patientId}")
    public ResponseEntity<Object> dischargePatient(@PathVariable Long patientId) {
        try {
            Optional<Patient> existPatient = patientService.findById(patientId);
            if (existPatient.isPresent()) {
                Patient searchedPatient = existPatient.get();
                if(searchedPatient.getAdmitInfo().getStatus().equals(Constants.DISCHARGED))
                {
                    return ResponseHandler.generateResponse(Constants.PATIENT_ALREADY_DISCHARGED, HttpStatus.CONFLICT, null);
                }
				searchedPatient.getAdmitInfo().setStatus(Constants.DISCHARGED);
				Patient updatedPatient = patientService.save(searchedPatient);
                return ResponseHandler.generateResponse( Constants.DISCHARGE_SUCCESS, HttpStatus.OK, updatedPatient);
            }
            return ResponseHandler.generateResponse(Constants.CONFLICT_MESSAGE_PATIENT_NOT_PRESENT, HttpStatus.CONFLICT,
                    null);
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
            return ResponseHandler.generateResponse(Constants.CONFLICT_MESSAGE, HttpStatus.CONFLICT, null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @DeleteMapping("/{patientId}")
    public ResponseEntity<Object> deletePatient(@PathVariable Long patientId) {
        try {
            Optional<Patient> deletedPatient = patientService.findById(patientId);
            if (deletedPatient.isPresent()) {
                patientService.deleteById(patientId);
                return ResponseHandler.generateResponse(Constants.PATIENT_DELETE_SUCCESS_MESSAGE, HttpStatus.OK, deletedPatient);
            }
            return ResponseHandler.generateResponse(Constants.NO_DATA_MESSAGE, HttpStatus.CONFLICT,null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}

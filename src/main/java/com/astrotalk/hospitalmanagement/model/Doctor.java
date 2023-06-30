package com.astrotalk.hospitalmanagement.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="doctor")
public class Doctor {
    @Id
    private String doctorRegistrationNumber;
    private String name;
    private String specialization;
}

package com.astrotalk.hospitalmanagement.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@Entity
@Table(name="admitinfo")
public class AdmitInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate admitDate;
    private double expenses;
    private String status;
}

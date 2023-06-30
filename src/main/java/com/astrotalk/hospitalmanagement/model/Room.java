package com.astrotalk.hospitalmanagement.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="room")
public class Room {
    @Id
    private String roomNumber;
    private int capacity;
    private boolean availability;
}

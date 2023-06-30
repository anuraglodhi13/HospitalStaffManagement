package com.astrotalk.hospitalmanagement.service;

import com.astrotalk.hospitalmanagement.model.Room;
import com.astrotalk.hospitalmanagement.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService{
    @Autowired
    RoomRepository roomRepository;

    @Override
    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Boolean isRoomExists(String roomNumber) {
        return roomRepository.existsByRoomNumber(roomNumber);
    }

}

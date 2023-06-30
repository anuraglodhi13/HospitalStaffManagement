package com.astrotalk.hospitalmanagement.service;

import com.astrotalk.hospitalmanagement.model.Room;

import java.util.Optional;

public interface RoomService {
    Room saveRoom(Room room);
    Boolean isRoomExists(String roomNumber);
}

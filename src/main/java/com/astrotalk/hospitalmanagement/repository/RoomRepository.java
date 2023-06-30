package com.astrotalk.hospitalmanagement.repository;

import com.astrotalk.hospitalmanagement.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    boolean existsByRoomNumber(String roomNumber);
}

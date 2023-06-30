package com.astrotalk.hospitalmanagement.controller;

import com.astrotalk.hospitalmanagement.constants.Constants;
import com.astrotalk.hospitalmanagement.model.Room;
import com.astrotalk.hospitalmanagement.response.ResponseHandler;
import com.astrotalk.hospitalmanagement.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/hospital/room")
public class RoomController {

    @Autowired
    RoomService roomService;

    @PostMapping("")
    public ResponseEntity<Object> createRoom(@RequestBody Room room) {
        try {
            if (!roomService.isRoomExists(room.getRoomNumber())) {
                Room savedRoom = roomService.saveRoom(room);

                if (savedRoom != null) {
                    return ResponseHandler.generateResponse(Constants.SUCCESS_ADD_MESSAGE, HttpStatus.CREATED,
                            savedRoom);
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

package com.example.tipunapi.services.room;

import com.example.tipunapi.models.Room;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RoomService {
    List<Room> getAllRooms();
    Room addRoom(Room room);
    Room editRoom(Room room);
    ResponseEntity deleteRoom(Room room);
    Room getRoomById(Long id);

    List<Room> searchRoomByTitle(String keyword, String location);
}

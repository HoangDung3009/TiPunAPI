package com.example.tipunapi.services.room;

import com.example.tipunapi.models.Room;
import com.example.tipunapi.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService{

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Room addRoom(Room room) {
        return roomRepository.saveAndFlush(room);
    }



    @Override
    public Room editRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public ResponseEntity deleteRoom(Room room) {
        roomRepository.delete(room);
        return ResponseEntity.ok("Room has been deleted!!");
    }

    @Override
    public Room getRoomById(Long id) {
        return roomRepository.getRoomById(id);
    }

    @Override
    public List<Room> searchRoomByTitle(String keyword, String location) {
        return roomRepository.findRoomsByTitle(keyword, location);
    }
}

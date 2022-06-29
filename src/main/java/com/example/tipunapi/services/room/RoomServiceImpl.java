package com.example.tipunapi.services.room;

import com.example.tipunapi.models.Room;
import com.example.tipunapi.models.User;
import com.example.tipunapi.repositories.RoomRepository;
import com.example.tipunapi.repositories.UtilRepository;
import com.example.tipunapi.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService{

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UtilRepository utilRepository;

    @Override
    public List<Room> getAllRooms(Long id) {
        return roomRepository.getAllRoom(id);
    }

    @Override
    public Room addRoom(Room room, Long id)
    {
        User user  = userService.findUserById(id);
        if (user != null){
            room.setPostUser(user);
            roomRepository.saveAndFlush(room);
            return room;
        }
        return null;
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

    @Override
    public List<Room> getRoomByUser(Long user_id) {
        return roomRepository.getRoomByUser(user_id);
    }
}

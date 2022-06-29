package com.example.tipunapi.controllers;

import com.example.tipunapi.dto.SearchDTO;
import com.example.tipunapi.models.Room;
import com.example.tipunapi.services.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("")
    public List<Room> getAllRooms(@RequestParam Long user_id){
        return roomService.getAllRooms(user_id);
    }

    @PostMapping("/add/{id}")
    public Room addRoom(@RequestBody Room room, @PathVariable Long id)
    {
        return roomService.addRoom(room, id);
    }

    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable Long id){
        return roomService.getRoomById(id);
    }

    @PostMapping("/search")
    public List<Room> searchRoomByTitle(@RequestBody SearchDTO searchDTO){
        return roomService.searchRoomByTitle(searchDTO.getKeyword(), searchDTO.getLocation());
    }

    @PutMapping("/update")
    public Room updateRoom(@RequestBody Room room){
        return roomService.editRoom(room);
    }

    @GetMapping("/user")
    public List<Room> getRoomByUser(@RequestParam Long user_id){
        return roomService.getRoomByUser(user_id);
    }

}

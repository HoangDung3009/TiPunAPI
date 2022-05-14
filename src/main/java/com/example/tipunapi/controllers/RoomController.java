package com.example.tipunapi.controllers;

import com.example.tipunapi.dto.SearchDTO;
import com.example.tipunapi.models.Room;
import com.example.tipunapi.services.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("")
    public List<Room> getAllRooms(){
        return roomService.getAllRooms();
    }

    @PostMapping("/add")
    public Room addRoom(@Validated @RequestBody Room room){
        return roomService.addRoom(room);
    }

    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable Long id){
        return roomService.getRoomById(id);
    }

    @PostMapping("/search")
    public List<Room> searchRoomByTitle(@RequestBody SearchDTO searchDTO){
        return roomService.searchRoomByTitle(searchDTO.getKeyword(), searchDTO.getLocation());
    }

}

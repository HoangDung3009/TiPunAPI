package com.example.tipunapi.controllers;

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

    @GetMapping("/{location}-{keyword}")
    public List<Room> searchRoomByTitle(@PathVariable String location, @PathVariable String keyword){
        return roomService.searchRoomByTitle(location, keyword);
    }

}

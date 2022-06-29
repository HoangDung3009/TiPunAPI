package com.example.tipunapi.controllers;

import com.example.tipunapi.models.RoomImages;
import com.example.tipunapi.services.room_image.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping("/{id}")
    List<RoomImages> getImagesByRoom(@PathVariable Long id){
        return imageService.getImagesByRoom(id);
    }

    @PostMapping("/add/{id}")
    RoomImages saveImage(@RequestBody RoomImages roomImages,@PathVariable Long id){
        return imageService.saveImage(roomImages, id);
    }
}

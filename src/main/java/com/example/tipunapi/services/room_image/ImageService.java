package com.example.tipunapi.services.room_image;

import com.example.tipunapi.models.Room;
import com.example.tipunapi.models.RoomImages;

import java.util.List;

public interface ImageService {
    List<RoomImages> getImagesByRoom(Long id);
    RoomImages saveImage(RoomImages roomImages, Long id);
}

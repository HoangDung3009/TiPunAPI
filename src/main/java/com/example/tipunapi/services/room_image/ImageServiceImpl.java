package com.example.tipunapi.services.room_image;

import com.example.tipunapi.models.RoomImages;
import com.example.tipunapi.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService{

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public List<RoomImages> getImagesByRoom(Long id) {
        return imageRepository.findRoomImagesByRoom(id);
    }

    @Override
    public RoomImages saveImage(RoomImages roomImages, Long id) {
        return imageRepository.saveAndFlush(roomImages);
    }
}

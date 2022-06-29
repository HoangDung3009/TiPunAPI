package com.example.tipunapi.repositories;

import com.example.tipunapi.models.Room;
import com.example.tipunapi.models.RoomImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<RoomImages, Long> {
    @Query("SELECT ri from RoomImages ri WHERE ri.room.id = ?1 ")
    List<RoomImages> findRoomImagesByRoom(Long room_id);
}

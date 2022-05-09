package com.example.tipunapi.repositories;

import com.example.tipunapi.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    Room getRoomById(Long id);
    @Query("FROM Room AS room WHERE room.title LIKE %?1% and room.city = ?2 ")
    List<Room> searchRoomByTitle(String keyword, String location);
}

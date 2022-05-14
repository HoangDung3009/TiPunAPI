package com.example.tipunapi.repositories;

import com.example.tipunapi.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    Room getRoomById(Long id);
    @Query("SELECT r from Room r where r.title like %?1% and r.district = ?2 ")
    List<Room> findRoomsByTitle(String keyword, String location);
}

package com.example.tipunapi.repositories;

import com.example.tipunapi.models.Utilities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilRepository extends JpaRepository<Utilities, Long> {
}

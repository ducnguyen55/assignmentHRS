package com.assignment.hotelbooking.repository;

import com.assignment.hotelbooking.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<HotelEntity, Long> {
    List<HotelEntity> findByDestination(String destination);
}

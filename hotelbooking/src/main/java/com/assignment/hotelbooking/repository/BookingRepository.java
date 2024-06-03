package com.assignment.hotelbooking.repository;

import com.assignment.hotelbooking.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {

}

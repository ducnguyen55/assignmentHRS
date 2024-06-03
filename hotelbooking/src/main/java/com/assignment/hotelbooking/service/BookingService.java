package com.assignment.hotelbooking.service;

import com.assignment.hotelbooking.entity.BookingEntity;
import com.assignment.hotelbooking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public BookingEntity createBooking(BookingEntity booking) {
        return bookingRepository.save(booking);
    }

    public Optional<BookingEntity> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    public BookingEntity updateBooking(BookingEntity booking) {
        return bookingRepository.save(booking);
    }

    public void cancelBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}

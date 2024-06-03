package com.assignment.hotelbooking.controller;

import com.assignment.hotelbooking.entity.BookingEntity;
import com.assignment.hotelbooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping
    public BookingEntity createBooking(@RequestBody BookingEntity booking) {
        return bookingService.createBooking(booking);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingEntity> getBooking(@PathVariable Long id) {
        Optional<BookingEntity> optionalBooking = bookingService.getBookingById(id);
        return optionalBooking.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public BookingEntity updateBooking(@PathVariable Long id, @RequestBody BookingEntity booking) {
        booking.setId(id);
        return bookingService.updateBooking(booking);
    }

    @DeleteMapping("/{id}")
    public void cancelBooking(@PathVariable Long id) {
        bookingService.cancelBooking(id);
    }
}

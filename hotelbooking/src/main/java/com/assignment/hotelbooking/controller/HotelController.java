package com.assignment.hotelbooking.controller;

import com.assignment.hotelbooking.entity.HotelEntity;
import com.assignment.hotelbooking.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping
    public List<HotelEntity> searchHotels(@RequestParam String destination) {
        return hotelService.searchHotelsByDestination(destination);
    }

    @PostMapping
    public HotelEntity createHotels(@RequestBody HotelEntity hotelEntity) {
        return hotelService.createHotel(hotelEntity);
    }
}

package com.assignment.hotelbooking.service;

import com.assignment.hotelbooking.entity.HotelEntity;
import com.assignment.hotelbooking.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    public List<HotelEntity> searchHotelsByDestination(String destination) {
        return hotelRepository.findByDestination(destination);
    }

    public HotelEntity createHotel(HotelEntity hotelEntity) {
        return hotelRepository.save(hotelEntity);
    }
}

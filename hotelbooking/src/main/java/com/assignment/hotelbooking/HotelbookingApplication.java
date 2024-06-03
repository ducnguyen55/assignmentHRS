package com.assignment.hotelbooking;

import com.assignment.hotelbooking.entity.BookingEntity;
import com.assignment.hotelbooking.entity.HotelEntity;
import com.assignment.hotelbooking.service.BookingService;
import com.assignment.hotelbooking.service.HotelService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class HotelbookingApplication {

    public static void main(String[] args) {
		SpringApplication.run(HotelbookingApplication.class, args);
	}

	private static void insertSampleData() {

		HotelService hotelService = new HotelService();

		HotelEntity hotelEntity1 = new HotelEntity();
		hotelEntity1.setName("Hotel ABC");
		hotelEntity1.setDestination("New York");
		hotelService.createHotel(hotelEntity1);

		HotelEntity hotelEntity2 = new HotelEntity();
		hotelEntity2.setName("Hotel XYZ");
		hotelEntity2.setDestination("London");
		hotelService.createHotel(hotelEntity2);

		BookingService bookingService = new BookingService();

		BookingEntity booking1 = new BookingEntity();
		booking1.setHotel(hotelEntity1);
		booking1.setStartDate(new Date(2024, 06, 03));
		booking1.setEndDate(new Date(2024, 06, 05));
		bookingService.createBooking(booking1);

		BookingEntity booking2 = new BookingEntity();
		booking2.setHotel(hotelEntity2);
		booking2.setStartDate(new Date(2024, 06, 01));
		booking2.setEndDate(new Date(2024, 06, 05));
		bookingService.createBooking(booking2);
	}
}

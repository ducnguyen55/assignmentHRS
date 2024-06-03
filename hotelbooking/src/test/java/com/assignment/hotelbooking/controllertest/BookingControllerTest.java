package com.assignment.hotelbooking.controllertest;
import static org.mockito.Mockito.*;

import java.util.Optional;

import com.assignment.hotelbooking.controller.BookingController;
import com.assignment.hotelbooking.service.BookingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.assignment.hotelbooking.entity.BookingEntity;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class BookingControllerTest {

    @Mock
    private BookingService bookingService;

    @InjectMocks
    private BookingController bookingController;

    @Test
    public void testCreateBooking() throws Exception {
        // Mock data
        BookingEntity booking = new BookingEntity();
        booking.setId(1L);
        // Set other properties as needed

        // Convert booking to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String bookingJson = objectMapper.writeValueAsString(booking);

        // Mock service response
        when(bookingService.createBooking(any(BookingEntity.class))).thenReturn(booking);

        // Mock MVC setup
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(bookingController).build();

        // Perform POST request
        mockMvc.perform(post("/bookings")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bookingJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1)); // Check the response contains the booking ID

        // Verify that the service method was called with the correct argument
        verify(bookingService, times(1)).createBooking(any(BookingEntity.class));
    }

    @Test
    public void testGetBooking() throws Exception {
        // Mock data
        BookingEntity booking = new BookingEntity();
        booking.setId(1L);
        // Set other properties as needed

        // Mock service response
        when(bookingService.getBookingById(1L)).thenReturn(Optional.of(booking));

        // Mock MVC setup
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(bookingController).build();

        // Perform GET request
        mockMvc.perform(get("/bookings/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1)); // Check the response contains the booking ID

        // Verify that the service method was called with the correct argument
        verify(bookingService, times(1)).getBookingById(1L);
    }

    @Test
    public void testUpdateBooking() throws Exception {
        // Mock data
        BookingEntity booking = new BookingEntity();
        booking.setId(1L);
        // Set other properties as needed

        // Convert booking to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String bookingJson = objectMapper.writeValueAsString(booking);

        // Mock service response
        when(bookingService.updateBooking(any(BookingEntity.class))).thenReturn(booking);

        // Mock MVC setup
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(bookingController).build();

        // Perform PUT request
        mockMvc.perform(put("/bookings/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bookingJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1)); // Check the response contains the booking ID

        // Verify that the service method was called with the correct argument
        verify(bookingService, times(1)).updateBooking(any(BookingEntity.class));
    }
}


package com.assignment.hotelbooking.controllertest;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import com.assignment.hotelbooking.controller.HotelController;
import com.assignment.hotelbooking.entity.HotelEntity;
import com.assignment.hotelbooking.service.HotelService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class HotelControllerTest {

    @Mock
    private HotelService hotelService;

    @InjectMocks
    private HotelController hotelController;

    @Test
    public void testSearchHotels() throws Exception {
        // Mock data
        HotelEntity hotel1 = new HotelEntity();
        hotel1.setId(1L);
        hotel1.setName("Hotel A");
        hotel1.setDestination("Paris");

        HotelEntity hotel2 = new HotelEntity();
        hotel2.setId(2L);
        hotel2.setName("Hotel B");
        hotel2.setDestination("Paris");

        List<HotelEntity> hotels = Arrays.asList(hotel1, hotel2);

        // Mock service response
        when(hotelService.searchHotelsByDestination("Paris")).thenReturn(hotels);

        // Mock MVC setup
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(hotelController).build();

        // Perform GET request
        mockMvc.perform(get("/hotels")
                        .param("destination", "Paris")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Hotel A"))
                .andExpect(jsonPath("$[0].destination").value("Paris"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("Hotel B"))
                .andExpect(jsonPath("$[1].destination").value("Paris"));

        // Verify that the service method was called with the correct argument
        verify(hotelService, times(1)).searchHotelsByDestination("Paris");
    }
}

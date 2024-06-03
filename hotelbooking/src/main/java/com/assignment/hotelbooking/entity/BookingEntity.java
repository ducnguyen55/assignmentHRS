package com.assignment.hotelbooking.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class BookingEntity {

    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    private Long id = 0L;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private HotelEntity hotelEntity;

    private Date startDate;
    private Date endDate;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HotelEntity getHotel() {
        return hotelEntity;
    }

    public void setHotel(HotelEntity hotelEntity) {
        this.hotelEntity = hotelEntity;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}

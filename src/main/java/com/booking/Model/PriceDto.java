package com.booking.Model;

import java.time.LocalDate;
import java.util.List;


public class PriceDto {
    LocalDate startDate;
    LocalDate endDate;
    Place place;
    int rooms;

    public PriceDto() {
    }

    public PriceDto(LocalDate endDate, Place lodgement, int rooms, LocalDate startDate) {
        this.endDate = endDate;
        this.place = lodgement;
        this.rooms = rooms;
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }



    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}

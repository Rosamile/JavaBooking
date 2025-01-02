package com.booking.Model;

import java.time.LocalDate;

public class PlaceDto {

    String city;
    String type;
    LocalDate startDate;
    LocalDate endDate;
    int kids;
    int adult;
    int rooms;

    public PlaceDto() {
    }

    public PlaceDto(int adult, String city, LocalDate endDate, int kids, int rooms, LocalDate startDate, String type) {
        this.adult = adult;
        this.city = city;
        this.endDate = endDate;
        this.kids = kids;
        this.rooms = rooms;
        this.startDate = startDate;
        this.type = type;
    }

    public int getAdult() {
        return adult;
    }

    public void setAdult(int adult) {
        this.adult = adult;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getKids() {
        return kids;
    }

    public void setKids(int kids) {
        this.kids = kids;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

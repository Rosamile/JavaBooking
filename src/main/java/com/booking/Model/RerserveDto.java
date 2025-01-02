package com.booking.Model;

import java.time.LocalDate;

public class RerserveDto {
    String firstName;
    String lastName;
    String nationality;
    LocalDate birthdate;
    String phone;
    String email;
    LocalDate startDate;
    LocalDate endDate;
    String place;
    String room;

    public RerserveDto() {
    }

    public RerserveDto(LocalDate birthdate, String email, LocalDate endDate, String firstName, String lastName, String nationality, String phone, String place, String room, LocalDate startDate) {
        this.birthdate = birthdate;
        this.email = email;
        this.endDate = endDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
        this.phone = phone;
        this.place = place;
        this.room = room;
        this.startDate = startDate;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}

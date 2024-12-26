package com.booking.Model;

import java.time.LocalDate;


public class Reserve {
    private Customer customer;
    private Room reserveRoom;
    private LocalDate startDateReserve;
    private LocalDate endDateReserve;
    private String stateReserve;
    private LocalDate reserveDate;
    private LocalDate confirmationDate;
    private LocalDate finalStartDate;
    private LocalDate finalEndDate;
    private Room finalRoom;
    private String activity;
    private String alimentPack;

    public Reserve() {
    }

    public Reserve(String activity, String alimentPack, LocalDate confirmationDate, Customer customer,
                   LocalDate endDateReserve, LocalDate finalEndDate, Room finalRoom, LocalDate finalStartDate,
                   LocalDate reserveDate, Room reserveRoom, LocalDate startDateReserve, String stateReserve) {
        this.activity = activity;
        this.alimentPack = alimentPack;
        this.confirmationDate = confirmationDate;
        this.customer = customer;
        this.endDateReserve = endDateReserve;
        this.finalEndDate = finalEndDate;
        this.finalRoom = finalRoom;
        this.finalStartDate = finalStartDate;
        this.reserveDate = reserveDate;
        this.reserveRoom = reserveRoom;
        this.startDateReserve = startDateReserve;
        this.stateReserve = stateReserve;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getAlimentPack() {
        return alimentPack;
    }

    public void setAlimentPack(String alimentPack) {
        this.alimentPack = alimentPack;
    }

    public LocalDate getConfirmationDate() {
        return confirmationDate;
    }

    public void setConfirmationDate(LocalDate confirmationDate) {
        this.confirmationDate = confirmationDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getEndDateReserve() {
        return endDateReserve;
    }

    public void setEndDateReserve(LocalDate endDateReserve) {
        this.endDateReserve = endDateReserve;
    }

    public LocalDate getFinalEndDate() {
        return finalEndDate;
    }

    public void setFinalEndDate(LocalDate finalEndDate) {
        this.finalEndDate = finalEndDate;
    }

    public Room getFinalRoom() {
        return finalRoom;
    }

    public void setFinalRoom(Room finalRoom) {
        this.finalRoom = finalRoom;
    }

    public LocalDate getFinalStartDate() {
        return finalStartDate;
    }

    public void setFinalStartDate(LocalDate finalStartDate) {
        this.finalStartDate = finalStartDate;
    }

    public LocalDate getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(LocalDate reserveDate) {
        this.reserveDate = reserveDate;
    }

    public Room getReserveRoom() {
        return reserveRoom;
    }

    public void setReserveRoom(Room reserveRoom) {
        this.reserveRoom = reserveRoom;
    }

    public LocalDate getStartDateReserve() {
        return startDateReserve;
    }

    public void setStartDateReserve(LocalDate startDateReserve) {
        this.startDateReserve = startDateReserve;
    }

    public String getStateReserve() {
        return stateReserve;
    }

    public void setStateReserve(String stateReserve) {
        this.stateReserve = stateReserve;
    }
}

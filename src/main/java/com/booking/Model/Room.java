package com.booking.Model;

import java.util.UUID;

public class Room {
    private UUID id;
    private String typeRoom;
    private int capacity;
    private int price;
    private String feature;

    public Room() {
    }

    public Room(UUID id, Integer price, String typeRoom, String feature, int capacity) {
        this.id = id;
        this.price = price;
        this.typeRoom = typeRoom;
        this.feature = feature;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(String typeRoom) {
        this.typeRoom = typeRoom;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

package com.booking.Model;

import java.util.List;

public class Lodgement {

    private String city;
    private List<Room> rooms;
    private String type;
    private String qualification;
    private String name;
    private List<String> activities;
    private String food;

    public Lodgement(String city, String name, String qualification, List<Room> rooms, String type,   List<String> activities,  String food) {
        this.activities = activities;
        this.city = city;
        this.food = food;
        this.name = name;
        this.qualification = qualification;
        this.rooms = rooms;
        this.type = type;
    }

    public Lodgement() {
    }

    public List<String> getActivities() {
        return activities;
    }

    public void setActivities(List<String> activities) {
        this.activities = activities;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

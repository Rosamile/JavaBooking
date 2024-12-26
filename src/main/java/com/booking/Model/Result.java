package com.booking.Model;

import java.util.List;

public class Result {

    private String name;
    private String qualification;
    private double priceNight;
    private double priceCalculate;
    private List<String> activities;
    private String food;


    public Result() {
    }

    public Result(String name, double priceCalculate, double priceNight, String qualification, List<String> activities, String food) {
        this.name = name;
        this.priceCalculate = priceCalculate;
        this.priceNight = priceNight;
        this.qualification = qualification;
        this.activities = activities;
        this.food = food;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPriceCalculate() {
        return priceCalculate;
    }

    public void setPriceCalculate(double priceCalculate) {
        this.priceCalculate = priceCalculate;
    }

    public double getPriceNight() {
        return priceNight;
    }

    public void setPriceNight(double priceNight) {
        this.priceNight = priceNight;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public List<String> getActivities() {
        return activities;
    }

    public void setActivities(List<String> activities) {
        this.activities = activities;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }
}

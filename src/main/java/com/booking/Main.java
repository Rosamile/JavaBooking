package com.booking;

import com.booking.Model.Customer;
import com.booking.Model.Result;
import com.booking.Service.CustomerService;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CustomerService test1 = new CustomerService();

        List<Result> results = test1.filter("Medellin", "Finca",
                LocalDate.of(2024, 6, 15), LocalDate.of(2024, 6, 15), 2, 1, 1);
        //Client
        Customer customer1 = new Customer(35, LocalDate.of(1989, 5, 25), "Juan",
                "Perez");
        Customer customer2 = new Customer(15, LocalDate.of(2010, 10, 25), "Samuel",
                "Perez");

        System.out.println("User " + customer1.getFirstName() + customer1.getLastName());
        for(Result result: results){
            System.out.println(result.getName());
            System.out.println(result.getQualification());
            System.out.println(result.getPriceNight());
            System.out.println(result.getPriceCalculate());
            System.out.println(String.join(" ", result.getActivities()));
            System.out.println(result.getFood());
        }
    }
}
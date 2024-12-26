package com.booking.Model;

import java.time.LocalDate;

public class Customer {

   private String firstName ;
   private String lastName;
   private int age;
   private LocalDate birthdate;
   private String id;

    public Customer(int i, LocalDate localDate, String juan, String perez) {
    }

    public Customer(int age, LocalDate birthdate, String firstName, String id, String lastName) {
        this.age = age;
        this.birthdate = birthdate;
        this.firstName = firstName;
        this.id = id;
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

package com.booking.Model;

import java.time.LocalDate;
import java.util.UUID;

public class Customer {

   private String firstName ;
   private String lastName;
   private int age;
   private LocalDate birthdate;
   private UUID id;
   private  String nationality;
   private  String phone;
   private  String email;

    public Customer() {
    }

    public Customer(int age, LocalDate birthdate, String email, String firstName, UUID id, String lastName, String nationality, String phone) {
        this.age = age;
        this.birthdate = birthdate;
        this.email = email;
        this.firstName = firstName;
        this.id = id;
        this.lastName = lastName;
        this.nationality = nationality;
        this.phone = phone;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
}

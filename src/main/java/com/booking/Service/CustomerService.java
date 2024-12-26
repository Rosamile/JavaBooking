package com.booking.Service;

import com.booking.Model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class CustomerService {


    public List<Result> filter(String city, String type, LocalDate startDate, LocalDate endDate, int kids, int adult, int rooms) {

        List<Lodgement> places = new ArrayList<>();
        Room standard = new Room(UUID.randomUUID(), 20000, "Standard",
                "La habitación sencilla cuenta con una cama individual, aire acondicionado, escritorio," +
                        " TV de pantalla plana, cafetera, y baño privado con ducha.", 4);

        Room doubleRoom = new Room(UUID.randomUUID(), 35000, "Double",
                "La habitación doble tiene 2 camas dobles, vista al mar, " +
                        "aire acondicionado, cafetera, Tv de pantalla plana, ducha y escritorio.\n", 5);

        Room family = new Room(UUID.randomUUID(), 50000, "Family", "Cuenta con una cama " +
                "king size y dos camas individuales, aire acondicionado, TV de pantalla plana, cafetera, " +
                "minibar, y baño privado con ducha", 8);

        Room suite = new Room(UUID.randomUUID(), 80000, "Suite", "Incluye una cama king size," +
                " vistas panorámicas a la ciudad o al mar, aire acondicionado, TV de pantalla plana, cafetera," +
                " minibar, y baño privado con ducha y bañera.", 4);
        Room triple = new Room(UUID.randomUUID(), 60000, "Triple", "Dispone de tres camas " +
                "individuales, aire acondicionado, TV de pantalla plana, cafetera, minibar, y baño privado con ducha", 6);

        List<Room> place1Rooms = new ArrayList<>();
        place1Rooms.add(standard);
        place1Rooms.add(doubleRoom);
        place1Rooms.add(family);
        place1Rooms.add(suite);
        place1Rooms.add(triple);

        List<String> place1Activities = List.of("playa", "parque", "tour");
        List<String> place2Activities = List.of("piscina", "caballo", "tour");
        List<String> place3Activities = List.of("piscina", "spa", "parque", "tour");
        List<String> place4Activities = List.of("piscina");

        List<Room> place2Rooms = new ArrayList<>();
        place2Rooms.add(standard);
        place2Rooms.add(doubleRoom);
        place2Rooms.add(family);
        place2Rooms.add(suite);
        place2Rooms.add(triple);

        List<Room> place3Rooms = new ArrayList<>();
        place3Rooms.add(standard);
        place3Rooms.add(doubleRoom);
        place3Rooms.add(family);
        place3Rooms.add(suite);
        place3Rooms.add(triple);

        List<Room> place4Rooms = new ArrayList<>();
        place4Rooms.add(standard);

        Lodgement place1 = new Lodgement(
                "Cartagena",
                "Americas",
                "5",
                place1Rooms,
                "Hotel",
                place1Activities,
                "desayuno"
        );

        Lodgement place2 = new Lodgement("Medellin",
                "Heliconia",
                "4",
                place2Rooms,
                "Finca",
                place2Activities,
                "desayuno"
        );

        Lodgement place3 = new Lodgement("Bogotá",
                "Dorado",
                "4",
                place3Rooms,
                "Apartamento",
                place3Activities,
                "desayuno");

        Lodgement place4 = new Lodgement("Villavicencio",
                "El escondite",
                "5",
                place4Rooms,
                "Día de sol",
                place4Activities,
                "refrigerio");

        places.add(place1);
        places.add(place2);
        places.add(place3);
        places.add(place4);

        List<Result> results = new ArrayList<>();
        List<Reserve> reserves = new ArrayList<>();

        if(type.equalsIgnoreCase("Día de sol")){
            Result result = new Result();
            result.setName(place4.getName());
            result.setQualification(place4.getQualification());
            result.setActivities(place4Activities);
            result.setFood(place4.getFood());
            results.add(result);
            return results;
        }
        for (Lodgement place : places) {
            if (place.getCity().equalsIgnoreCase(city) && place.getType().equalsIgnoreCase(type)) {
                int total = kids + adult;
                for (Room room : place.getRooms()) {
                    if (room.getCapacity() >= total) {
                        boolean used = false;
                        for (Reserve reserve : reserves) {

                            if (reserve.getReserveRoom() == room && !free(reserve, startDate, endDate)) {
                                used=true;

                            }

                        }
                        if (!used){
                            Result res = results.stream()
                                    .filter(result -> result.getName().equalsIgnoreCase(place.getName())).findAny()
                                    .orElse(null);

                            if (res == null) {
                                Result result = new Result();
                                result.setName(place.getName());
                                result.setQualification(place.getQualification());
                                result.setPriceNight(room.getPrice());
                                result.setPriceCalculate(calculatePrice(startDate, reserves, endDate, place, rooms));
                                result.setActivities(place.getActivities());
                                result.setFood(place.getFood());
                                results.add(result);
                            }
                        }
                    }
                }
            }


        }

        return results;
    }

    private boolean free(Reserve reserve, LocalDate startDate, LocalDate endDate) {
        LocalDate reservationStart = reserve.getStartDateReserve();
        LocalDate reservationEnd = reserve.getEndDateReserve();
        if ((startDate.isAfter(reservationEnd) || startDate.isEqual(reservationEnd))
                || (endDate.isBefore(reservationStart)
                || endDate.isEqual(reservationStart))) {
            return true;
        }
        return false;
    }

    private boolean lastFiveDate(LocalDate startDate, LocalDate endDate) {

        int dayOfMonth1 = startDate.getDayOfMonth();
        int dayOfMonth2 = endDate.getDayOfMonth();

        if (dayOfMonth1 >= 25 || dayOfMonth2 >= 31) {
            return true;
        }
        return false;

    }

    private boolean tenToFifteen(LocalDate startDate, LocalDate endDate) {

        int dayOfMonth1 = startDate.getDayOfMonth();
        int dayOfMonth2 = endDate.getDayOfMonth();

        if (dayOfMonth1 >= 10 && dayOfMonth2 <= 15) {
            return true;
        }
        return false;
    }

    private boolean fiveToTeen(LocalDate startDate, LocalDate endDate) {

        int dayOfMonth1 = startDate.getDayOfMonth();
        int dayOfMonth2 = endDate.getDayOfMonth();

        if (dayOfMonth1 >= 10 && dayOfMonth2 <= 5) {
            return true;
        }
        return false;
    }

    private double calculatePrice(LocalDate startDate, List<Reserve> reserveList, LocalDate endDate, Lodgement lodgement, int rooms) {

        double price = 0;
        for (Room room : lodgement.getRooms()) {
            boolean used = false;
            for (Reserve reserve : reserveList) {
                if (reserve.getReserveRoom() == room && !free(reserve, startDate, endDate)) {
                    used = true;
                }
            }
            if (!used) {
                price = room.getPrice();
                break;
            }
        }
        price = price * rooms;

        if (lastFiveDate(startDate, endDate)) {
            price = price + (price * 0.15);
        }
        if (tenToFifteen(startDate, endDate)) {
            price = price + (price * 0.10);
        }
        if (fiveToTeen(startDate, endDate)) {
            price = price - (price * 0.08);
        }
        return price;
    }


}




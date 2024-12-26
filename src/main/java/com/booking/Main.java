package com.booking;

import com.booking.Model.Reserve;
import com.booking.Model.Result;
import com.booking.Service.CustomerService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        CustomerService service = new CustomerService();

        List<Result> results = service.filter("Medellin", "Finca",
                LocalDate.of(2024, 6, 15), LocalDate.of(2024, 6, 15), 2, 1, 1);

        String reserve = service.reserve("José", "Perez", "Colombiano",
                LocalDate.of(1989, 5, 27), "+5326987", "jose@htmgl",
                LocalDateTime.of(2024, 6, 25, 17, 30, 20),
                LocalDate.of(2024,6,25), LocalDate.of(2024,6,30),
                "Heliconia","standard");

        for (Result result : results) {
            System.out.println(result.getName());
            System.out.println(result.getQualification());
            System.out.println(result.getPriceNight());
            System.out.println(result.getPriceCalculate());
            System.out.println(String.join(" ", result.getActivities()));
            System.out.println(result.getFood());
        }
        System.out.println(reserve);

        Scanner in = new Scanner(System.in);

        System.out.println("Ingrese la fecha de nacimiento");
        String birthdate = in.next();
        System.out.println("Ingrese el correo electronico");
        String email = in.next();

        System.out.println(String.format("Los datos ingresados son: %s %s", birthdate, email));
        List<Reserve> reserves = service.validUser(email, birthdate);

        if(!reserves.isEmpty()) {
            boolean update = false;
            UUID toUpdate = null;

            for(Reserve reserve1: reserves) {
                System.out.println(reserve1.getId());
                System.out.println(reserve1.getReserveRoom().getTypeRoom());
                System.out.println(reserve1.getStartDateReserve());
                System.out.println(reserve1.getEndDateReserve());

                System.out.println(String.format("Desea actualizar la reserva: %s?", reserve1.getId()));
                update = in.nextBoolean();
                if (update) {
                    toUpdate = reserve1.getId();
                    break;
                }
            }

            if(update) {
                service.delete(toUpdate);
                System.out.println("Crear nueva reserva");

                System.out.println("Ingrese nombre");
                String nameIn = in.next();
                System.out.println("Ingrese apellido");
                String lastNameIn = in.next();
                System.out.println("Ingrese nacionalidad");
                String nationalityIn = in.next();
                System.out.println("Ingrese fecha de nacimiento");
                String birthdateIn = in.next();
                System.out.println("Ingrese telefono");
                String phoneIn = in.next();
                System.out.println("Ingrese email");
                String emailIn = in.next();
                System.out.println("Ingrese fecha de llegada");
                String arrivalTimeIn = in.next();
                System.out.println("Ingrese fecha de ingreso");
                String startDateIn = in.next();
                System.out.println("Ingrese fecha de salida");
                String endDateIn = in.next();
                System.out.println("Ingrese alojamiento");
                String placeIn = in.next();
                System.out.println("Ingrese habitacion");
                String roomIn = in.next();

                service.reserve(nameIn, lastNameIn, nationalityIn, toLocalDate(birthdateIn),phoneIn,emailIn, toLocalDateTime(arrivalTimeIn),toLocalDate(startDateIn), toLocalDate(endDateIn),placeIn,roomIn);
            }
        } else {
            System.out.println("Usuario invalido");
        }
    }

    public static LocalDate toLocalDate(String date) {
        String[] parts = date.split("/");
        return LocalDate.of(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
    }

    public static LocalDateTime toLocalDateTime(String date) {
        String[] parts = date.split("/");
        return LocalDateTime.of(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3]),Integer.parseInt(parts[4]));
    }
}
package com.booking;

import com.booking.Model.*;
import com.booking.Service.CustomerService;
import com.booking.Util.DataUtil;
import com.booking.iterator.PlaceIteratorImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;


public class Main {
    public static void main(String[] args) {

        CustomerService service = CustomerService.getInstance();

        PlaceIteratorImpl iterator = new PlaceIteratorImpl(DataUtil.getPlaces());
        while (iterator.hasNext()) {
            System.out.println(iterator.getNext().getName());
        }

        Scanner in = new Scanner(System.in);

        System.out.println("Bienvenido a Booking");

        boolean exit = false;

        while (!exit) {
            System.out.println("Ingresa la opción que deseas");

            System.out.println("1. Consultar disponibilidad");
            System.out.println("2. Consultar una reserva");
            System.out.println("3. Salir");

            int option = in.nextInt();

            if (option == 1) {
                create(in, service);
            } else if (option == 2) {
                filter(in, service);
            } else {
                exit = true;
            }
        }
    }

    public static Result getQueryParams(Scanner in, CustomerService service) {
        System.out.println("Ingrese los datos para consultar disponibilidad");


        System.out.println("Seleccione la Ciudad: ");
        System.out.println("1. Cartagena");
        System.out.println("2. Bogota");
        System.out.println("3. Medellin");
        int cityId = in.nextInt();
        String cityIn = switch (cityId) {
            case 1 -> "Cartagena";
            case 2 -> "Bogota";
            case 3 -> "Medellin";
            default -> "";
        };
        System.out.println("Seleccione el Tipo de alojamiento: ");
        System.out.println("1. Hotel");
        System.out.println("2. Apartamento");
        System.out.println("3. Finca");
        System.out.println("4. Día de sol");
        int typeId = in.nextInt();
        String typeIn = switch (typeId) {
            case 1 -> "Hotel";
            case 2 -> "Apartamento";
            case 3 -> "Finca";
            case 4 -> "Día de sol";
            default -> "";
        };
        System.out.println("Fecha ingreso: ");
        String startDate = in.next();
        System.out.println("Fecha de salida: ");
        String endDate = in.next();
        System.out.println("Cantidad de niños: ");
        int kidsIn = in.nextInt();
        System.out.println("Cantidad de adultos: ");
        int adults = in.nextInt();
        System.out.println("Numero de habitaciones: ");
        int rooms = in.nextInt();

        PlaceDto placeDto = new PlaceDto(adults, cityIn, toLocalDate(endDate), kidsIn, rooms, toLocalDate(startDate), typeIn);
        return execQuery(placeDto, in, service);
    }

    public static Result execQuery(PlaceDto placeDto, Scanner in, CustomerService service) {
        List<Result> resultList = service.filter(placeDto);

        System.out.println("Selecciona a continuacion el hospedaje de tu interes, o presiona 0 para volver ");

        for (int i = 0; i < resultList.size(); i++) {
            Result result = resultList.get(i);
            System.out.printf("""
                    %s. Nombre: %s, Calificación: %s, Habitación: %s ,Precio por noche: %s, Precio con descuentos aplicables: %s\s
                    """, 1 + i, result.getName(), result.getQualification(), result.getRoomName(), result.getPriceNight(), result.getPriceCalculate());
        }

        int id = in.nextInt();
        return (id == 0) ? null : resultList.get(id - 1);
    }

    public static void create(Scanner in, CustomerService service) {

        Result result = getQueryParams(in, service);

        if (result == null) {
            return;
        }

        System.out.println("Desea crear una reserva para el alojamiento seleccionado: ");
        System.out.println("1. Si");
        System.out.println("2. No");
        int opt = in.nextInt();

        if (opt == 2) {
            return;
        }

        System.out.println("¡Vamos a crear tú proxima experiencia! ");

        System.out.println("Ingrese nombre: ");
        String nameIn = in.next();
        System.out.println("Ingrese apellido: ");
        String lastNameIn = in.next();
        System.out.println("Ingrese nacionalidad: ");
        String nationalityIn = in.next();
        System.out.println("Ingrese fecha de nacimiento: ");
        String birthdateIn = in.next();
        System.out.println("Ingrese telefono: ");
        String phoneIn = in.next();
        System.out.println("Ingrese email: ");
        String emailIn = in.next();
        System.out.println("Ingrese fecha de ingreso: ");
        String startDateIn = in.next();
        System.out.println("Ingrese fecha de salida: ");
        String endDateIn = in.next();

        RerserveDto rerserveDto = new RerserveDto(toLocalDate(birthdateIn), emailIn, toLocalDate(endDateIn), nameIn, lastNameIn, nationalityIn, phoneIn, result.getName(), result.getRoomName(), toLocalDate(startDateIn));
        service.reserve(rerserveDto);
    }

    public static LocalDate toLocalDate(String date) {
        String[] parts = date.split("/");
        return LocalDate.of(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
    }

    public static LocalDateTime toLocalDateTime(String date) {
        String[] parts = date.split("/");
        return LocalDateTime.of(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]));
    }

    public static void filter(Scanner in, CustomerService service) {
        System.out.println("Ingrese la fecha de nacimiento");
        String birthdate = in.next();
        System.out.println("Ingrese el correo electronico");
        String email = in.next();

        System.out.println(String.format("Los datos ingresados son: %s %s", birthdate, email));
        List<Reserve> reserves = service.validUser(email, toLocalDate(birthdate));

        if (!reserves.isEmpty()) {
            int update = 2;
            UUID toUpdate = null;

            System.out.println("A continuación las reservas encontradas: ");

            for (Reserve reserve1 : reserves) {
                System.out.printf("""
                                habitacion: %s, fecha ingreso: %s, fecha salida: %s\s
                                """,
                        reserve1.getReserveRoom().getTypeRoom(),
                        reserve1.getStartDateReserve(), reserve1.getEndDateReserve());

                System.out.println("Desea actualizar esta reserva?");
                System.out.println("1. Si");
                System.out.println("2. No");

                update = in.nextInt();
                if (update == 1) {
                    toUpdate = reserve1.getId();
                    break;
                }
            }

            if (update == 1) {
                service.delete(toUpdate);
                create(in, service);
            }
        } else {
            System.out.println("Usuario invalido");
        }
    }
}
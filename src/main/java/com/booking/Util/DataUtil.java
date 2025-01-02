package com.booking.Util;

import com.booking.Model.Place;
import com.booking.Model.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class DataUtil {

    public static List<Place> getPlaces() {

        List<Place> places = new ArrayList<>();

        String piscina = "Piscina";
        String hotel = "Hotel";
        String land = "Finca";
        String apartment = "Apartamento";

        // Creación de habitaciones únicas para cada lugar

        List<Room> americasRooms = new ArrayList<Room>();

        Room standardAmericas = new Room(UUID.randomUUID(), 25000, "Standard Americas", "Habitación con cama individual, aire acondicionado y baño privado.", 3);
        Room doubleAmericas = new Room(UUID.randomUUID(), 40000, "Double Americas", "Habitación con dos camas dobles, aire acondicionado y vista al mar.", 5);
        Room familyAmericas = new Room(UUID.randomUUID(), 60000, "Family Americas", "Habitación con cama king size y literas para niños.", 6);
        Room suiteAmericas = new Room(UUID.randomUUID(), 85000, "Suite Americas", "Suite con cama king size, jacuzzi y vistas panorámicas.", 4);
        Room tripleAmericas = new Room(UUID.randomUUID(), 70000, "Triple Americas", "Habitación con tres camas individuales y balcón privado.", 4);


        americasRooms.add(standardAmericas);
        americasRooms.add(doubleAmericas);
        americasRooms.add(familyAmericas);
        americasRooms.add(suiteAmericas);
        americasRooms.add(tripleAmericas);

// Habitaciones para el hotel "Bacatá" en Santa Marta
        List<Room> bacataRooms = new ArrayList<Room>();
        Room standardBacata = new Room(UUID.randomUUID(), 26000, "Standard Bacatá", "Habitación sencilla con cama individual y TV.", 3);
        Room doubleBacata = new Room(UUID.randomUUID(), 42000, "Double Bacatá", "Habitación doble con dos camas y minibar.", 4);
        Room familyBacata = new Room(UUID.randomUUID(), 62000, "Family Bacatá", "Habitación familiar con dos camas dobles y sala de estar.", 7);
        Room suiteBacata = new Room(UUID.randomUUID(), 88000, "Suite Bacatá", "Suite de lujo con jacuzzi y vistas al mar.", 3);
        Room tripleBacata = new Room(UUID.randomUUID(), 72000, "Triple Bacatá", "Habitación con tres camas individuales y escritorio.", 5);
        bacataRooms.add(standardBacata);
        bacataRooms.add(doubleBacata);
        bacataRooms.add(familyBacata);
        bacataRooms.add(suiteBacata);
        bacataRooms.add(tripleBacata);


// Habitaciones para el hotel "Santa Aleja" en La Tebaida
        List<Room> santaAlejaRooms = new ArrayList<Room>();
        Room standardSantaAleja = new Room(UUID.randomUUID(), 27000, "Standard Santa Aleja", "Habitación básica con cama individual y Wi-Fi gratuito.", 2);
        Room doubleSantaAleja = new Room(UUID.randomUUID(), 43000, "Double Santa Aleja", "Habitación doble con balcón y aire acondicionado.", 5);
        Room familySantaAleja = new Room(UUID.randomUUID(), 63000, "Family Santa Aleja", "Habitación familiar con área de juegos y minibar.", 8);
        Room suiteSantaAleja = new Room(UUID.randomUUID(), 90000, "Suite Santa Aleja", "Suite con sala de estar y baño con bañera.", 3);
        Room tripleSantaAleja = new Room(UUID.randomUUID(), 74000, "Triple Santa Aleja", "Habitación con tres camas y acceso a la piscina.", 6);

        santaAlejaRooms.add(standardSantaAleja);
        santaAlejaRooms.add(doubleSantaAleja);
        santaAlejaRooms.add(familySantaAleja);
        santaAlejaRooms.add(suiteSantaAleja);
        santaAlejaRooms.add(tripleSantaAleja);

// Habitaciones para el hotel "Marriot" en Bogotá
        List<Room> marriotBogotaRooms = new ArrayList<Room>();
        Room standardMarriotB = new Room(UUID.randomUUID(), 28000, "Standard Marriot", "Habitación estándar con cama queen y TV.", 3);
        Room doubleMarriotB = new Room(UUID.randomUUID(), 44000, "Double Marriot", "Habitación doble con dos camas y baño privado.", 4);
        Room familyMarriotB = new Room(UUID.randomUUID(), 64000, "Family Marriot", "Habitación familiar con kitchenette y comedor.", 7);
        Room suiteMarriotB = new Room(UUID.randomUUID(), 92000, "Suite Marriot", "Suite ejecutiva con sala de reuniones y minibar.", 2);
        Room tripleMarriotB = new Room(UUID.randomUUID(), 76000, "Triple Marriot", "Habitación con tres camas y vistas a la ciudad.", 5);

        List<Room> marriotCartagenaRooms = new ArrayList<Room>();
        Room standardMarriotC = new Room(UUID.randomUUID(), 28000, "Standard Marriot", "Habitación estándar con cama queen y TV.", 3);
        Room doubleMarriotC = new Room(UUID.randomUUID(), 44000, "Double Marriot", "Habitación doble con dos camas y baño privado.", 4);
        Room familyMarriotC = new Room(UUID.randomUUID(), 64000, "Family Marriot", "Habitación familiar con kitchenette y comedor.", 7);
        Room suiteMarriotC = new Room(UUID.randomUUID(), 92000, "Suite Marriot", "Suite ejecutiva con sala de reuniones y minibar.", 2);
        Room tripleMarriotC = new Room(UUID.randomUUID(), 76000, "Triple Marriot", "Habitación con tres camas y vistas a la ciudad.", 5);

        List<Room> marriotMedellinRooms = new ArrayList<Room>();
        Room standardMarriotM = new Room(UUID.randomUUID(), 28000, "Standard Marriot", "Habitación estándar con cama queen y TV.", 3);
        Room doubleMarriotM = new Room(UUID.randomUUID(), 44000, "Double Marriot", "Habitación doble con dos camas y baño privado.", 4);
        Room familyMarriotM = new Room(UUID.randomUUID(), 64000, "Family Marriot", "Habitación familiar con kitchenette y comedor.", 7);
        Room suiteMarriotM = new Room(UUID.randomUUID(), 92000, "Suite Marriot", "Suite ejecutiva con sala de reuniones y minibar.", 2);
        Room tripleMarriotM = new Room(UUID.randomUUID(), 76000, "Triple Marriot", "Habitación con tres camas y vistas a la ciudad.", 5);

        marriotBogotaRooms.add(standardMarriotB);
        marriotBogotaRooms.add(doubleMarriotB);
        marriotBogotaRooms.add(familyMarriotB);
        marriotBogotaRooms.add(suiteMarriotB);
        marriotBogotaRooms.add(tripleMarriotB);

        marriotCartagenaRooms.add(standardMarriotC);
        marriotCartagenaRooms.add(doubleMarriotC);
        marriotCartagenaRooms.add(familyMarriotC);
        marriotCartagenaRooms.add(suiteMarriotC);
        marriotCartagenaRooms.add(tripleMarriotC);

        marriotMedellinRooms.add(standardMarriotM);
        marriotMedellinRooms.add(doubleMarriotM);
        marriotMedellinRooms.add(familyMarriotM);
        marriotMedellinRooms.add(suiteMarriotM);
        marriotMedellinRooms.add(tripleMarriotM);


// Habitaciones para el hotel "Hilton" en Bogotá
        List<Room> hiltonBogotaRooms = new ArrayList<Room>();
        Room standardHilton = new Room(UUID.randomUUID(), 29000, "Standard Hilton", "Habitación con cama individual y baño privado.", 4);
        Room doubleHilton = new Room(UUID.randomUUID(), 46000, "Double Hilton", "Habitación doble con vistas al parque.", 3);
        Room familyHilton = new Room(UUID.randomUUID(), 66000, "Family Hilton", "Habitación con cama king size y literas para niños.", 6);
        Room suiteHilton = new Room(UUID.randomUUID(), 94000, "Suite Hilton", "Suite presidencial con terraza y jacuzzi.", 2);
        Room tripleHilton = new Room(UUID.randomUUID(), 78000, "Triple Hilton", "Habitación con tres camas individuales y minibar.", 5);

        hiltonBogotaRooms.add(standardHilton);
        hiltonBogotaRooms.add(doubleHilton);
        hiltonBogotaRooms.add(familyHilton);
        hiltonBogotaRooms.add(suiteHilton);
        hiltonBogotaRooms.add(tripleHilton);

        List<Room> teminalRooms = new ArrayList<Room>();
        Room standardTerminal = new Room(UUID.randomUUID(), 29000, "Standard Hilton", "Habitación con cama individual y baño privado.", 4);
        Room doubleTerminal = new Room(UUID.randomUUID(), 46000, "Double Hilton", "Habitación doble con vistas al parque.", 3);
        Room familyTerminal = new Room(UUID.randomUUID(), 66000, "Family Hilton", "Habitación con cama king size y literas para niños.", 6);
        Room suiteTerminal = new Room(UUID.randomUUID(), 94000, "Suite Hilton", "Suite presidencial con terraza y jacuzzi.", 2);
        Room tripleTerminal = new Room(UUID.randomUUID(), 78000, "Triple Hilton", "Habitación con tres camas individuales y minibar.", 5);

        teminalRooms.add(standardTerminal);
        teminalRooms.add(doubleTerminal);
        teminalRooms.add(familyTerminal);
        teminalRooms.add(suiteTerminal);
        teminalRooms.add(tripleTerminal);


        //Habitaciones fincas

        List<Room> heliconiaRoom = new ArrayList<>();
        Room exclusiveHeliconia = new Room(UUID.randomUUID(), 70000, "Exclusive", "Habitación exclusiva para grupos, incluye cama king size, aire acondicionado, minibar y baño privado con bañera.", 10);
        heliconiaRoom.add(exclusiveHeliconia);

        List<Room> plazaRooms = new ArrayList<>();
        Room exclusivePlaza = new Room(UUID.randomUUID(), 70000, "Exclusive", "Habitación exclusiva para grupos, incluye cama king size, aire acondicionado, minibar y baño privado con bañera.", 10);
        heliconiaRoom.add(exclusivePlaza);

//Habitaciones apartamentos

        // Habitaciones para los apartamentos
        List<Room> doradoRooms = new ArrayList<Room>();
        Room doradoRoom = new Room(UUID.randomUUID(), 40000, "Apartment Room", "Una habitación acogedora en apartamento, equipada con cama doble, TV, aire acondicionado y baño privado.", 2);
        doradoRooms.add(doradoRoom);


        List<Place> getPlaces = new ArrayList<Place>();

        Place marriotCartagena = new Place("Cartagena", "Americas", "5", marriotCartagenaRooms, "Hotel", Arrays.asList("Playa", "Piscina"), "Desayuno");
        Place heliconia = new Place("Medellin", "Heliconia", "4", heliconiaRoom, "Finca", Arrays.asList("Senderismo", "Parrilla"), "Desayuno");
        Place dorado = new Place("Bogotá", "Dorado", "4", doradoRooms, "Apartamento", Arrays.asList("Cine", "Gimnasio"), "Desayuno");
        Place bacata = new Place("Santa Marta", "Bacatá", "4.5", bacataRooms, "Hotel", Arrays.asList("Playa", "Restaurante"), "Desayuno");
        Place santaAleja = new Place("La Tebaida", "Santa Aleja", "4.89", santaAlejaRooms, "Hotel", Arrays.asList("Spa", "Tours"), "Desayuno");
        Place marriotBogota = new Place("Bogotá", "Marriot", "5", marriotBogotaRooms, "Hotel", Arrays.asList("Gimnasio", "Restaurante"), "Desayuno");
        Place hiltonBogota = new Place("Bogotá", "Hilton", "5", hiltonBogotaRooms, "Hotel", Arrays.asList("Spa", "Eventos"), "Desayuno");
        Place plaza = new Place("Bogotá", "Plaza", "4.9", plazaRooms, "Finca", Arrays.asList("Parrilla", "Piscina"), "Desayuno");
        Place marriotMedellin = new Place("Medellin", "Marriot", "5", marriotMedellinRooms, "Hotel", Arrays.asList("Centro comercial", "Gimnasio"), "Desayuno");
        Place terminal = new Place("Buga", "Terminal", "5", teminalRooms, "Hotel", Arrays.asList("Tours", "Piscina"), "Desayuno");

        getPlaces.add(marriotBogota);
        getPlaces.add(heliconia);
        getPlaces.add(dorado);
        getPlaces.add(bacata);
        getPlaces.add(santaAleja);
        getPlaces.add(hiltonBogota);
        getPlaces.add(plaza);
        getPlaces.add(marriotMedellin);
        getPlaces.add(terminal);
        getPlaces.add(marriotCartagena);



        List<String> place1Activities = List.of("Playa", "Parque", "Gimnasio equipado", "Sauna", piscina, "Baño turco");
        List<String> place2Activities = List.of(piscina, "Caballo", "Bicicleta", "Senderismo");
        List<String> place3Activities = List.of("Parque infantil", "Gimnasio");
        List<String> place4Activities = List.of(piscina, "Spa", "Bar");

        List<Place> dayPassPlaces = new ArrayList<Place>();
        Place sunParadise = new Place("Cartagena", "Sun Paradise", "4.5", null, "Día de Sol", Arrays.asList("Acceso a piscina", "Almuerzo buffet", "Zona de descanso"), "Refrigerio");
        Place nature = new Place("Villavicencio", "Nature's Haven", "4.8", null, "Día de Sol", Arrays.asList("Cabalgatas", "Piscina natural", "Zona de picnic"), "Bebidas frescas");
        Place beachEs =  new Place("Santa Marta", "Beach Escape", "5", null, "Día de Sol", Arrays.asList("Playa privada", "Deportes acuáticos", "Barra libre"), "Refrigerio");

        dayPassPlaces.add(sunParadise);
        dayPassPlaces.add(nature);
        dayPassPlaces.add(beachEs);

        List<Room> sunDayRooms = new ArrayList<Room>();

        Room sunDaySunParadise = new Room(UUID.randomUUID(), 15000, "Día de sol Paradise", "Incluye  zonas humedas (Spa, psicina, jacuzzi)", 50);
        Room sunDaySunNature = new Room(UUID.randomUUID(), 25000, "Día de sol Nature", "Incluye acceso a zonas humedas (Spa, psicina, jacuzzi)", 50);
        Room sunDaySunBeachEs = new Room(UUID.randomUUID(), 20000, "Día de sol Beach ", "Incluye acceso a zonas  (Spa, psicina, jacuzzi)", 50);

        sunDayRooms.add(sunDaySunNature);
        sunDayRooms.add(sunDaySunBeachEs);
        sunDayRooms.add(sunDaySunParadise);


        String desayuno = "Desayuno";


        return getPlaces;
    }
}

package com.booking.Service;

import com.booking.Model.*;
import com.booking.Util.DataUtil;

import java.security.Provider;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;


public class CustomerService {

    private static CustomerService instance;

    public static CustomerService getInstance() {
        if (instance == null) {
            instance = new CustomerService();
            instance.init();
        }
        return instance;
    }


    private List<Place> places = new ArrayList<>();
    private List<Reserve> reserves = new ArrayList<>();

    private CustomerService() {

    }

    private void init() {
        this.places = DataUtil.getPlaces();
    }

    public List<Reserve> validUser(String email, LocalDate birthdate) {
        List<Reserve> results = new ArrayList<>();

        for (Reserve reserve : reserves) {
            Customer customer = reserve.getCustomer();

            if (customer.getEmail().equalsIgnoreCase(email) && customer.getBirthdate().isEqual(birthdate)) {
                results.add(reserve);
            }
        }

        return results;
    }

    public List<Result> filter(PlaceDto placeDto) {
        if (placeDto.getType().equalsIgnoreCase("Día de sol")) {
            return sunDay();
        }
        List<Result> results = new ArrayList<>();
        int total = placeDto.getKids() + placeDto.getAdult();

        places.stream().filter(place -> placeMatches(place, placeDto)).forEach(place -> processRooms(results, place, total, placeDto));
        return results;
    }

    private boolean placeMatches(Place place, PlaceDto placeDto) {
        return place.getCity().equalsIgnoreCase(placeDto.getCity()) && place.getType().equalsIgnoreCase(placeDto.getType());
    }

    private void processRooms(List<Result> results, Place place, int total, PlaceDto placeDto) {
        place.getRooms().stream().filter(room -> room.getCapacity() >= total && isRoomAvailable(room, placeDto))
                .forEach(room -> getFilteredPlaces(results, place, room.getPrice(), placeDto, room));
    }

    private boolean isRoomAvailable(Room room, PlaceDto placeDto) {
        return reserves.stream()
                .noneMatch(reserve -> reserve.getReserveRoom() == room &&
                        !isFree(reserve, placeDto.getStartDate(), placeDto.getEndDate()));
    }

    public void getFilteredPlaces(List<Result> results, Place place, double price, PlaceDto placeDto, Room room) {
        Result result1 = (Result) results.stream()
                .filter(result -> result.getName().equalsIgnoreCase(place.getName()))
                .findAny()
                .map(place1 -> null)
                .orElse(buildResult(place, price, placeDto, room));

        if (result1 != null) {
            results.add(result1);
        }
    }

    public Result buildResult(Place place, double price, PlaceDto placeDto, Room room) {
        Result result = new Result();


        PriceDto priceDto = new PriceDto(placeDto.getEndDate(), place, placeDto.getRooms(), placeDto.getStartDate());

        result.setName(place.getName());
        result.setQualification(place.getQualification());
        result.setPriceNight(price);
        result.setPriceCalculate(calculatePrice(priceDto));
        result.setActivities(place.getActivities());
        result.setFood(place.getFood());
        result.setRoomName(room.getTypeRoom());

        return result;
    }

    private boolean isFree(Reserve reserve, LocalDate startDate, LocalDate endDate) {
        LocalDate reservationStart = reserve.getStartDateReserve();
        LocalDate reservationEnd = reserve.getEndDateReserve();
        return ((startDate.isAfter(reservationEnd) || startDate.isEqual(reservationEnd))
                || (endDate.isBefore(reservationStart)
                || endDate.isEqual(reservationStart)));
    }

    private boolean lastFiveDate(LocalDate startDate, LocalDate endDate) {
        int dayOfMonth1 = startDate.getDayOfMonth();
        int dayOfMonth2 = endDate.getDayOfMonth();

        return (dayOfMonth1 >= 25 || dayOfMonth2 == 31);
    }

    private boolean tenToFifteen(LocalDate startDate, LocalDate endDate) {
        int dayOfMonth1 = startDate.getDayOfMonth();
        int dayOfMonth2 = endDate.getDayOfMonth();

        return (dayOfMonth1 >= 10 && dayOfMonth2 <= 15);
    }

    private boolean fiveToTeen(LocalDate startDate, LocalDate endDate) {
        int dayOfMonth1 = startDate.getDayOfMonth();
        int dayOfMonth2 = endDate.getDayOfMonth();

        return (dayOfMonth1 >= 10 && dayOfMonth2 <= 5);
    }

    private double calculatePrice(PriceDto priceDto) {
        long days = DAYS.between(priceDto.getStartDate(), priceDto.getEndDate());
        double basePrice = getRoomPrice(priceDto) * priceDto.getRooms();
        return applyDiscountsAndSurcharges(basePrice, priceDto) * days;
    }

    private double applyDiscountsAndSurcharges(double price, PriceDto priceDto) {
        LocalDate startDate = priceDto.getStartDate();
        LocalDate endDate = priceDto.getEndDate();
        if (lastFiveDate(startDate, endDate)) {
            price += price * 0.15;
        }
        if (tenToFifteen(startDate, endDate)) {
            price += price * 0.10;
        }
        if (fiveToTeen(startDate, endDate)) {
            price -= price * 0.08;
        }
        return price;
    }


    public void delete(UUID toUpdate) {
        reserves = reserves.stream()
                .filter(reserve -> reserve.getId() != toUpdate)
                .collect(Collectors.toList());
    }

    public List<Result> sunDay() {

        List<Result> results = new ArrayList<>();

        Place place4 = places.stream()
                .filter(placeObject -> placeObject.getName().equalsIgnoreCase("El escondite"))
                .findFirst()
                .orElse(null);

        if (place4 != null) {
            Result result = new Result();
            result.setName(place4.getName());
            result.setQualification(place4.getQualification());
            result.setActivities(place4.getActivities());
            result.setFood(place4.getFood());
            results.add(result);
        }

        return results;
    }

    public double getRoomPrice(PriceDto priceDto) {
        double price = 0;

        for (Room roomPrice : priceDto.getPlace().getRooms()) {
            if (!isReservedRoom(priceDto, roomPrice)) {
                price = roomPrice.getPrice();
                break;
            }
        }

        return price;
    }

    public boolean isReservedRoom(PriceDto priceDto, Room room) {
        return reserves.stream().anyMatch(reserve -> reserve.getReserveRoom() == room &&
                !isFree(reserve, priceDto.getStartDate(), priceDto.getEndDate()));
    }


    public void reserve(RerserveDto rerserveDto) {

        Customer customer = new Customer();
        customer.setFirstName(rerserveDto.getFirstName());
        customer.setLastName(rerserveDto.getLastName());
        customer.setNationality(rerserveDto.getNationality());
        customer.setBirthdate(rerserveDto.getBirthdate());
        customer.setPhone(rerserveDto.getPhone());
        customer.setEmail(rerserveDto.getEmail());

        Reserve reserve = new Reserve();
        reserve.setId(UUID.randomUUID());
        reserve.setStartDateReserve(rerserveDto.getStartDate());
        reserve.setEndDateReserve(rerserveDto.getEndDate());
        reserve.setCustomer(customer);

        for (Place place1 : places) {
            if (place1.getName().equalsIgnoreCase(rerserveDto.getPlace())) {
                for (Room room1 : place1.getRooms()) {
                    if (room1.getTypeRoom().equalsIgnoreCase(rerserveDto.getRoom())) {
                        reserve.setReserveRoom(room1);
                    }
                }
            }
        }

        reserves.add(reserve);
    }

    public void getServe(RerserveDto rerserveDto) {

    }

}




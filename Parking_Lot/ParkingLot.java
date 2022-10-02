package Parking_Lot;

import java.util.ArrayList;


public class ParkingLot implements Place {
    private String name;
    private int capacity, occupied, vacancy;
    private ArrayList<Vehicle> vehicles;

    /**
     * @brief constructor of ParkingLot class
     */
    public ParkingLot() {
        this.name = "ParkingLot";
        this.vehicles = new ArrayList<Vehicle>();
        this.capacity = 100;
        this.occupied = 0;
        this.vacancy = 100;
    }

    /**
     * @brief constructor of ParkingLot class
     * @param name
     * @param capacity
     */
    public ParkingLot(String name, int capacity) {
        this.name = name;
        this.vehicles = new ArrayList<Vehicle>();
        this.capacity = capacity;
        this.vacancy = capacity;
        this.occupied = 0;
    }

    /**
     * @brief set the name of the parking lot
     * @param place
     */
    public void setPlace(String place) {
        this.name = place;
    }

    /**
     * @brief get the name of the parking lot
     * @return string name
     */
    public String getPlace() {
        return this.name;
    }

    /**
     * @brief add a vehicle to the parking lot
     * @param vehicle
     */
    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
        this.occupied++;
        this.vacancy--;
    }

    /**
     * @brief remove a vehicle from the parking lot
     * @param vehicle
     */
    public void removeVehicle(Vehicle vehicle) {
        this.vehicles.remove(vehicle);
        this.occupied--;
        this.vacancy++;
    }

    /**
     * @brief get the capacity of the parking lot
     * @return int capacity
     */
    public int getCapacity() {
        return this.capacity;
    }

    /**
     * @brief get the number of occupied places in the parking lot
     * @return int occupied
     */
    public int getOccupied() {
        return this.occupied;
    }

    /**
     * @brief get the number of vacancy places in the parking lot
     * @return int vacancy
     */
    public int getVacancy() {
        return this.vacancy;
    }
}


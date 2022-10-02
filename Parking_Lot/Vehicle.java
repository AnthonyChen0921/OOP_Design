package Parking_Lot;

public class Vehicle {
    private String licensePlate;
    private String color;
    private String type;
    private String size;
    private String brand;
    private String model;
    private String year;
    private String owner;
    private String parkingLot;

    /**
     * @brief constructor of Vehicle class
     */
    public Vehicle() {
        this.licensePlate = "Unknown";
        this.color = "Unknown";
        this.type = "Unknown";
        this.size = "Unknown";
        this.brand = "Unknown";
        this.model = "Unknown";
        this.year = "Unknown";
        this.owner = "Unknown";
        this.parkingLot = "Unknown";
    }

    /**
     * @brief constructor of Vehicle class
     * @param licensePlate
     * @param color
     * @param type
     * @param size
     * @param brand
     * @param model
     * @param year
     * @param owner
     * @param parkingLot
     */
    public Vehicle(String licensePlate, String color, String type, String size, String brand, String model, String year, String owner, String parkingLot) {
        this.licensePlate = licensePlate;
        this.color = color;
        this.type = type;
        this.size = size;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.owner = owner;
        this.parkingLot = parkingLot;
    }

    /**
     * @brief set the license plate of the vehicle
     * @param licensePlate
     */
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    /**
     * @brief get the license plate of the vehicle
     * @return string licensePlate
     */
    public String getLicensePlate() {
        return this.licensePlate;
    }

    /**
     * @brief set the color of the vehicle
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @brief get the color of the vehicle
     * @return string color
     */
    public String getColor() {
        return this.color;
    }

    /**
     * @brief set the type of the vehicle
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @brief
     * @return string type
     */
    public String getType() {
        return this.type;
    }

    /**
     * @brief set the size of the vehicle
     * @param size
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * @brief get the size of the vehicle
     * @return string size
     */
    public String getSize() {
        return this.size;
    }

    /**
     * @brief set the brand of the vehicle
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @brief get the brand of the vehicle
     * @return string brand
     */
    public String getBrand() {
        return this.brand;
    }

    /**
     * @brief set the model of the vehicle
     * @param model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @brief get the model of the vehicle
     * @return string model
     */
    public String getModel() {
        return this.model;
    }

    /**
     * @brief set the year of the vehicle
     * @param year
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * @brief get the year of the vehicle
     * @return string year
     */
    public String getYear() {
        return this.year;
    }

    /**
     * @brief set the owner of the vehicle
     * @param owner
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * @brief get the owner of the vehicle
     * @return string owner
     */
    public String getOwner() {
        return this.owner;
    }

    /**
     * @brief set the parking lot of the vehicle
     * @param parkingLot
     */
    public void setParkingLot(String parkingLot) {
        this.parkingLot = parkingLot;
    }   

    /**
     * @brief get the parking lot of the vehicle
     * @return string parkingLot
     */
    public String getParkingLot() {
        return this.parkingLot;
    }

    
}

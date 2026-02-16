package be.nicholasmeyers.skoda.api.client;

/**
 * Represents the geographical location of a car, specified by latitude, longitude, and address.
 * <p>
 * This class provides access to the car's location through latitude and longitude coordinates and address information.
 * </p>
 */
public class CarLocation {
    private final Integer latitude;
    private final Integer longitude;
    private final String address;

    /**
     * Constructs a new CarLocation object with the specified latitude, longitude, and address.
     *
     * @param latitude  The latitude of the car's location.
     * @param longitude The longitude of the car's location.
     * @param address The address of the car's location.
     */
    CarLocation(Integer latitude, Integer longitude, String address) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
    }

    /**
     * Returns the latitude of the car's location.
     *
     * @return An {@link Integer} representing the latitude of the car's location.
     */
    public Integer getLatitude() {
        return latitude;
    }

    /**
     * Returns the longitude of the car's location.
     *
     * @return An {@link Integer} representing the longitude of the car's location.
     */
    public Integer getLongitude() {
        return longitude;
    }

    /**
     * Returns the address of the car's location.
     *
     * @return An {@link String} representing the address of the car's location.
     */
    public String getAddress() {
        return address;
    }
}

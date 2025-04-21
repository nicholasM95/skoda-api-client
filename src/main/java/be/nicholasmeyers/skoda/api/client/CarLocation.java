package be.nicholasmeyers.skoda.api.client;

/**
 * Represents the geographical location of a car, specified by latitude and longitude.
 * <p>
 * This class provides access to the car's location through latitude and longitude coordinates.
 * </p>
 */
public class CarLocation {
    private final Integer latitude;
    private final Integer longitude;

    /**
     * Constructs a new CarLocation object with the specified latitude and longitude.
     *
     * @param latitude  The latitude of the car's location.
     * @param longitude The longitude of the car's location.
     */
    CarLocation(Integer latitude, Integer longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
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
}

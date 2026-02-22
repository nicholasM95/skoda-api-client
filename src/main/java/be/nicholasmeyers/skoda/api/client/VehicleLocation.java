package be.nicholasmeyers.skoda.api.client;

/**
 * Represents the geographical location of a vehicle.
 * <p>
 * Instances of this class are created internally by the {@link VehicleService}
 * and are not intended to be constructed directly.
 * </p>
 */
public class VehicleLocation {

    private final Double latitude;
    private final Double longitude;
    private final String address;

    /**
     * Constructs a new {@code VehicleLocation} with the given coordinates and address.
     *
     * @param latitude  the latitude of the vehicle's location.
     * @param longitude the longitude of the vehicle's location.
     * @param address   the human-readable address of the vehicle's location.
     */
    VehicleLocation(Double latitude, Double longitude, String address) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
    }

    /**
     * Returns the latitude of the vehicle's location.
     *
     * @return the latitude coordinate.
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * Returns the longitude of the vehicle's location.
     *
     * @return the longitude coordinate.
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * Returns the human-readable address of the vehicle's location.
     *
     * @return the address.
     */
    public String getAddress() {
        return address;
    }
}
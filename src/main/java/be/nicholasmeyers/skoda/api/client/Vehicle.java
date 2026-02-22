package be.nicholasmeyers.skoda.api.client;

/**
 * Represents a Škoda vehicle associated with the authenticated account.
 * <p>
 * Instances of this class are created internally by the {@link VehicleService}
 * and are not intended to be constructed directly.
 * </p>
 */
public class Vehicle {

    private final String vin;
    private final String name;
    private final String title;
    private final String licensePlate;

    /**
     * Constructs a new {@code Vehicle} with the given details.
     *
     * @param vin          the Vehicle Identification Number uniquely identifying the vehicle.
     * @param name         the name of the vehicle.
     * @param title        the title or model description of the vehicle.
     * @param licensePlate the license plate of the vehicle.
     */
    Vehicle(String vin, String name, String title, String licensePlate) {
        this.vin = vin;
        this.name = name;
        this.title = title;
        this.licensePlate = licensePlate;
    }

    /**
     * Returns the Vehicle Identification Number (VIN) of the vehicle.
     *
     * @return the VIN.
     */
    public String getVin() {
        return vin;
    }

    /**
     * Returns the name of the vehicle.
     *
     * @return the vehicle name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the title or model description of the vehicle.
     *
     * @return the vehicle title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the license plate of the vehicle.
     *
     * @return the license plate.
     */
    public String getLicensePlate() {
        return licensePlate;
    }
}
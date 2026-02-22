package be.nicholasmeyers.skoda.api.client;

/**
 * Represents the current air conditioning status of a Škoda vehicle.
 * <p>
 * Instances of this class are created internally by the {@link VehicleService}
 * and are not intended to be constructed directly.
 * </p>
 */
public class VehicleAirConditioningStatus {

    private final String state;
    private final Double temperature;
    private final String temperatureUnit;
    private final String carCapturedTimestamp;

    /**
     * Constructs a new {@code VehicleAirConditioningStatus} with the given details.
     *
     * @param state                the current state of the air conditioning (e.g. {@code "ON"} or {@code "OFF"}).
     * @param temperature          the current target temperature.
     * @param temperatureUnit      the unit of the temperature (e.g. {@code "CELSIUS"}).
     * @param carCapturedTimestamp the timestamp at which this status was last captured by the vehicle.
     */
    VehicleAirConditioningStatus(String state, Double temperature, String temperatureUnit, String carCapturedTimestamp) {
        this.state = state;
        this.temperature = temperature;
        this.temperatureUnit = temperatureUnit;
        this.carCapturedTimestamp = carCapturedTimestamp;
    }

    /**
     * Returns the current state of the air conditioning.
     *
     * @return the air conditioning state (e.g. {@code "ON"} or {@code "OFF"}).
     */
    public String getState() {
        return state;
    }

    /**
     * Returns the current target temperature of the air conditioning.
     *
     * @return the target temperature.
     */
    public Double getTemperature() {
        return temperature;
    }

    /**
     * Returns the unit of the target temperature.
     *
     * @return the temperature unit (e.g. {@code "CELSIUS"}).
     */
    public String getTemperatureUnit() {
        return temperatureUnit;
    }

    /**
     * Returns the timestamp at which this status was last captured by the vehicle.
     *
     * @return the car captured timestamp.
     */
    public String getCarCapturedTimestamp() {
        return carCapturedTimestamp;
    }
}
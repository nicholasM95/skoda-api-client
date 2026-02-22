package be.nicholasmeyers.skoda.api.client;

/**
 * Represents the range and energy information of a Škoda vehicle.
 * <p>
 * Instances of this class are created internally by the {@link VehicleService}
 * and are not intended to be constructed directly.
 * </p>
 */
public class VehicleRange {

    private final String carType;
    private final Integer totalRangeInKm;
    private final String engineType;
    private final Integer currentSoCInPercent;
    private final Integer remainingRangeInKm;
    private final String carCapturedTimestamp;

    /**
     * Constructs a new {@code VehicleRange} with the given range and energy details.
     *
     * @param carType                the type of the car (e.g. {@code "ELECTRIC"} or {@code "HYBRID"}).
     * @param totalRangeInKm         the total range of the vehicle in kilometers.
     * @param engineType             the type of engine (e.g. {@code "EV"}).
     * @param currentSoCInPercent    the current state of charge of the battery as a percentage.
     * @param remainingRangeInKm     the remaining driving range in kilometers based on the current charge.
     * @param carCapturedTimestamp   the timestamp at which this data was last captured by the vehicle.
     */
    VehicleRange(String carType, Integer totalRangeInKm, String engineType, Integer currentSoCInPercent, Integer remainingRangeInKm, String carCapturedTimestamp) {
        this.carType = carType;
        this.totalRangeInKm = totalRangeInKm;
        this.engineType = engineType;
        this.currentSoCInPercent = currentSoCInPercent;
        this.remainingRangeInKm = remainingRangeInKm;
        this.carCapturedTimestamp = carCapturedTimestamp;
    }

    /**
     * Returns the type of the car.
     *
     * @return the car type (e.g. {@code "ELECTRIC"} or {@code "HYBRID"}).
     */
    public String getCarType() {
        return carType;
    }

    /**
     * Returns the total range of the vehicle in kilometers.
     *
     * @return the total range in km.
     */
    public Integer getTotalRangeInKm() {
        return totalRangeInKm;
    }

    /**
     * Returns the type of engine the vehicle uses.
     *
     * @return the engine type (e.g. {@code "EV"}).
     */
    public String getEngineType() {
        return engineType;
    }

    /**
     * Returns the current state of charge (SoC) of the battery as a percentage.
     *
     * @return the current state of charge in percent.
     */
    public Integer getCurrentSoCInPercent() {
        return currentSoCInPercent;
    }

    /**
     * Returns the remaining driving range based on the current battery charge.
     *
     * @return the remaining range in km.
     */
    public Integer getRemainingRangeInKm() {
        return remainingRangeInKm;
    }

    /**
     * Returns the timestamp at which this data was last captured by the vehicle.
     *
     * @return the car captured timestamp.
     */
    public String getCarCapturedTimestamp() {
        return carCapturedTimestamp;
    }
}
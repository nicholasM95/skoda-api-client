package be.nicholasmeyers.skoda.api.client;

/**
 * Represents the current charging state of a Škoda vehicle.
 * <p>
 * Instances of this class are created internally by the {@link VehicleService}
 * and are not intended to be constructed directly.
 * </p>
 */
public class VehicleChargingState {

    private final double chargingRateInKilometersPerHour;
    private final double chargePowerInKw;
    private final int remainingTimeToFullyChargedInMinutes;
    private final String state;
    private final String chargeType;
    private final int remainingCruisingRangeInMeters;
    private final int stateOfChargeInPercent;
    private final String carCapturedTimestamp;

    /**
     * Constructs a new {@code VehicleChargingState} with the given charging details.
     *
     * @param chargingRateInKilometersPerHour      the current charging rate in kilometers per hour.
     * @param chargePowerInKw                      the current charging power in kilowatts.
     * @param remainingTimeToFullyChargedInMinutes the estimated remaining time until fully charged in minutes.
     * @param state                                the current charging state (e.g. {@code "CHARGING"} or {@code "READY_FOR_CHARGING"}).
     * @param chargeType                           the type of charge being used (e.g. {@code "AC"} or {@code "DC"}).
     * @param remainingCruisingRangeInMeters       the remaining cruising range in meters based on the current charge.
     * @param stateOfChargeInPercent               the current state of charge of the battery as a percentage.
     * @param carCapturedTimestamp                 the timestamp at which this state was last captured by the vehicle.
     */
    VehicleChargingState(double chargingRateInKilometersPerHour, double chargePowerInKw, int remainingTimeToFullyChargedInMinutes, String state, String chargeType, int remainingCruisingRangeInMeters, int stateOfChargeInPercent, String carCapturedTimestamp) {
        this.chargingRateInKilometersPerHour = chargingRateInKilometersPerHour;
        this.chargePowerInKw = chargePowerInKw;
        this.remainingTimeToFullyChargedInMinutes = remainingTimeToFullyChargedInMinutes;
        this.state = state;
        this.chargeType = chargeType;
        this.remainingCruisingRangeInMeters = remainingCruisingRangeInMeters;
        this.stateOfChargeInPercent = stateOfChargeInPercent;
        this.carCapturedTimestamp = carCapturedTimestamp;
    }

    /**
     * Returns the current charging rate in kilometers per hour.
     *
     * @return the charging rate in km/h.
     */
    public double getChargingRateInKilometersPerHour() {
        return chargingRateInKilometersPerHour;
    }

    /**
     * Returns the current charging power in kilowatts.
     *
     * @return the charge power in kW.
     */
    public double getChargePowerInKw() {
        return chargePowerInKw;
    }

    /**
     * Returns the estimated remaining time until the battery is fully charged.
     *
     * @return the remaining time to fully charged in minutes.
     */
    public int getRemainingTimeToFullyChargedInMinutes() {
        return remainingTimeToFullyChargedInMinutes;
    }

    /**
     * Returns the current charging state of the vehicle.
     *
     * @return the charging state (e.g. {@code "CHARGING"} or {@code "READY_FOR_CHARGING"}).
     */
    public String getState() {
        return state;
    }

    /**
     * Returns the type of charge currently being used.
     *
     * @return the charge type (e.g. {@code "AC"} or {@code "DC"}).
     */
    public String getChargeType() {
        return chargeType;
    }

    /**
     * Returns the remaining cruising range based on the current battery charge.
     *
     * @return the remaining cruising range in meters.
     */
    public int getRemainingCruisingRangeInMeters() {
        return remainingCruisingRangeInMeters;
    }

    /**
     * Returns the current state of charge of the battery as a percentage.
     *
     * @return the state of charge in percent.
     */
    public int getStateOfChargeInPercent() {
        return stateOfChargeInPercent;
    }

    /**
     * Returns the timestamp at which the vehicle last captured this charging state.
     *
     * @return the car captured timestamp.
     */
    public String getCarCapturedTimestamp() {
        return carCapturedTimestamp;
    }
}
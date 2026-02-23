package be.nicholasmeyers.skoda.api.client;

/**
 * Represents a single charging session of a Škoda vehicle.
 * <p>
 * Instances of this class are created internally by the {@link VehicleService}
 * and are not intended to be constructed directly.
 * </p>
 */
public class VehicleChargingSession {

    private final String startAt;
    private final double chargedInKWh;
    private final int durationInMinutes;
    private final String currentType;

    /**
     * Constructs a new {@code VehicleChargingSession} with the given session details.
     *
     * @param startAt           the timestamp at which the charging session started.
     * @param chargedInKWh      the total energy charged during the session in kilowatt-hours.
     * @param durationInMinutes the duration of the charging session in minutes.
     * @param currentType       the type of current used during the session (e.g. {@code "AC"} or {@code "DC"}).
     */
    VehicleChargingSession(String startAt, double chargedInKWh, int durationInMinutes, String currentType) {
        this.startAt = startAt;
        this.chargedInKWh = chargedInKWh;
        this.durationInMinutes = durationInMinutes;
        this.currentType = currentType;
    }

    /**
     * Returns the timestamp at which the charging session started.
     *
     * @return the start timestamp.
     */
    public String getStartAt() {
        return startAt;
    }

    /**
     * Returns the total energy charged during the session in kilowatt-hours.
     *
     * @return the charged energy in kWh.
     */
    public double getChargedInKWh() {
        return chargedInKWh;
    }

    /**
     * Returns the duration of the charging session in minutes.
     *
     * @return the duration in minutes.
     */
    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    /**
     * Returns the type of current used during the charging session.
     *
     * @return the current type (e.g. {@code "AC"} or {@code "DC"}).
     */
    public String getCurrentType() {
        return currentType;
    }
}
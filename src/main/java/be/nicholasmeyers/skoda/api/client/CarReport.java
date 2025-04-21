package be.nicholasmeyers.skoda.api.client;

/**
 * Represents the report related to the car's climatisation system, including its state, duration, remaining time, and status code.
 * <p>
 * This class contains details about the car's current climatisation state, the duration of the climatisation,
 * the remaining time until the climatisation is complete, and the corresponding status code.
 * </p>
 */
public class CarReport {
    private final String climatisationState;
    private final Integer climatisationDuration;
    private final Integer remainingClimateTime;
    private final Integer climateStatusCode;

    /**
     * Constructs a new {@link CarReport} object with the specified parameters.
     *
     * @param climatisationState The current state of the car's climatisation system (e.g., "ON", "OFF").
     * @param climatisationDuration The total duration for which the climatisation system will run, in seconds.
     * @param remainingClimateTime The remaining time for the climatisation system to run, in seconds.
     * @param climateStatusCode An integer representing the status code of the climatisation system (e.g., error codes, success codes).
     */
    CarReport(String climatisationState, Integer climatisationDuration, Integer remainingClimateTime, Integer climateStatusCode) {
        this.climatisationState = climatisationState;
        this.climatisationDuration = climatisationDuration;
        this.remainingClimateTime = remainingClimateTime;
        this.climateStatusCode = climateStatusCode;
    }

    /**
     * Returns the current state of the climatisation system.
     *
     * @return A {@link String} representing the state of the climatisation system (e.g., "ON", "OFF").
     */
    public String getClimatisationState() {
        return climatisationState;
    }

    /**
     * Returns the total duration for which the climatisation system will run, in seconds.
     *
     * @return An {@link Integer} representing the duration of the climatisation system in seconds.
     */
    public Integer getClimatisationDuration() {
        return climatisationDuration;
    }

    /**
     * Returns the remaining time for the climatisation system to run, in seconds.
     *
     * @return An {@link Integer} representing the remaining time for the climatisation system to run in seconds.
     */
    public Integer getRemainingClimateTime() {
        return remainingClimateTime;
    }

    /**
     * Returns the status code of the climatisation system.
     * <p>
     * The status code represents the current state of the climatisation system, such as error codes or success codes.
     * </p>
     *
     * @return An {@link Integer} representing the status code of the climatisation system.
     */
    public Integer getClimateStatusCode() {
        return climateStatusCode;
    }
}

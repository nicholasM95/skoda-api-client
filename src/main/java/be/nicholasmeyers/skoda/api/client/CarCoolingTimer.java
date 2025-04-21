package be.nicholasmeyers.skoda.api.client;

/**
 * Represents a cooling timer for a car, which includes settings for heater mode, scheduled time,
 * and timer programming status.
 * <p>
 * This class contains details about the scheduled cooling timer, such as the heater mode, whether
 * the timer is programmed, and the specific time (weekday, hour, and minute) for the timer to trigger.
 * </p>
 */
public class CarCoolingTimer {
    private final Integer id;
    private final String heaterMode;
    private final Boolean timerProgrammedStatus;
    private final Integer weekday;
    private final Integer hour;
    private final Integer minute;

    /**
     * Constructs a new {@link CarCoolingTimer} object with the specified parameters.
     *
     * @param id The unique identifier for the cooling timer.
     * @param heaterMode The heater mode (e.g., "ON" or "OFF") for the timer.
     * @param timerProgrammedStatus A {@link Boolean} indicating whether the timer is programmed (true) or not (false).
     * @param weekday The weekday when the timer is set, represented as an integer (e.g., 1 for Monday, 7 for Sunday).
     * @param hour The hour of the day when the timer is set to trigger (0-23).
     * @param minute The minute of the hour when the timer is set to trigger (0-59).
     */
    CarCoolingTimer(Integer id, String heaterMode, Boolean timerProgrammedStatus, Integer weekday, Integer hour, Integer minute) {
        this.id = id;
        this.heaterMode = heaterMode;
        this.timerProgrammedStatus = timerProgrammedStatus;
        this.weekday = weekday;
        this.hour = hour;
        this.minute = minute;
    }

    /**
     * Returns the unique identifier for the cooling timer.
     *
     * @return An {@link Integer} representing the id of the cooling timer.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Returns the heater mode for the timer (e.g., "ON", "OFF").
     *
     * @return A {@link String} representing the heater mode associated with the timer.
     */
    public String getHeaterMode() {
        return heaterMode;
    }

    /**
     * Returns the programmed status of the timer (true if the timer is programmed, false otherwise).
     *
     * @return A {@link Boolean} indicating whether the timer is programmed (true) or not (false).
     */
    public Boolean getTimerProgrammedStatus() {
        return timerProgrammedStatus;
    }

    /**
     * Returns the weekday when the timer is set, represented as an integer (e.g., 1 for Monday, 7 for Sunday).
     *
     * @return An {@link Integer} representing the weekday of the timer.
     */
    public Integer getWeekday() {
        return weekday;
    }

    /**
     * Returns the hour of the day when the timer is set to trigger.
     *
     * @return An {@link Integer} representing the hour (0-23) for the timer to trigger.
     */
    public Integer getHour() {
        return hour;
    }

    /**
     * Returns the minute of the hour when the timer is set to trigger.
     *
     * @return An {@link Integer} representing the minute (0-59) for the timer to trigger.
     */
    public Integer getMinute() {
        return minute;
    }
}

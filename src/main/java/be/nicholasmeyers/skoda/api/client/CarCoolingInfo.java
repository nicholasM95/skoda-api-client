package be.nicholasmeyers.skoda.api.client;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Represents the cooling information of a car, including various timestamps, outdoor temperature data,
 * climatisation settings, and associated reports and timers.
 * <p>
 * This class contains details about the car's climate control, including the start mode, heater mode,
 * outdoor temperature, and cooling timers. It also contains data related to the instrument cluster and
 * parking clock.
 * </p>
 */
public class CarCoolingInfo {

    private final LocalDateTime instrumentClusterTime;
    private final LocalDateTime carCapturedUTCTimestamp;
    private final LocalDateTime vehicleParkingClock;
    private final String outdoorTempValid;
    private final Integer outdoorTemp;
    private final LocalDateTime temperatureTime;
    private final Integer climatisationDuration;
    private final String startMode;
    private final String heaterMode;
    private final CarReport report;
    private final List<CarCoolingTimer> timers;

    /**
     * Constructs a new {@link CarCoolingInfo} object with the specified parameters.
     *
     * @param instrumentClusterTime The time displayed on the instrument cluster.
     * @param carCapturedUTCTimestamp The UTC timestamp when the car's data was captured.
     * @param vehicleParkingClock The time from the vehicle's parking clock.
     * @param outdoorTempValid A flag indicating whether the outdoor temperature is valid.
     * @param outdoorTemp The outdoor temperature in Celsius.
     * @param temperatureTime The time the temperature data was recorded.
     * @param climatisationDuration The duration of the vehicle's climatisation (in seconds).
     * @param startMode The start mode of the vehicle (e.g., manual, automatic).
     * @param heaterMode The heater mode (e.g., ON, OFF).
     * @param report A {@link CarReport} object containing any associated report data.
     * @param timers A list of {@link CarCoolingTimer} objects representing the timers associated with the cooling system.
     */
    CarCoolingInfo(String instrumentClusterTime, String carCapturedUTCTimestamp,
                   String vehicleParkingClock, String outdoorTempValid,
                   Integer outdoorTemp, String temperatureTime, Integer climatisationDuration, String startMode,
                   String heaterMode, CarReport report, List<CarCoolingTimer> timers) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        this.instrumentClusterTime = LocalDateTime.parse(instrumentClusterTime, formatter);
        this.carCapturedUTCTimestamp = LocalDateTime.parse(carCapturedUTCTimestamp, formatter);
        this.vehicleParkingClock = LocalDateTime.parse(vehicleParkingClock, formatter);
        this.outdoorTempValid = outdoorTempValid;
        this.outdoorTemp = outdoorTemp;
        this.temperatureTime = LocalDateTime.parse(temperatureTime, formatter);
        this.climatisationDuration = climatisationDuration;
        this.startMode = startMode;
        this.heaterMode = heaterMode;
        this.report = report;
        this.timers = timers;
    }

    /**
     * Returns the time displayed on the instrument cluster.
     *
     * @return A {@link LocalDateTime} representing the instrument cluster time.
     */
    public LocalDateTime getInstrumentClusterTime() {
        return instrumentClusterTime;
    }

    /**
     * Returns the UTC timestamp when the car's data was captured.
     *
     * @return A {@link LocalDateTime} representing the UTC timestamp of when the car's data was captured.
     */
    public LocalDateTime getCarCapturedUTCTimestamp() {
        return carCapturedUTCTimestamp;
    }

    /**
     * Returns the time from the vehicle's parking clock.
     *
     * @return A {@link LocalDateTime} representing the vehicle's parking clock time.
     */
    public LocalDateTime getVehicleParkingClock() {
        return vehicleParkingClock;
    }

    /**
     * Returns a flag indicating whether the outdoor temperature is valid.
     *
     * @return A {@link String} indicating whether the outdoor temperature is valid ("YES" or "NO").
     */
    public String getOutdoorTempValid() {
        return outdoorTempValid;
    }

    /**
     * Returns the outdoor temperature in Celsius.
     *
     * @return An {@link Integer} representing the outdoor temperature in Celsius.
     */
    public Integer getOutdoorTemp() {
        return outdoorTemp;
    }

    /**
     * Returns the time the temperature data was recorded.
     *
     * @return A {@link LocalDateTime} representing the time the temperature data was recorded.
     */
    public LocalDateTime getTemperatureTime() {
        return temperatureTime;
    }

    /**
     * Returns the duration of the vehicle's climatisation in seconds.
     *
     * @return An {@link Integer} representing the duration of the vehicle's climatisation in seconds.
     */
    public Integer getClimatisationDuration() {
        return climatisationDuration;
    }

    /**
     * Returns the start mode of the vehicle.
     *
     * @return A {@link String} representing the start mode of the vehicle (e.g., "manual", "automatic").
     */
    public String getStartMode() {
        return startMode;
    }

    /**
     * Returns the heater mode of the vehicle.
     *
     * @return A {@link String} representing the heater mode (e.g., "ON", "OFF").
     */
    public String getHeaterMode() {
        return heaterMode;
    }

    /**
     * Returns the {@link CarReport} associated with this cooling information.
     *
     * @return A {@link CarReport} object representing the associated report.
     */
    public CarReport getReport() {
        return report;
    }

    /**
     * Returns the list of {@link CarCoolingTimer} objects associated with the cooling system.
     *
     * @return A {@link List} of {@link CarCoolingTimer} objects representing the cooling system timers.
     */
    public List<CarCoolingTimer> getTimers() {
        return timers;
    }
}

package be.nicholasmeyers.skoda.api.client;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a field associated with a car, containing various time stamps,
 * mileage information, and additional details about the car.
 * <p>
 * This class provides access to the various attributes related to a car field
 * such as timestamps, mileage, and other related values.
 * </p>
 */
public class CarField {
    private final String id;
    private final LocalDateTime tsCarSentUtc;
    private final LocalDateTime tsCarSent;
    private final LocalDateTime tsCarCaptured;
    private final LocalDateTime tsTssReceivedUtc;
    private final Integer milCarCaptured;
    private final Integer milCarSent;
    private final String value;
    private final String unit;
    private final String textId;
    private final String picId;

    /**
     * Constructs a new CarField object with the given attributes.
     *
     * @param id               The unique identifier for this data field.
     * @param tsCarSentUtc     The UTC timestamp when the car data was sent.
     * @param tsCarSent        The timestamp when the car data was sent.
     * @param tsCarCaptured    The timestamp when the car data was captured.
     * @param tsTssReceivedUtc The UTC timestamp when TSS data was received.
     * @param milCarCaptured   The mileage at the time the car data was captured.
     * @param milCarSent       The mileage at the time the car data was sent.
     * @param value            The value associated with this field.
     * @param unit             The unit of the value (e.g., km, miles).
     * @param textId           A text identifier related to the car field.
     * @param picId            A picture identifier related to the car field.
     */
    CarField(String id, String tsCarSentUtc, String tsCarSent, String tsCarCaptured,
             String tsTssReceivedUtc, Integer milCarCaptured, Integer milCarSent, String value, String unit,
             String textId, String picId) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        this.id = id;
        this.tsCarSentUtc = LocalDateTime.parse(tsCarSentUtc, formatter);
        this.tsCarSent = LocalDateTime.parse(tsCarSent, formatter);
        this.tsCarCaptured = LocalDateTime.parse(tsCarCaptured, formatter);
        this.tsTssReceivedUtc = LocalDateTime.parse(tsTssReceivedUtc, formatter);
        this.milCarCaptured = milCarCaptured;
        this.milCarSent = milCarSent;
        this.value = value;
        this.unit = unit;
        this.textId = textId;
        this.picId = picId;
    }

    /**
     * Returns the unique identifier of the data field.
     *
     * @return A {@link String} representing the id of the car field.
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the UTC timestamp when the car data was sent.
     *
     * @return A {@link LocalDateTime} representing the UTC timestamp when the car data was sent.
     */
    public LocalDateTime getTsCarSentUtc() {
        return tsCarSentUtc;
    }

    /**
     * Returns the timestamp when the car data was sent.
     *
     * @return A {@link LocalDateTime} representing the timestamp when the car data was sent.
     */
    public LocalDateTime getTsCarSent() {
        return tsCarSent;
    }

    /**
     * Returns the timestamp when the car data was captured.
     *
     * @return A {@link LocalDateTime} representing the timestamp when the car data was captured.
     */
    public LocalDateTime getTsCarCaptured() {
        return tsCarCaptured;
    }

    /**
     * Returns the UTC timestamp when TSS data was received.
     *
     * @return A {@link LocalDateTime} representing the UTC timestamp when TSS data was received.
     */
    public LocalDateTime getTsTssReceivedUtc() {
        return tsTssReceivedUtc;
    }

    /**
     * Returns the mileage at the time the car data was captured.
     *
     * @return An {@link Integer} representing the mileage when the car data was captured.
     */
    public Integer getMilCarCaptured() {
        return milCarCaptured;
    }

    /**
     * Returns the mileage at the time the car data was sent.
     *
     * @return An {@link Integer} representing the mileage when the car data was sent.
     */
    public Integer getMilCarSent() {
        return milCarSent;
    }

    /**
     * Returns the value associated with this car field.
     *
     * @return A {@link String} representing the value associated with the car field.
     */
    public String getValue() {
        return value;
    }

    /**
     * Returns the unit of the value associated with this car field.
     *
     * @return A {@link String} representing the unit of the value (e.g., "km", "miles").
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Returns the text identifier associated with this car field.
     *
     * @return A {@link String} representing the text identifier.
     */
    public String getTextId() {
        return textId;
    }

    /**
     * Returns the picture identifier associated with this car field.
     *
     * @return A {@link String} representing the picture identifier.
     */
    public String getPicId() {
        return picId;
    }
}

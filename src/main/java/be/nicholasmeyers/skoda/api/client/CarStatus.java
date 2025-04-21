package be.nicholasmeyers.skoda.api.client;

import java.util.List;

/**
 * Represents the status of a car, including the Vehicle Identification Number (VIN) and associated car data.
 * <p>
 * This class holds information about the car's current status, including the VIN (Vehicle Identification Number)
 * and a list of data associated with the car, which can contain various fields such as kilometers left.
 * </p>
 */
public class CarStatus {
    private static final String KILOMETER_DATA_ID = "0x030103FFFF";
    private static final String KILOMETER_FIELD_ID = "0x0301030006";
    private final String vin;
    private final List<CarData> data;

    /**
     * Constructs a new {@link CarStatus} object with the specified VIN and car data.
     *
     * @param vin  The Vehicle Identification Number (VIN) of the car.
     * @param data A list of {@link CarData} objects containing various car data fields.
     */
    CarStatus(String vin, List<CarData> data) {
        this.vin = vin;
        this.data = data;
    }

    /**
     * Returns the list of {@link CarData} associated with this car status.
     *
     * @return A {@link List} of {@link CarData} objects representing various data fields of the car.
     */
    public List<CarData> getData() {
        return data;
    }

    /**
     * Returns the Vehicle Identification Number (VIN) of the car.
     *
     * @return A {@link String} representing the car's VIN.
     */
    public String getVin() {
        return vin;
    }

    /**
     * Returns the kilometer value from the car's data, parsed from the relevant car data fields.
     * <p>
     * This method filters the car data to find the data field with a specific id (representing kilometers left)
     * and retrieves the corresponding field value for the kilometers left.
     * </p>
     *
     * @return An {@link Integer} representing the kilometers left by the car.
     */
    public Integer getKilometer() {
        CarData data = getData().stream()
                .filter(d -> KILOMETER_DATA_ID.equals(d.getId()))
                .toList()
                .getFirst();

        CarField field = data.getFields().stream()
                .filter(f -> KILOMETER_FIELD_ID.equals(f.getId()))
                .toList()
                .getFirst();

        return Integer.parseInt(field.getValue());
    }
}

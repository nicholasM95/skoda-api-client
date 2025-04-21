package be.nicholasmeyers.skoda.api.client;

import java.util.List;

/**
 * Represents data associated with a car, including an id and a list of car data fields.
 * <p>
 * This class provides access to the car's data id and its associated fields.
 * </p>
 */
public class CarData {
    private final String id;
    private final List<CarField> fields;

    /**
     * Constructs a new CarData object with the given data id and list of car data fields.
     *
     * @param id     The unique identifier of the data.
     * @param fields A list of {@link CarField} objects that represent various data fields of the car.
     */
    CarData(String id, List<CarField> fields) {
        this.id = id;
        this.fields = fields;
    }

    /**
     * Returns the unique identifier of the data fields.
     *
     * @return A {@link String} representing the data id.
     */
    public String getId() {
        return id;
    }

    /**
     * Returns a list of car data fields associated with this car.
     *
     * @return A {@link List} of {@link CarField} objects.
     */
    public List<CarField> getFields() {
        return fields;
    }
}

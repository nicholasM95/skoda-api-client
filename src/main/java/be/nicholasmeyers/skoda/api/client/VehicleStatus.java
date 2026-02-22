package be.nicholasmeyers.skoda.api.client;

/**
 * Represents the current status of a Škoda vehicle, including the state of doors,
 * windows, lights, locks, and other physical components.
 * <p>
 * Instances of this class are created internally by the {@link VehicleService}
 * and are not intended to be constructed directly.
 * </p>
 */
public class VehicleStatus {

    private final String doorsLocked;
    private final String locked;
    private final String doors;
    private final String windows;
    private final String lights;
    private final String reliableLockStatus;
    private final String sunroof;
    private final String trunk;
    private final String bonnet;
    private final String carCapturedTimestamp;

    /**
     * Constructs a new {@code VehicleStatus} with the given status details.
     *
     * @param doorsLocked          the locked state of the doors (e.g. {@code "YES"} or {@code "NO"}).
     * @param locked               the overall lock state of the vehicle (e.g. {@code "YES"} or {@code "NO"}).
     * @param doors                the current state of the doors (e.g. {@code "CLOSED"} or {@code "OPEN"}).
     * @param windows              the current state of the windows (e.g. {@code "CLOSED"} or {@code "OPEN"}).
     * @param lights               the current state of the lights (e.g. {@code "OFF"} or {@code "ON"}).
     * @param reliableLockStatus   the reliable lock status, indicating whether the lock state can be trusted.
     * @param sunroof              the current state of the sunroof (e.g. {@code "CLOSED"} or {@code "OPEN"}).
     * @param trunk                the current state of the trunk (e.g. {@code "CLOSED"} or {@code "OPEN"}).
     * @param bonnet               the current state of the bonnet (e.g. {@code "CLOSED"} or {@code "OPEN"}).
     * @param carCapturedTimestamp the timestamp at which this status was last captured by the vehicle.
     */
    VehicleStatus(String doorsLocked, String locked, String doors, String windows, String lights, String reliableLockStatus, String sunroof, String trunk, String bonnet, String carCapturedTimestamp) {
        this.doorsLocked = doorsLocked;
        this.locked = locked;
        this.doors = doors;
        this.windows = windows;
        this.lights = lights;
        this.reliableLockStatus = reliableLockStatus;
        this.sunroof = sunroof;
        this.trunk = trunk;
        this.bonnet = bonnet;
        this.carCapturedTimestamp = carCapturedTimestamp;
    }

    /**
     * Returns the locked state of the doors.
     *
     * @return the doors locked state (e.g. {@code "YES"} or {@code "NO"}).
     */
    public String getDoorsLocked() {
        return doorsLocked;
    }

    /**
     * Returns the overall lock state of the vehicle.
     *
     * @return the lock state (e.g. {@code "YES"} or {@code "NO"}).
     */
    public String getLocked() {
        return locked;
    }

    /**
     * Returns the current state of the doors.
     *
     * @return the doors state (e.g. {@code "CLOSED"} or {@code "OPEN"}).
     */
    public String getDoors() {
        return doors;
    }

    /**
     * Returns the current state of the windows.
     *
     * @return the windows state (e.g. {@code "CLOSED"} or {@code "OPEN"}).
     */
    public String getWindows() {
        return windows;
    }

    /**
     * Returns the current state of the lights.
     *
     * @return the lights state (e.g. {@code "OFF"} or {@code "ON"}).
     */
    public String getLights() {
        return lights;
    }

    /**
     * Returns the reliable lock status, indicating whether the lock state can be trusted.
     *
     * @return the reliable lock status.
     */
    public String getReliableLockStatus() {
        return reliableLockStatus;
    }

    /**
     * Returns the current state of the sunroof.
     *
     * @return the sunroof state (e.g. {@code "CLOSED"} or {@code "OPEN"}).
     */
    public String getSunroof() {
        return sunroof;
    }

    /**
     * Returns the current state of the trunk.
     *
     * @return the trunk state (e.g. {@code "CLOSED"} or {@code "OPEN"}).
     */
    public String getTrunk() {
        return trunk;
    }

    /**
     * Returns the current state of the bonnet.
     *
     * @return the bonnet state (e.g. {@code "CLOSED"} or {@code "OPEN"}).
     */
    public String getBonnet() {
        return bonnet;
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
package be.nicholasmeyers.skoda.api.client;

import be.nicholasmeyers.skoda.ApiException;
import be.nicholasmeyers.skoda.client.AirConditioningApi;
import be.nicholasmeyers.skoda.client.LocationApi;
import be.nicholasmeyers.skoda.client.RangeApi;
import be.nicholasmeyers.skoda.client.StatusApi;
import be.nicholasmeyers.skoda.client.VehicleApi;
import be.nicholasmeyers.skoda.client.resource.AirConditioningWebRequestResource;
import be.nicholasmeyers.skoda.client.resource.AirConditioningWebResponseResource;
import be.nicholasmeyers.skoda.client.resource.LocationWebResponseResource;
import be.nicholasmeyers.skoda.client.resource.RangeWebResponseResource;
import be.nicholasmeyers.skoda.client.resource.StatusWebResponseResource;
import be.nicholasmeyers.skoda.client.resource.VehicleWebResponseResource;

import java.util.List;

/**
 * Service for interacting with Škoda vehicles via the unofficial Škoda API.
 * <p>
 * Provides methods to retrieve vehicle information such as location, status, range,
 * and air conditioning state, as well as control features like starting and stopping
 * air conditioning.
 * </p>
 * <p>
 * Authentication is handled internally using the provided email and password credentials.
 * All methods throw a {@link VehicleServiceException} if the underlying API call fails.
 * </p>
 */
public class VehicleService {

    private final VehicleApi vehicleApi;
    private final LocationApi locationApi;
    private final StatusApi statusApi;
    private final RangeApi rangeApi;
    private final AirConditioningApi airConditioningApi;

    /**
     * Constructs a new {@code VehicleService} using the default server configuration.
     *
     * @param email    the email address used for authentication.
     * @param password the password used for authentication.
     */
    public VehicleService(String email, String password) {
        ClientConfiguration clientConfiguration = new ClientConfiguration(email, password);
        this.vehicleApi = new VehicleApi(clientConfiguration.getApiClient());
        this.locationApi = new LocationApi(clientConfiguration.getApiClient());
        this.statusApi = new StatusApi(clientConfiguration.getApiClient());
        this.rangeApi = new RangeApi(clientConfiguration.getApiClient());
        this.airConditioningApi = new AirConditioningApi(clientConfiguration.getApiClient());
    }

    /**
     * Constructs a new {@code VehicleService} using a custom server URL.
     * <p>
     * Use this constructor if you want to point the client to a non-default API server,
     * for example, a local mock or a staging environment.
     * </p>
     *
     * @param email    the email address used for authentication.
     * @param password the password used for authentication.
     * @param server   the base URL of the API server to use.
     */
    public VehicleService(String email, String password, String server) {
        ClientConfiguration clientConfiguration = new ClientConfiguration(email, password, server);
        this.vehicleApi = new VehicleApi(clientConfiguration.getApiClient());
        this.locationApi = new LocationApi(clientConfiguration.getApiClient());
        this.statusApi = new StatusApi(clientConfiguration.getApiClient());
        this.rangeApi = new RangeApi(clientConfiguration.getApiClient());
        this.airConditioningApi = new AirConditioningApi(clientConfiguration.getApiClient());
    }

    /**
     * Retrieves all vehicles associated with the authenticated account.
     *
     * @return a list of {@link Vehicle} objects representing the user's vehicles.
     * @throws VehicleServiceException if the API call fails.
     */
    public List<Vehicle> getVehicles() {
        try {
            List<VehicleWebResponseResource> vehicleWebResponseResources = vehicleApi.findAllVehicles();
            return vehicleWebResponseResources.stream()
                    .map(this::mapToVehicle)
                    .toList();
        } catch (ApiException e) {
            throw new VehicleServiceException("Failed to retrieve vehicles", e.getMessage());
        }
    }

    /**
     * Retrieves the current location of a vehicle.
     *
     * @param vin the Vehicle Identification Number of the vehicle.
     * @return a {@link VehicleLocation} containing the latitude, longitude, and address of the vehicle.
     * @throws VehicleServiceException if the API call fails.
     */
    public VehicleLocation getVehicleLocation(String vin) {
        try {
            LocationWebResponseResource location = locationApi.getLocation(vin);
            return new VehicleLocation(location.getLatitude(), location.getLongitude(), location.getAddress());
        } catch (ApiException e) {
            throw new VehicleServiceException("Failed to get vehicle location", e.getMessage());
        }
    }

    /**
     * Retrieves the current status of a vehicle, including door, window, and lock states.
     *
     * @param vin the Vehicle Identification Number of the vehicle.
     * @return a {@link VehicleStatus} containing detailed status information about the vehicle.
     * @throws VehicleServiceException if the API call fails.
     */
    public VehicleStatus getVehicleStatus(String vin) {
        try {
            StatusWebResponseResource status = statusApi.getStatus(vin);
            return new VehicleStatus(status.getDoorsLocked(), status.getLocked(), status.getDoors(), status.getWindows(),
                    status.getLights(), status.getReliableLockStatus(), status.getSunroof(), status.getTrunk(),
                    status.getBonnet(), status.getCarCapturedTimestamp());
        } catch (ApiException e) {
            throw new VehicleServiceException("Failed to get vehicle status", e.getMessage());
        }
    }

    /**
     * Retrieves the current range and battery information of a vehicle.
     *
     * @param vin the Vehicle Identification Number of the vehicle.
     * @return a {@link VehicleRange} containing the car type, total range, engine type,
     *         current state of charge, remaining range, and the timestamp of the last update.
     * @throws VehicleServiceException if the API call fails.
     */
    public VehicleRange getVehicleRange(String vin) {
        try {
            RangeWebResponseResource range = rangeApi.getRange(vin);
            return new VehicleRange(range.getCarType(), range.getTotalRangeInKm(), range.getEngineType(),
                    range.getCurrentSoCInPercent(), range.getRemainingRangeInKm(), range.getCarCapturedTimestamp());
        } catch (ApiException e) {
            throw new VehicleServiceException("Failed to get vehicle range", e.getMessage());
        }
    }

    /**
     * Retrieves the current air conditioning status of a vehicle.
     *
     * @param vin the Vehicle Identification Number of the vehicle.
     * @return a {@link VehicleAirConditioningStatus} containing the state, temperature,
     *         temperature unit, and the timestamp of the last update.
     * @throws VehicleServiceException if the API call fails.
     */
    public VehicleAirConditioningStatus getVehicleAirConditioning(String vin) {
        try {
            AirConditioningWebResponseResource airConditioning = airConditioningApi.getAirConditioning(vin);
            return new VehicleAirConditioningStatus(airConditioning.getState(), airConditioning.getTemperature(),
                    airConditioning.getTemperatureUnit(), airConditioning.getCarCapturedTimestamp());
        } catch (ApiException e) {
            throw new VehicleServiceException("Failed to get vehicle air conditioning", e.getMessage());
        }
    }

    /**
     * Starts the air conditioning of a vehicle with the specified settings.
     *
     * @param vin             the Vehicle Identification Number of the vehicle.
     * @param heaterSource    the heat source to use (e.g., electric).
     * @param temperature     the desired target temperature.
     * @param temperatureUnit the unit of the target temperature (e.g., Celsius).
     * @throws VehicleServiceException if the API call fails.
     */
    public void startVehicleAirConditioning(String vin, VehicleHeaterSource heaterSource, double temperature, VehicleTemperatureUnit temperatureUnit) {
        AirConditioningWebRequestResource requestResource = new AirConditioningWebRequestResource();
        requestResource.setHeaterSource(heaterSource.toString());
        requestResource.setTemperature(temperature);
        requestResource.setTemperatureUnit(temperatureUnit.toString());

        try {
            airConditioningApi.startAirConditioning(vin, requestResource);
        } catch (ApiException e) {
            throw new VehicleServiceException("Failed to start vehicle air conditioning", e.getMessage());
        }
    }

    /**
     * Stops the air conditioning of a vehicle.
     *
     * @param vin the Vehicle Identification Number of the vehicle.
     * @throws VehicleServiceException if the API call fails.
     */
    public void stopVehicleAirConditioning(String vin) {
        try {
            airConditioningApi.stopAirConditioning(vin);
        } catch (ApiException e) {
            throw new VehicleServiceException("Failed to stop vehicle air conditioning", e.getMessage());
        }
    }

    /**
     * Maps a {@link VehicleWebResponseResource} to a {@link Vehicle} domain object.
     *
     * @param vehicleWebResponseResource the API response resource to map.
     * @return a {@link Vehicle} containing the VIN, name, title, and license plate.
     */
    private Vehicle mapToVehicle(VehicleWebResponseResource vehicleWebResponseResource) {
        return new Vehicle(vehicleWebResponseResource.getVin(),
                vehicleWebResponseResource.getName(),
                vehicleWebResponseResource.getTitle(),
                vehicleWebResponseResource.getLicensePlate());
    }
}
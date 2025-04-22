package be.nicholasmeyers.skoda.api.client;

import be.nicholasmeyers.skoda.ApiException;
import be.nicholasmeyers.skoda.client.CoolingApi;
import be.nicholasmeyers.skoda.client.FlashApi;
import be.nicholasmeyers.skoda.client.HonkApi;
import be.nicholasmeyers.skoda.client.LocationApi;
import be.nicholasmeyers.skoda.client.RequestApi;
import be.nicholasmeyers.skoda.client.StatusApi;
import be.nicholasmeyers.skoda.client.VentilatorApi;
import be.nicholasmeyers.skoda.client.resource.CoolingWebResponseResource;
import be.nicholasmeyers.skoda.client.resource.DataWebResponseResource;
import be.nicholasmeyers.skoda.client.resource.FieldWebResponseResource;
import be.nicholasmeyers.skoda.client.resource.FlashWebRequestResource;
import be.nicholasmeyers.skoda.client.resource.HonkWebRequestResource;
import be.nicholasmeyers.skoda.client.resource.LocationWebResponseResource;
import be.nicholasmeyers.skoda.client.resource.ReportWebResponseResource;
import be.nicholasmeyers.skoda.client.resource.RequestWebResponseResource;
import be.nicholasmeyers.skoda.client.resource.StatusWebResponseResource;
import be.nicholasmeyers.skoda.client.resource.TimerWebResponseResource;
import be.nicholasmeyers.skoda.client.resource.VentilatorWebRequestResource;
import be.nicholasmeyers.skoda.client.resource.VentilatorWebResponseResource;

/**
 * Provides services to interact with a car, including controlling features such as cooling, flashing, honking,
 * ventilator management, and retrieving car status and location information.
 * <p>
 * This service allows clients to perform actions on a car by utilizing various APIs like cooling, flash, honk,
 * location, and ventilator management. Each method includes error handling and performs relevant actions on the car.
 * </p>
 */
public class CarService {

    private final CoolingApi coolingApi;
    private final FlashApi flashApi;
    private final HonkApi honkApi;
    private final LocationApi locationApi;
    private final RequestApi requestApi;
    private final StatusApi statusApi;
    private final VentilatorApi ventilatorApi;

    /**
     * Constructs a new CarService with the specified email and password for authentication.
     *
     * @param email    The email used for authentication.
     * @param password The password used for authentication.
     */
    public CarService(String email, String password) {
        ClientConfiguration clientConfiguration = new ClientConfiguration(email, password);
        this.coolingApi = new CoolingApi(clientConfiguration.getApiClient());
        this.flashApi = new FlashApi(clientConfiguration.getApiClient());
        this.honkApi = new HonkApi(clientConfiguration.getApiClient());
        this.locationApi = new LocationApi(clientConfiguration.getApiClient());
        this.requestApi = new RequestApi(clientConfiguration.getApiClient());
        this.statusApi = new StatusApi(clientConfiguration.getApiClient());
        this.ventilatorApi = new VentilatorApi(clientConfiguration.getApiClient());
    }

    /**
     * Retrieves the cooling status for the car identified by the provided VIN (Vehicle Identification Number).
     *
     * @param vin The VIN of the car.
     * @return A {@link CarCoolingInfo} object containing the cooling information of the car.
     * @throws CarServiceException If an error occurs while retrieving the cooling status.
     */
    public CarCoolingInfo getCooling(String vin) {
        try {
            CoolingWebResponseResource cooling = coolingApi.getCoolingStatus(vin);
            return new CarCoolingInfo(cooling.getInstrumentClusterTime(), cooling.getCarCapturedUTCTimestamp(),
                    cooling.getVehicleParkingClock(), cooling.getOutdoorTempValid(), cooling.getOutdoorTemp(), cooling.getTemperatureTime(),
                    cooling.getClimatisationDuration(), cooling.getStartMode(), cooling.getHeaterMode(), mapToCarReport(cooling.getReport()),
                    cooling.getTimers().stream().map(this::mapToCarCoolingTimer).toList());
        } catch (ApiException e) {
            throw new CarServiceException("Failed to get cooling information", e.getMessage());
        }
    }

    /**
     * Flashes the car's lights for the specified duration (up to 30 seconds).
     *
     * @param vin      The VIN of the car.
     * @param duration The duration to flash the lights (in seconds).
     * @return The status of the request.
     * @throws CarServiceException If the duration exceeds the maximum allowed or if an error occurs.
     */
    public String flash(String vin, Integer duration) {
        if (duration > 30) {
            throw new CarServiceException("Failed to flash lights", "duration limit exceeded, max 30 minutes");
        }
        CarLocation location = getLocation(vin);
        FlashWebRequestResource flashWebRequestResource = new FlashWebRequestResource();
        flashWebRequestResource.setDuration(duration);
        flashWebRequestResource.setLatitude(location.getLatitude());
        flashWebRequestResource.setLongitude(location.getLongitude());

        try {
            return flashApi.flash(vin, flashWebRequestResource).getStatus();
        } catch (ApiException e) {
            throw new CarServiceException("Failed to flash lights", e.getMessage());
        }
    }

    /**
     * Honks the car's horn for the specified duration (up to 30 seconds).
     *
     * @param vin      The VIN of the car.
     * @param duration The duration to honk the horn (in seconds).
     * @return The status of the request.
     * @throws CarServiceException If the duration exceeds the maximum allowed or if an error occurs.
     */
    public String honk(String vin, Integer duration) {
        if (duration > 30) {
            throw new CarServiceException("Failed to honk horn", "duration limit exceeded, max 30 minutes");
        }
        CarLocation location = getLocation(vin);
        HonkWebRequestResource honkWebRequestResource = new HonkWebRequestResource();
        honkWebRequestResource.setDuration(duration);
        honkWebRequestResource.setLatitude(location.getLatitude());
        honkWebRequestResource.setLongitude(location.getLongitude());

        try {
            return honkApi.honk(vin, honkWebRequestResource).getStatus();
        } catch (ApiException e) {
            throw new CarServiceException("Failed to honk horn", e.getMessage());
        }
    }

    /**
     * Retrieves the status of a specific request for the car identified by the VIN.
     *
     * @param vin The VIN of the car.
     * @param id  The id of the request.
     * @return The status of the request.
     * @throws CarServiceException If an error occurs while retrieving the request status.
     */
    public String getRequest(String vin, String id) {
        try {
            RequestWebResponseResource request = requestApi.getRequest(vin, id);
            return request.getStatus();
        } catch (ApiException e) {
            throw new CarServiceException("Failed to get request", e.getMessage());
        }
    }

    /**
     * Retrieves the status of the car identified by the provided VIN.
     *
     * @param vin The VIN of the car.
     * @return A {@link CarStatus} object containing the status information of the car.
     * @throws CarServiceException If an error occurs while retrieving the car status.
     */
    public CarStatus getStatus(String vin) {
        try {
            StatusWebResponseResource status = statusApi.getStatus(vin);
            return new CarStatus(status.getVin(), status.getData().stream().map(this::mapToCarData).toList());
        } catch (ApiException e) {
            throw new CarServiceException("Failed to get status", e.getMessage());
        }
    }

    /**
     * Starts the car's ventilator for the specified duration (up to 30 seconds).
     *
     * @param vin      The VIN of the car.
     * @param pin      The pin used to authenticate the ventilator action.
     * @param duration The duration to run the ventilator (in seconds).
     * @return The ventilator status ID.
     * @throws CarServiceException If the duration exceeds the maximum allowed or if an error occurs.
     */
    public String startVentilator(String vin, String pin, Integer duration) {
        if (duration > 30) {
            throw new CarServiceException("Failed to start ventilator", "duration limit exceeded, max 30 minutes");
        }

        VentilatorWebRequestResource ventilatorWebRequestResource = new VentilatorWebRequestResource();
        ventilatorWebRequestResource.setPin(pin);
        ventilatorWebRequestResource.setDuration(duration);

        try {
            VentilatorWebResponseResource ventilatorStatus = ventilatorApi.startVentilator(vin, ventilatorWebRequestResource);
            return ventilatorStatus.getId();
        } catch (ApiException e) {
            throw new CarServiceException("Failed to start ventilator",  e.getMessage());
        }
    }

    /**
     * Stops the car's ventilator.
     *
     * @param vin The VIN of the car.
     * @param pin The pin used to authenticate the ventilator action.
     * @return The ventilator status ID.
     * @throws CarServiceException If an error occurs while stopping the ventilator.
     */
    public String stopVentilator(String vin, String pin) {
        VentilatorWebRequestResource ventilatorWebRequestResource = new VentilatorWebRequestResource();
        ventilatorWebRequestResource.setPin(pin);
        ventilatorWebRequestResource.setDuration(0);

        try {
            VentilatorWebResponseResource ventilatorStatus = ventilatorApi.stopVentilator(vin, ventilatorWebRequestResource);
            return ventilatorStatus.getId();
        } catch (ApiException e) {
            throw new CarServiceException("Failed to stop ventilator",  e.getMessage());
        }
    }

    /**
     * Retrieves the location of the car identified by the provided VIN.
     *
     * @param vin The VIN of the car.
     * @return A {@link CarLocation} object representing the car's location.
     * @throws CarServiceException If an error occurs while retrieving the car location.
     */
    public CarLocation getLocation(String vin) {
        try {
            LocationWebResponseResource location = locationApi.getLocation(vin);
            return new CarLocation(location.getLatitude(), location.getLongitude());
        } catch (ApiException e) {
            throw new CarServiceException("Failed to get car location",  e.getMessage());
        }
    }

    /**
     * Maps a {@link DataWebResponseResource} to a {@link CarData} object.
     *
     * @param data The data response resource to be mapped.
     * @return A {@link CarData} object.
     */
    private CarData mapToCarData(DataWebResponseResource data) {
        return new CarData(data.getId(), data.getFields().stream().map(this::mapToCarField).toList());
    }

    /**
     * Maps a {@link FieldWebResponseResource} to a {@link CarField} object.
     *
     * @param field The field response resource to be mapped.
     * @return A {@link CarField} object.
     */
    private CarField mapToCarField(FieldWebResponseResource field) {
        return new CarField(field.getId(), field.getTsCarSentUtc(), field.getTsCarSent(), field.getTsCarCaptured(), field.getTsTssReceivedUtc(),
                field.getMilCarCaptured(), field.getMilCarSent(), field.getValue(), field.getUnit(), field.getTextId(), field.getPicId());
    }

    /**
     * Maps a {@link ReportWebResponseResource} object to a {@link CarReport} object.
     *
     * @param report The {@link ReportWebResponseResource} object containing the report data to be mapped.
     * @return A {@link CarReport} object representing the mapped report data.
     */
    private CarReport mapToCarReport(ReportWebResponseResource report) {
        return new CarReport(report.getClimatisationState(), report.getClimatisationDuration(), report.getRemainingClimateTime(),
                report.getClimateStatusCode());
    }

    /**
     * Maps a {@link TimerWebResponseResource} object to a {@link CarCoolingTimer} object.
     *
     * @param timer The {@link TimerWebResponseResource} object containing the timer data to be mapped.
     * @return A {@link CarCoolingTimer} object representing the mapped timer data.
     */
    private CarCoolingTimer mapToCarCoolingTimer(TimerWebResponseResource timer) {
        return new CarCoolingTimer(timer.getId(), timer.getHeaterMode(), timer.getTimerProgrammedStatus(),
                timer.getWeekday(), timer.getHour(), timer.getMinute());
    }
}

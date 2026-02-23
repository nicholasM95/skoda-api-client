# Škoda API Client
This project offers a streamlined and reliable way to interact with Škoda vehicles through the Volkswagen Group's connected services.
It simplifies authentication and token management, enabling developers to easily access vehicle data and remotely control features such as air conditioning and charging.
Whether you're building apps, tools, or custom integrations, this client is your starting point for working with Škoda's digital ecosystem.

> **Disclaimer:** This client is `unofficial` and not affiliated with or endorsed by Škoda Auto or the Volkswagen Group.
> It is independently developed to support developers in integrating with Škoda's online services.

## Adding Maven Repository and Dependency
To utilize the library in your Maven project, add the following dependency to your `pom.xml`:
```xml
<dependency>
    <groupId>be.nicholasmeyers</groupId>
    <artifactId>skoda-api-client</artifactId>
    <version>2.1.0</version>
</dependency>
```

## Get All Vehicles
Use the `VehicleService` to retrieve all vehicles associated with your account.
Make sure to replace `YOUR_EMAIL` and `YOUR_PASSWORD` with your actual account credentials.
```java
VehicleService vehicleService = new VehicleService("YOUR_EMAIL", "YOUR_PASSWORD");
List<Vehicle> vehicles = vehicleService.getVehicles();
```

## Get Vehicle Location
Use the `VehicleService` to retrieve your Škoda vehicle's current location.
Make sure to replace `YOUR_CARS_VIN`, `YOUR_EMAIL`, and `YOUR_PASSWORD` with your actual vehicle VIN and account credentials.
```java
VehicleService vehicleService = new VehicleService("YOUR_EMAIL", "YOUR_PASSWORD");
VehicleLocation location = vehicleService.getVehicleLocation("YOUR_CARS_VIN");
```

## Get Vehicle Status
Use the `VehicleService` to retrieve the current status of your Škoda vehicle.
This includes information such as door and window state, lock status, lights, sunroof, trunk, and bonnet.
Make sure to replace `YOUR_CARS_VIN`, `YOUR_EMAIL`, and `YOUR_PASSWORD` with your actual vehicle VIN and account credentials.
```java
VehicleService vehicleService = new VehicleService("YOUR_EMAIL", "YOUR_PASSWORD");
VehicleStatus status = vehicleService.getVehicleStatus("YOUR_CARS_VIN");
```

## Get Vehicle Range
Use the `VehicleService` to retrieve the current range and battery information of your Škoda vehicle.
This includes the total range, remaining range, current state of charge, car type, and engine type.
Make sure to replace `YOUR_CARS_VIN`, `YOUR_EMAIL`, and `YOUR_PASSWORD` with your actual vehicle VIN and account credentials.
```java
VehicleService vehicleService = new VehicleService("YOUR_EMAIL", "YOUR_PASSWORD");
VehicleRange range = vehicleService.getVehicleRange("YOUR_CARS_VIN");
```

## Get Vehicle Air Conditioning Status
Use the `VehicleService` to retrieve the current air conditioning status of your Škoda vehicle.
Make sure to replace `YOUR_CARS_VIN`, `YOUR_EMAIL`, and `YOUR_PASSWORD` with your actual vehicle VIN and account credentials.
```java
VehicleService vehicleService = new VehicleService("YOUR_EMAIL", "YOUR_PASSWORD");
VehicleAirConditioningStatus acStatus = vehicleService.getVehicleAirConditioning("YOUR_CARS_VIN");
```

## Start Vehicle Air Conditioning
Use the `VehicleService` to start the air conditioning of your Škoda vehicle with a desired temperature and heater source.
Make sure to replace `YOUR_CARS_VIN`, `YOUR_EMAIL`, and `YOUR_PASSWORD` with your actual vehicle VIN and account credentials.
```java
VehicleService vehicleService = new VehicleService("YOUR_EMAIL", "YOUR_PASSWORD");
vehicleService.startVehicleAirConditioning("YOUR_CARS_VIN", VehicleHeaterSource.ELECTRIC, 21.0, VehicleTemperatureUnit.CELSIUS);
```

## Stop Vehicle Air Conditioning
Use the `VehicleService` to stop the air conditioning of your Škoda vehicle.
Make sure to replace `YOUR_CARS_VIN`, `YOUR_EMAIL`, and `YOUR_PASSWORD` with your actual vehicle VIN and account credentials.
```java
VehicleService vehicleService = new VehicleService("YOUR_EMAIL", "YOUR_PASSWORD");
vehicleService.stopVehicleAirConditioning("YOUR_CARS_VIN");
```

## Get Vehicle Charging State
Use the `VehicleService` to retrieve the current charging state of your Škoda vehicle.
This includes the charging rate, charge power, remaining time to fully charged, charging state, charge type, remaining cruising range, and the current state of charge.
Make sure to replace `YOUR_CARS_VIN`, `YOUR_EMAIL`, and `YOUR_PASSWORD` with your actual vehicle VIN and account credentials.
```java
VehicleService vehicleService = new VehicleService("YOUR_EMAIL", "YOUR_PASSWORD");
VehicleChargingState chargingState = vehicleService.getVehicleChargingState("YOUR_CARS_VIN");
```

## Get Vehicle Charging Sessions
Use the `VehicleService` to retrieve the charging session history of your Škoda vehicle.
Each session includes the start time, energy charged in kWh, duration in minutes, and the type of current used.
Make sure to replace `YOUR_CARS_VIN`, `YOUR_EMAIL`, and `YOUR_PASSWORD` with your actual vehicle VIN and account credentials.
```java
VehicleService vehicleService = new VehicleService("YOUR_EMAIL", "YOUR_PASSWORD");
List<VehicleChargingSession> sessions = vehicleService.getVehicleChargingSessions("YOUR_CARS_VIN");
```

## Start Charging
Use the `VehicleService` to start charging your Škoda vehicle.
Make sure to replace `YOUR_CARS_VIN`, `YOUR_EMAIL`, and `YOUR_PASSWORD` with your actual vehicle VIN and account credentials.
```java
VehicleService vehicleService = new VehicleService("YOUR_EMAIL", "YOUR_PASSWORD");
vehicleService.startCharging("YOUR_CARS_VIN");
```

## Stop Charging
Use the `VehicleService` to stop the active charging session of your Škoda vehicle.
Make sure to replace `YOUR_CARS_VIN`, `YOUR_EMAIL`, and `YOUR_PASSWORD` with your actual vehicle VIN and account credentials.
```java
VehicleService vehicleService = new VehicleService("YOUR_EMAIL", "YOUR_PASSWORD");
vehicleService.stopCharging("YOUR_CARS_VIN");
```

## Use Your Own Server
Use the `VehicleService` with a custom server URL, for example to point to a local mock or staging environment.
Make sure to replace `YOUR_EMAIL`, `YOUR_PASSWORD`, and `YOUR_SERVER` with your actual account credentials and server URL.
```java
VehicleService vehicleService = new VehicleService("YOUR_EMAIL", "YOUR_PASSWORD", "YOUR_SERVER");
```
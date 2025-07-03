# Škoda API Client
This project offers a streamlined and reliable way to interact with Škoda vehicles through the Volkswagen Group's connected services. 
It simplifies authentication and token management, enabling developers to easily access vehicle data and remotely trigger actions such as flashing lights, 
honking the horn, or activating ventilation. 
Whether you're building apps, tools, or custom integrations, this client is your starting point for working with Škoda's digital ecosystem.

Disclaimer: This client is `unofficial` and not affiliated with or endorsed by Škoda Auto or the Volkswagen Group.
It is independently developed to support developers in integrating with Škoda's online services.

## Adding Maven Repository and Dependency
To utilize the library in your Maven project, follow these steps.

Add the Maven Dependency to your `pom.xml`

```
<dependency>
    <groupId>be.nicholasmeyers</groupId>
    <artifactId>skoda-api-client</artifactId>
    <version>1.3.1</version>
</dependency>
```

## Get Car Location
Use the `CarService` to retrieve your Škoda vehicle's current location.
Make sure to replace `YOUR_CARS_VIN`, `YOUR_EMAIL`, and `YOUR_PASSWORD` with your actual vehicle VIN and account credentials.

```
String vin = "YOUR_CARS_VIN";
CarService carService = new CarService("YOUR_EMAIL", "YOUR_PASSWORD");
CarLocation location = carService.getLocation(vin);
```

## Get Car Cooling information
Use the `CarService` to retrieve your Škoda vehicle's current cooling information.
Make sure to replace `YOUR_CARS_VIN`, `YOUR_EMAIL`, and `YOUR_PASSWORD` with your actual vehicle VIN and account credentials.

```
String vin = "YOUR_CARS_VIN";
CarService carService = new CarService("YOUR_EMAIL", "YOUR_PASSWORD");
CarCoolingInfo coolingInfo = carService.getCooling(vin);
```

## Flash Car Lights
Use the `CarService` to retrieve your Škoda vehicle's flash the car lights.
Make sure to replace `YOUR_CARS_VIN`, `YOUR_EMAIL`, and `YOUR_PASSWORD` with your actual vehicle VIN and account credentials.

```
String vin = "YOUR_CARS_VIN";
CarService carService = new CarService("YOUR_EMAIL", "YOUR_PASSWORD");
String status = carService.flash(vin, 30);
```

## Honk Car Horn
Use the `CarService` to retrieve your Škoda vehicle's honk the car horn.
Make sure to replace `YOUR_CARS_VIN`, `YOUR_EMAIL`, and `YOUR_PASSWORD` with your actual vehicle VIN and account credentials.

```
String vin = "YOUR_CARS_VIN";
CarService carService = new CarService("YOUR_EMAIL", "YOUR_PASSWORD");
String status = carService.honk(vin, 30);
```

## Start Car Ventilator
Use the `CarService` to start your Škoda vehicle's ventilator.
Make sure to replace `YOUR_CARS_VIN`, `YOUR_EMAIL` `YOUR_PASSWORD`, `YOUR_PIN` and `DURATION_IN_MINUTES` with your actual vehicle VIN, account credentials and duration in minutes.

```
String vin = "YOUR_CARS_VIN";
CarService carService = new CarService("YOUR_EMAIL", "YOUR_PASSWORD");
String id = carService.startVentilator(vin, "YOUR_PIN", DURATION_IN_MINUTES);
```

## Stop Car Ventilator
Use the `CarService` to stop your Škoda vehicle's ventilator.
Make sure to replace `YOUR_CARS_VIN`, `YOUR_EMAIL` `YOUR_PASSWORD` and`YOUR_PIN` with your actual vehicle VIN and account credentials.

```
String vin = "YOUR_CARS_VIN";
CarService carService = new CarService("YOUR_EMAIL", "YOUR_PASSWORD");
String id = carService.stopVentilator(vin, "YOUR_PIN");
```

## Get Car Status On Request
Use the `CarService` to retrieve the status of a previously triggered action or data request for your Škoda vehicle.
Make sure to replace `YOUR_CARS_VIN`, `YOUR_EMAIL`, `YOUR_PASSWORD` and `REQUEST_ID` with your actual vehicle VIN, account credentials and request id.

```
String vin = "YOUR_CARS_VIN";
CarService carService = new CarService("YOUR_EMAIL", "YOUR_PASSWORD");
String status = carService.getRequest(vin, "REQUEST_ID");
```

## Get Car Status
Use the `CarService` to retrieve the current status of your Škoda vehicle.
This includes valuable insights such as total kilometers driven, door and window status, tire pressure information, fuel level, battery state, and more.
Make sure to replace `YOUR_CARS_VIN`, `YOUR_EMAIL`, and `YOUR_PASSWORD` with your actual vehicle VIN and account credentials.

```
String vin = "YOUR_CARS_VIN";
CarService carService = new CarService("YOUR_EMAIL", "YOUR_PASSWORD");
CarStatus status = carService.getStatus(vin);
```


## Use Your Own Server
Use the `CarService` to retrieve information of your Škoda vehicle.
Make sure to replace `YOUR_EMAIL`, `YOUR_PASSWORD`, and `YOUR_SERVER` with your actual server and account credentials.

```
CarService carService = new CarService("YOUR_EMAIL", "YOUR_PASSWORD", "YOUR_SERVER");
```
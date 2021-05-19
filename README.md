## Universal Studio

## Spring Boot application that exposes a REST API for theme park rides.

* get all rides - GET [/rides](http://localhost:8080/rides) to get a list of all the rides with estimated queueing(wait) time
* get specific ride - GET [/rides/${id}](http://localhost:8080/rides/1) to get a specific ride with estimated queueing(wait) time
* book ride - POST JSON to [/rides/{userId}](http://localhost:8080/rides/1) to book a ride 
* create ride - PUT JSON to [/rides](http://localhost:8080/rides) to create list of rides 

## Technologies

* JDK 11+
* Maven
* Spring Boot Rest API
* H2 in memory database
* Log4j
* Embedded tomcat (for Test and Demo app)

### Http Status
- 200 OK: The request has succeeded
- 400 Bad Request: The request could not be understood by the server 
- 404 Not Found: The requested resource cannot be found
- 500 Internal Server Error: The server encountered an unexpected condition

### Sample JSON for Rides
##### GET Ride Details Response: 
```sh
[
    {
        "rideId": 101,
        "rideName": "Roller Coaster",
        "startTime": "11:00:00",
        "seatAvailable": 10,
        "waitTime": "645 min"
    },
    {
        "rideId": 102,
        "rideName": "Transformers",
        "startTime": "13:00:00",
        "seatAvailable": 10,
        "waitTime": "765 min"
    },
    {
        "rideId": 102,
        "rideName": "Transformers",
        "startTime": "13:30:00",
        "seatAvailable": 10,
        "waitTime": "795 min"
    },
    {
        "rideId": 102,
        "rideName": "Transformers",
        "startTime": "14:00:00",
        "seatAvailable": 10,
        "waitTime": "825 min"
    }
]
```

##### Book Ride : 
```sh
{
        "rideId": 105,
        "startTime": "20:30:00"
}
```


#### Create Ride:
```sh
[
    {
        "rideId": 105,
        "rideName": "Roller Coaster ",
        "startTime": "11:00:00",
        "rideCapacity": 20
    },
     {
        "rideId": 106,
        "rideName": "Transformers",
        "startTime": "12:00:00",
        "rideCapacity": 14
    }
]
```


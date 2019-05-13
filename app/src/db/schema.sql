CREATE TABLE Login (
    profId INTEGER NOT NULL,
	username VARCHAR(50) NOT NULL,
	password VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	PRIMARY KEY (profileId),
	UNIQUE (username)
);

CREATE TABLE Users (
	userId INTEGER NOT NULL AUTO_INCREMENT,
	profId INTEGER NOT NULL,
	firstname VARCHAR(50) NOT NULL,
	fastname VARCHAR(50) NOT NULL,
	bio VARCHAR(1000),
	age INTEGER,
	PRIMARY KEY (UserID),
	FOREIGN KEY (profId) REFERENCES Login(profId)
);

CREATE TABLE TripListing (
	rideId INTEGER NOT NULL AUTO_INCREMENT,
	driverId INTEGER NOT NULL,
	maxPassengers INTEGER NOT NULL,
	numPassengers INTEGER NOT NULL,
	destination VARCHAR(255) NOT NULL,
	departure VARCHAR(255) NOT NULL,
	postDate DATE NOT NULL,
	departureDate DATE NOT NULL,
	PRIMARY KEY (rideID),
	FOREIGN KEY (driverID) REFERENCES Users(userId)
);

CREATE TABLE RidePassengers (
    rideId INTEGER NOT NULL,
    passengerId NOT NULL,
    FOREIGN KEY (RideID) REFERENCES TripListing(RideID),
    FOREIGN KEY (PassengerID) REFERENCES Users(UserId)
);

CREATE TABLE Review (
	ratingID INTEGER NOT NULL AUTO_INCREMENT,
	reviewedID INTEGER NOT NULL,
	reviewerID INTEGER NOT NULL,
	rating INTEGER NOT NULL CHECK (Rating between 1 and 5),
	Comment VARCHAR(1000) NOT NULL,
	PRIMARY KEY (RatingID),
	FOREIGN KEY (ReviewedID) REFERENCES Users(UserId)
	FOREIGN KEY (ReviewerID) REFERENCES Users(UserId)
);

CREATE TABLE Driver (
    userId INTEGER NOT NULL,
    carId INTEGER,
    FOREIGN KEY (userId) REFERENCES Users(UserId)
);

package com.polyride.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
class Car {
	@NonNull
	@PrimaryKey
	@ColumnInfo(name = "carId")
	Integer carId;

	@NonNull
	@ColumnInfo(name = "make")
	String make;

	@NonNull
	@ColumnInfo(name = "model")
	String model;

	@NonNull
	@ColumnInfo(name = "modelYear")
	Integer year;

	@NonNull
	@ColumnInfo(name = "color")
	String color;

	@NonNull
	@ColumnInfo(name = "licensePlate")
	Integer licensePlate;
	
	public Car(Integer carId, String make, String model,
			   Integer year, String color, Integer licensePlate) {
		this.carId = carId;
		this.make = make;
		this.model = model;
		this.year = year;
		this.color = color;
		this.licensePlate = licensePlate;
	}


	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}


	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(Integer licensePlate) {
		this.licensePlate = licensePlate;
	}
}

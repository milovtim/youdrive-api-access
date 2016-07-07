package ru.milovtim.youdrive.domain;

import lombok.Data;
import youdrive.today.models.LatLng;

@Data
public class Car {

    private String id;
    private LatLng coord;

    private int distanceToCar;
    private String model;
    private String gosNumber;
    private boolean active;

    public static Car fromApiCar(youdrive.today.models.Car c) {
        Car car = new Car();
        car.setId(c.getId());
        car.setCoord(new LatLng(c.getLat(), c.getLon()));
        car.setDistanceToCar(c.getDistance());
        car.setGosNumber(c.getNumber());
        car.setModel(c.getModel());
        return car;
    }
}

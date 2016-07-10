package ru.milovtim.youdrive.domain;

import youdrive.today.models.LatLng;

public class Car {

    private String id;
    private LatLng coord;

    private int distanceToCar;
    private String model;
    private String gosNumber;
    private boolean active;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LatLng getCoord() {
        return coord;
    }

    public void setCoord(LatLng coord) {
        this.coord = coord;
    }

    public int getDistanceToCar() {
        return distanceToCar;
    }

    public void setDistanceToCar(int distanceToCar) {
        this.distanceToCar = distanceToCar;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getGosNumber() {
        return gosNumber;
    }

    public void setGosNumber(String gosNumber) {
        this.gosNumber = gosNumber;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

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

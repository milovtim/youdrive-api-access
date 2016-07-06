package youdrive.today.models;

import com.google.gson.annotations.SerializedName;

public class Car implements Comparable<Car>{
    String color;
    int discount;
    int distance;
    Integer fuel;
    @SerializedName("car_id")
    String id;
    String img;
    @SerializedName("in_transfer")
    boolean inTransfer;
    float lat;
    float lon;
    String model;
    String number;
    String pointer_resource;
    Tariff tariff;
    boolean transferable;
    String transmission;
    int walktime;


    public Car(String id, float lat, float lon) {
        this.id = id;
        this.lat = lat;
        this.lon = lon;
    }

    public String getPointer_resource() {
        return this.pointer_resource;
    }

    public String getImg() {
        return this.img;
    }

    public String getId() {
        return this.id;
    }

    public String getModel() {
        return this.model;
    }

    public String getNumber() {
        return this.number;
    }

    public String getColor() {
        return this.color;
    }

    public float getLat() {
        return this.lat;
    }

    public float getLon() {
        return this.lon;
    }

    public int getWalktime() {
        return this.walktime;
    }

    public String getTransmission() {
        return this.transmission;
    }

    public Integer getFuel() {
        return this.fuel;
    }

    public int getDistance() {
        return this.distance;
    }

    public Tariff getTariff() {
        return this.tariff;
    }

    public int getDiscount() {
        return this.discount;
    }

    public boolean isTransferable() {
        return this.transferable;
    }

    public boolean isInTransfer() {
        return this.inTransfer;
    }

    public int compareTo(Car car) {
        return this.walktime - car.getWalktime();
    }

    public int describeContents() {
        return 0;
    }


    public String toString() {
        return "Car{id='" + this.id + '\'' + ", model='" + this.model + '\'' + ", number='" + this.number + '\'' + ", color='" + this.color + '\'' + ", lat=" + this.lat + ", lon=" + this.lon + ", walktime=" + this.walktime + ", transmission='" + this.transmission + '\'' + ", fuel=" + this.fuel + ", distance=" + this.distance + ", tariff=" + this.tariff + ", img='" + this.img + '\'' + ", pointer_resource='" + this.pointer_resource + '\'' + ", discount=" + this.discount + ", transferable=" + this.transferable + ", inTransfer=" + this.inTransfer + '}';
    }
}

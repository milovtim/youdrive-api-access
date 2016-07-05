package youdrive.today.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;

public class Car implements Comparable<Car>, Parcelable {
    public static final Creator<Car> CREATOR;
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

    /* renamed from: youdrive.today.models.Car.1 */
    static class C17411 implements Creator<Car> {
        C17411() {
        }

        public Car createFromParcel(Parcel in) {
            return new Car(in);
        }

        public Car[] newArray(int size) {
            return new Car[size];
        }
    }

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

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.model);
        dest.writeString(this.number);
        dest.writeString(this.color);
        dest.writeString(this.img);
        dest.writeFloat(this.lat);
        dest.writeFloat(this.lon);
    }

    protected Car(Parcel in) {
        this.model = in.readString();
        this.number = in.readString();
        this.color = in.readString();
        this.img = in.readString();
        this.lat = in.readFloat();
        this.lon = in.readFloat();
    }

    static {
        CREATOR = new C17411();
    }

    public String toString() {
        return "Car{id='" + this.id + '\'' + ", model='" + this.model + '\'' + ", number='" + this.number + '\'' + ", color='" + this.color + '\'' + ", lat=" + this.lat + ", lon=" + this.lon + ", walktime=" + this.walktime + ", transmission='" + this.transmission + '\'' + ", fuel=" + this.fuel + ", distance=" + this.distance + ", tariff=" + this.tariff + ", img='" + this.img + '\'' + ", pointer_resource='" + this.pointer_resource + '\'' + ", discount=" + this.discount + ", transferable=" + this.transferable + ", inTransfer=" + this.inTransfer + '}';
    }
}

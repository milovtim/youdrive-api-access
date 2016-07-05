package youdrive.today.response;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import youdrive.today.models.Car;
import youdrive.today.models.Check;

public class CarResponse extends BaseResponse {
    @SerializedName("booking_time_left")
    private int bookingTimeLeft;
    private Car car;
    private ArrayList<Car> cars;
    private Check check;
    private String status;

    public String getStatus() {
        return this.status;
    }

    public ArrayList<Car> getCars() {
        return this.cars;
    }

    public Car getCar() {
        return this.car;
    }

    public Check getCheck() {
        return this.check;
    }

    public int getBookingTimeLeft() {
        return this.bookingTimeLeft;
    }
}

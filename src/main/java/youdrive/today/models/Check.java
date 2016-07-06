package youdrive.today.models;

import com.google.gson.annotations.SerializedName;

public class Check {
    @SerializedName("booking_time_left")
    private int bookingTimeLeft;
    @SerializedName("discount_percent")
    private int discountPercent;
    @SerializedName("discount_price")
    private long discountPrice;
    @SerializedName("parking_cost")
    private long parkingCost;
    @SerializedName("parking_time")
    private int parkingTime;
    @SerializedName("usage_weekend_cost")
    private long usageWeekendCost;
    @SerializedName("usage_weekend_time")
    private int usageWeekendTime;
    @SerializedName("usage_workday_cost")
    private long usageWorkdayCost;
    @SerializedName("usage_workday_time")
    private int usageWorkdayTime;

    public int getBookingTimeLeft() {
        return this.bookingTimeLeft;
    }

    public int getUsageWorkdayTime() {
        return this.usageWorkdayTime;
    }

    public long getUsageWorkdayCost() {
        return this.usageWorkdayCost;
    }

    public int getUsageWeekendTime() {
        return this.usageWeekendTime;
    }

    public long getUsageWeekendCost() {
        return this.usageWeekendCost;
    }

    public int getParkingTime() {
        return this.parkingTime;
    }

    public long getParkingCost() {
        return this.parkingCost;
    }

    public int getDiscountPercent() {
        return this.discountPercent;
    }

    public long getDiscountPrice() {
        return this.discountPrice;
    }


    public int describeContents() {
        return 0;
    }
}

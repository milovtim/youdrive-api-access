package youdrive.today.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;

public class Check implements Parcelable {
    public static final Creator<Check> CREATOR;
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

    /* renamed from: youdrive.today.models.Check.1 */
    static class C17421 implements Creator<Check> {
        C17421() {
        }

        public Check createFromParcel(Parcel in) {
            return new Check(in);
        }

        public Check[] newArray(int size) {
            return new Check[size];
        }
    }

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

    protected Check(Parcel in) {
        this.bookingTimeLeft = in.readInt();
        this.usageWorkdayTime = in.readInt();
        this.usageWorkdayCost = in.readLong();
        this.usageWeekendTime = in.readInt();
        this.usageWeekendCost = in.readLong();
        this.parkingTime = in.readInt();
        this.parkingCost = in.readLong();
        this.discountPercent = in.readInt();
        this.discountPrice = in.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.bookingTimeLeft);
        dest.writeInt(this.usageWorkdayTime);
        dest.writeLong(this.usageWorkdayCost);
        dest.writeInt(this.usageWeekendTime);
        dest.writeLong(this.usageWeekendCost);
        dest.writeInt(this.parkingTime);
        dest.writeLong(this.parkingCost);
        dest.writeInt(this.discountPercent);
        dest.writeLong(this.discountPrice);
    }

    static {
        CREATOR = new C17421();
    }
}

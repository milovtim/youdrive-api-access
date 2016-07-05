package youdrive.today.models;

import com.google.gson.annotations.SerializedName;

public class Region {
    @SerializedName("region_id")
    String id;
    String name;

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "Region{id='" + this.id + '\'' + ", name='" + this.name + '\'' + '}';
    }
}

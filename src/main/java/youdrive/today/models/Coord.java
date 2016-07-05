package youdrive.today.models;

import com.google.android.gms.maps.model.LatLng;

public class Coord {
    private double latitude;
    private double longitude;

    public LatLng toLatLng() {
        return new LatLng(this.latitude, this.longitude);
    }
}

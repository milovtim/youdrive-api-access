package youdrive.today.models;


public class Coord {
    private double latitude;
    private double longitude;

    public LatLng toLatLng() {
        return new LatLng(this.latitude, this.longitude);
    }
}

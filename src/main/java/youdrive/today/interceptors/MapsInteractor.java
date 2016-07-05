package youdrive.today.interceptors;

import youdrive.today.listeners.MapsActionListener;
import youdrive.today.listeners.PolygonListener;

public interface MapsInteractor {
    void getInfo(PolygonListener polygonListener);

    void getStatusCar(MapsActionListener mapsActionListener);

    void getStatusCars(double d, double d2, MapsActionListener mapsActionListener);
}

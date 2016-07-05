package youdrive.today.response;

import java.util.List;
import youdrive.today.models.Coord;
import youdrive.today.models.SimpleCar;

public class PolygonResponse extends BaseResponse {
    private List<Coord>[] area;
    private List<SimpleCar> cars;

    public List<SimpleCar> getCars() {
        return this.cars;
    }

    public List<Coord>[] getArea() {
        return this.area;
    }
}

package youdrive.today.listeners;

import java.util.List;
import youdrive.today.models.Car;
import youdrive.today.models.Check;
import youdrive.today.models.Status;

public interface MapsActionListener {
    void onCar(Car car);

    void onCars(List<Car> list);

    void onCheck(Check check);

    void onError();

    void onForbidden();

    void onStatus(Status status);

    void onTariffNotFound();

    void onUnknownError(String str);
}

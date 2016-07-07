package ru.milovtim.youdrive.session;

import org.springframework.stereotype.Component;
import youdrive.today.models.Car;

import java.util.concurrent.atomic.AtomicReference;

@Component
public class ActiveCarStore {

    private final AtomicReference<Car> activeCar = new AtomicReference<>();

    public Car getActiveCar() {
        return activeCar.get();
    }

    public void setActiveCar(Car car) {
        activeCar.set(car);
    }
}

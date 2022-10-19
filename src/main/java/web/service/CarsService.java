package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarsService {

    private List<Car> cars;

    {
        cars = new ArrayList<>();

        cars.add(new Car(1, "BMW", 730));
        cars.add(new Car(2, "MB", 320));
        cars.add(new Car(3, "Ford", 600));
        cars.add(new Car(4, "Audi", 100));
        cars.add(new Car(5, "VW", 4));
    }

    public List<Car> carList() {
        return cars;
    }

    public List<Car> carList(int count) {
        carList().stream().limit(count).collect(Collectors.toList());
        return cars;
    }
}

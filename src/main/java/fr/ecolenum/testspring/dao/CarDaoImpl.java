package fr.ecolenum.testspring.dao;

import fr.ecolenum.testspring.model.Car;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CarDaoImpl implements CarDao {

    private static Map<Integer,Car> cars = new HashMap<Integer,Car>();
    static {
        cars.put(0, new Car(0, "Bentley", "Continental GT", "Black"));
        cars.put(1, new Car(1, "Aston Martin", "DB9", "Grey"));
        cars.put(2, new Car(2, "Oldsmobile", "Rocket88", "Black"));
        cars.put(3, new Car(3, "BMW", "R1200C", "Grey"));

    }

    @Override
    public Map<Integer, Car> findAll() {
        return cars;
    }

    @Override
    public Car findById(int id) {
        return cars.get(id);
    }

    @Override
    public void save(Car car) {
    cars.put(car.getId(), car);
    }

    @Override
    public void update(Car modifiedcar, int id) {
        Car car = cars.get(id);
        car.setId(modifiedcar.getId());
        car.setBrand(modifiedcar.getBrand());
        car.setColor(modifiedcar.getColor());
        car.setModel(modifiedcar.getModel());
    }

    @Override
    public void delete(int id) {
        cars.remove(id);
    }
}

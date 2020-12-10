package fr.ecolenum.testspring.service;


import fr.ecolenum.testspring.model.Car;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CarService {



    public abstract void createCar(Car car);
    public abstract void updateCar(Integer id, Car car);
    public abstract void deleteCar(Integer id);
    public abstract List<Car> getCars();
    Optional<Car> findById(Integer id);
}

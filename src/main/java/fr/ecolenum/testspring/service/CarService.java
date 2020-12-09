package fr.ecolenum.testspring.service;


import fr.ecolenum.testspring.model.Car;

import java.util.Map;

public interface CarService {



    public abstract void createCar(Car car);
    public abstract void updateCar(Integer id, Car car);
    public abstract void deleteCar(Integer id);
    public abstract Map<Integer,Car> getCars();
    Car findById(Integer id);
}

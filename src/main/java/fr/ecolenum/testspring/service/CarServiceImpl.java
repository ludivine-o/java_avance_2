package fr.ecolenum.testspring.service;

import fr.ecolenum.testspring.dao.CarDao;
import fr.ecolenum.testspring.dao.CarDaoImpl;
import fr.ecolenum.testspring.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;



@Service
public class CarServiceImpl implements CarService{

    private CarDao cardao;

    public CarServiceImpl(CarDao cardao) {
        this.cardao = cardao;
    }

    @Override
    public void createCar(Car car) {
        this.cardao.save(car);
    }

    @Override
    public void updateCar(Integer id, Car car) {
        this.cardao.update(car, id);
    }

    @Override
    public void deleteCar(Integer id) {
        this.cardao.delete(id);
    }

    @Override
    public Map<Integer, Car> getCars() {
        return this.cardao.findAll();
    }

    @Override
    public Car findById(Integer id) {
        return this.cardao.findById(id);
    }
}

package fr.ecolenum.testspring.service;

import fr.ecolenum.testspring.dao.CarDao;
import fr.ecolenum.testspring.model.Car;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;


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
        this.cardao.save(car);
    }

    @Override
    public void deleteCar(Integer id) {
        this.cardao.deleteById(id);
    }

    @Override
    public List<Car> getCars() {
        return this.cardao.findAll();
    }

    @Override
    public Optional<Car> findById(Integer id) {
        return this.cardao.findById(id);
    }
}

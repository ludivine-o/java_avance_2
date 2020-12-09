package fr.ecolenum.testspring.dao;
import fr.ecolenum.testspring.model.Car;
import java.util.Map;

public interface CarDao {
    public Map<Integer,Car> findAll();
    public Car findById(int id);
    public void save(Car car);
    void update(Car car, int id);
    void delete(int id);

}

package fr.ecolenum.testspring.dao;
import fr.ecolenum.testspring.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface CarDao extends JpaRepository<Car,Integer> {

}

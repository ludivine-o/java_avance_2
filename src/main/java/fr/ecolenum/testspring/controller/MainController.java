package fr.ecolenum.testspring.controller;

import fr.ecolenum.testspring.dao.CarDao;
import fr.ecolenum.testspring.model.Car;

import java.util.*;


import fr.ecolenum.testspring.service.CarService;
import fr.ecolenum.testspring.service.CarServiceImpl;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@RestController
public class MainController {

    private CarService carservice;

    @Autowired
    public MainController(CarService carservice) {
        this.carservice = carservice;
    }


    //Récupérer la liste
    @GetMapping(value = "/cars")
    @ResponseBody
    public List<Car> getCars() {
       return this.carservice.getCars();
    }

    //Récupérer un produit par son Id
    @GetMapping(value="/cars/{id}")
    @ResponseBody
    public Optional<Car> getCar(@PathVariable("id") int id) {
        return this.carservice.findById(id);
    }

    //ajouter une voiture
    @PostMapping(path = "/cars", consumes = "application/json")
    @ResponseBody
    public void addCar(@RequestBody Car car) {
        this.carservice.createCar(car);
    }

    //modifier une voiture
    @PutMapping(path = "/cars/{id}", consumes = "application/json")
    @ResponseBody
    public void modifyCar(@RequestBody Car modifiedcar, @PathVariable("id") int id) {
        this.carservice.updateCar(id,modifiedcar);
    }

    @DeleteMapping(path = "/cars/{id}")
    @ResponseBody
    public void deleteCar(@PathVariable("id") int id) {
         this.carservice.deleteCar(id);     }

}



package fr.ecolenum.testspring.controller;

import fr.ecolenum.testspring.model.Car;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    private static List<Car> cars = new ArrayList<Car>();
    static {
        cars.add(new Car(0, "Bentley", "Continental GT", "Black"));
        cars.add(new Car(1, "Aston Martin", "DB9", "Grey"));
        cars.add(new Car(2, "Oldsmobile", "Rocket88", "Black"));
    }

    @Value("${welcome.message}")
    private String message;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", message);
        model.addAttribute("cars", cars);
        return "index";
    }

    @GetMapping("/{id}")
    public String car(Model model, @PathVariable("id") int id){
        model.addAttribute("car", cars.get(id));
        return "car";
    }
    


}



package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarFactory;

@Controller
public class CarController {

    @Autowired
    private CarFactory carFactory;

    @GetMapping("/cars")
    public String printCars(@RequestParam(value = "count", required = false) Integer count,
                            Model model) {

        model.addAttribute("caMod", carFactory.getCars(count));

        return "cars";
    }
}

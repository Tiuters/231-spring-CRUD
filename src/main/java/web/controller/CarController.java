package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.Car;
import web.service.CarFactory;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarFactory carFactory;

    @Autowired
    public CarController(CarFactory carFactory) {
        this.carFactory = carFactory;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("cars", carFactory.index());
        return "views/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("car", carFactory.show(id));
        return "views/show";
    }

    @GetMapping("/new")
    public String newCar(@ModelAttribute("car") Car car) {
        return "views/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("car") Car car) {
        carFactory.save(car);
        return "redirect:/cars";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("car", carFactory.show(id));
        return "views/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("car") Car car,
                         @PathVariable("id") int id) {
        carFactory.update(id, car);
        return "redirect:/cars";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        carFactory.delete(id);
        return "redirect:/cars";
    }
}


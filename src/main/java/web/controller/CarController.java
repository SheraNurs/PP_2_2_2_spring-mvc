package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.service.CarsService;

import java.util.stream.Collectors;

@Controller
public class CarController {

    private final CarsService carsService;

    @Autowired
    public CarController(CarsService carsService) {
        this.carsService = carsService;
    }

    @GetMapping("/cars")
    public String printCar (@RequestParam(value = "count", required = false) Integer count, ModelMap modelMap) {
        if (count!=null){
            modelMap.addAttribute("cars", carsService.carList().stream().limit(count).collect(Collectors.toList()));
        } else {
            modelMap.addAttribute("cars", carsService.carList());
        }
        return "cars";
    }
}

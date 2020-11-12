package ru.enai.myservice.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    @GetMapping("/mainPages")
    public String mainPages(@RequestParam(value = "valuesOne") int valuesOne,
                            @RequestParam(value = "valuesTwo") int valuesTwo,
                            @RequestParam(value = "operand") String operand,
                            Model model) {

        double result = 0;
        boolean error = false;
        switch (operand) {
           case  "addition" : result = valuesOne + valuesTwo;
           break;
           case "subtraction" : result = valuesOne - valuesTwo;
           break;
           case  "multiplication" : result = valuesOne * valuesTwo;
           break;
           case "division" : result = (double) valuesOne / valuesTwo;
           break;
            default: error = true;
        }
        if (error) {
            model.addAttribute("message", "Error");
        } else {
            model.addAttribute("message", result);
        }

        return "mainPages";
    }



}

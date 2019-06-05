/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.controllers;

import etracer.com.projectetracer.entities.Employee;
import etracer.com.projectetracer.entities.Province;
import etracer.com.projectetracer.repositories.EmployeeRepository;
import etracer.com.projectetracer.repositories.ProvinceRepository;
import etracer.com.projectetracer.services.EmployeeService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Relion31
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeService employeeService;

    
    @GetMapping("/employee")
    public String employee(Model model) {
        model.addAttribute("dataEmployee", employeeRepository.getAll());
        return "employee";
    }
    
    @PostMapping("/employee/addData")
    public String addData(@Valid Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/employee";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.controllers;

import etracer.com.projectetracer.entities.ReportProblem;
import etracer.com.projectetracer.repositories.EmployeeRepository;
import etracer.com.projectetracer.repositories.ReportProblemRepository;
import etracer.com.projectetracer.services.ReportProblemService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author yosef
 */
public class ReportProblemController {
    @Autowired
    private ReportProblemRepository reportRepository;
    @Autowired
    private ReportProblemService reportService;
    @Autowired 
    private EmployeeRepository employeeRepository;
    
    @GetMapping("/reportproblem")
    public String reportproblem(Model model, ReportProblem reportproblem) {
        model.addAttribute("dataReport", reportRepository.getAll());
        model.addAttribute("dataEmployee", employeeRepository.getAll());
        return "reportproblem";
    }
    
    @PostMapping("/reportproblem/addData")
    public String addData(@Valid ReportProblem reportproblem) {
        reportRepository.save(reportproblem);
        return "redirect:/reportproblem";
    }
    @GetMapping("/department/update")
    public String update(@Valid ReportProblem reportproblem) {
        reportRepository.save(reportproblem);
        return "redirect:/reportproblem";
    }
}

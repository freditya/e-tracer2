/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.controllers;

import etracer.com.projectetracer.entities.Province;
import etracer.com.projectetracer.repositories.ProvinceRepository;
import etracer.com.projectetracer.services.ProvinceService;
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
public class MainController {

    @Autowired
    private ProvinceService ps;
    @Autowired
    private ProvinceRepository provinceRepository;

    @GetMapping("/index")
    public String index() {
        return "index";
    }
    @GetMapping("/province")
    public String province(Model model) {
        model.addAttribute("dataProvince", provinceRepository.getAll());
        return "Province";
    }

    @PostMapping("/addData")
    public String addData(@Valid Province province) {
        provinceRepository.save(province);
        return "redirect:/province";
    }

    @GetMapping("/update")
    public String updateActor(@Valid Province province) {
        provinceRepository.save(province);
        return "redirect:/province";
    }

    @GetMapping("/delete")
    public String softDelete(@Valid Province province) {
        provinceRepository.save(province);
        return "redirect:/province";
    }
}

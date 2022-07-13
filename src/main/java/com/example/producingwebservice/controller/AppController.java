package com.example.producingwebservice.controller;


import com.example.producingwebservice.CountryRepository;
import io.spring.guides.gs_producing_web_service.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("/")
    public String index(Model model)
    {
        return "index";
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute Country country) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("country_information");
        country = countryRepository.findCountry(country.getName());
        modelAndView.addObject("country", country);
        return modelAndView;
    }


}

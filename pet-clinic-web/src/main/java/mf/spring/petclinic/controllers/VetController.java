package mf.spring.petclinic.controllers;

import mf.spring.petclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/vets")
@Controller
public class VetController {

    private final VetService vetService;


    public VetController(VetService vetService) {
        this.vetService = vetService;
    }


    @RequestMapping({"", "/", "/index", "/index.html", "/vets.html"})
    public String listVets(Model model){

        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }
}

package com.tp.TP;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class MainController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/ConnexionEtu").setViewName("ConnexionEtu");
    }

    @GetMapping("/")
    public String kk() {
        return "redirect:/ConnexionEtu.html";
    }

    @PostMapping("/")
    public String gg() {
        return "redirect:/ConnexionEtu.html";
    }

}

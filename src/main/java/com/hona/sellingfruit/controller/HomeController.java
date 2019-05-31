package com.hona.sellingfruit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/Admin/ThemTraiCay")
    public String index() {
        return "themtraicay";
    }

    @RequestMapping("/")
    public String home() {
        return "index";
    }


}

package com.hona.sellingfruit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "themtraicay";
    }

    @RequestMapping("/donhangmoi")
    public String donhangmoi(){
        return "donhangmoi";
    }

    @RequestMapping("/donhangdaxuli")
    public String donhangdaxuli(){
        return "donhangdaxuli";
    }
}

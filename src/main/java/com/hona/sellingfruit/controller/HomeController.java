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

    @RequestMapping(path = "/blank")
    public String blank(){
        return "blank";
    }

    @RequestMapping(path = "/trangchu")
    public String trangchu(){
        return "trangchu";
    }

    @RequestMapping(path="/traicay")
    public String traicay(){
        return "traicay";
    }

    @RequestMapping(path="/danhmuc")
    public String danhmuc(){
        return "danhmuc";
    }

    @RequestMapping(path="/lienhe")
    public String lienhe(){
        return "lienhe";
    }
}

package com.hona.sellingfruit.controller;

import com.hona.sellingfruit.entity.TraiCay;
import com.hona.sellingfruit.service.TraiCayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class RestApiTraiCayController {
    @Autowired
    private TraiCayService traiCayService;

    @RequestMapping(path="/traicay", method= RequestMethod.GET)
    public List<TraiCay> getAllTraiCay(){
        return traiCayService.getAllTraiCayList();
    }
}

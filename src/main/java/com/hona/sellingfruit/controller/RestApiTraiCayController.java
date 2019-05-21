package com.hona.sellingfruit.controller;

import com.hona.sellingfruit.entity.TraiCay;
import com.hona.sellingfruit.service.TraiCayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Integer.parseInt;

@RestController
@RequestMapping(path = "/api")
public class RestApiTraiCayController {
    @Autowired
    private TraiCayService traiCayService;

    @RequestMapping(path="/GetListTraiCay", method= RequestMethod.GET)
    public List<TraiCay> getAllTraiCay(){
        return traiCayService.getAllTraiCayList();
    }

    @RequestMapping(path="/GetTraiCayById", method= RequestMethod.GET)
    public TraiCay getTraiCayById(@RequestParam(value="maTraiCay") String maTraiCay){
        return traiCayService.getTraiCayById(maTraiCay);
    }
}

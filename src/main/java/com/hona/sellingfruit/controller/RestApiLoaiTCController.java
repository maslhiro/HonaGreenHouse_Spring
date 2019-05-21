package com.hona.sellingfruit.controller;

import com.hona.sellingfruit.entity.LoaiTraiCay;
import com.hona.sellingfruit.service.LoaiTraiCayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class RestApiLoaiTCController {
    @Autowired
    private LoaiTraiCayService loaiTraiCayService;

    @RequestMapping(path="/loaitraicay", method= RequestMethod.GET)
    public List<LoaiTraiCay> getAllLoaiTraiCay(){
        return loaiTraiCayService.getAllLoaiTraiCayList();
    }
}

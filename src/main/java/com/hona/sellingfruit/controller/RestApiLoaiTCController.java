package com.hona.sellingfruit.controller;

import com.hona.sellingfruit.entity.LoaiTraiCay;
import com.hona.sellingfruit.service.LoaiTraiCayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/Api")
public class RestApiLoaiTCController {
    @Autowired
    private LoaiTraiCayService loaiTraiCayService;

    @RequestMapping(path="/GetListLoaiTC", method= RequestMethod.GET)
    public List<LoaiTraiCay> getAllLoaiTraiCay(){
        return loaiTraiCayService.getAllLoaiTraiCayList();
    }

    @RequestMapping(path="/GetLoaiTraiCayById", method= RequestMethod.GET)
    public LoaiTraiCay getLoaiTraiCayById(@RequestParam(value="maLoai") String maLoai){
        return loaiTraiCayService.getLoaiTraiCayById(maLoai);
    }
}

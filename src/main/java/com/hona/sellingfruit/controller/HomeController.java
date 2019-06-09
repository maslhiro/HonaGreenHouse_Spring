package com.hona.sellingfruit.controller;

import com.hona.sellingfruit.entity.TraiCay;
import com.hona.sellingfruit.service.TraiCayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    TraiCayService traiCayService;

    @RequestMapping(path = {"/TrangChu","","/"})
    public String trangChu(){
        return "trangchu";
    }

    @RequestMapping(path="/TraiCay")
    @ResponseBody
    public ModelAndView traiCay(@RequestParam("Id") String id){
        ModelAndView mav = new ModelAndView("chitiettraicay-home");

        TraiCay traiCay = traiCayService.getTraiCayById(id);

        mav.addObject("traiCay",traiCay);
        return mav;
    }

    @RequestMapping(path="/DanhMuc")
    public String danhMuc(){
        return "danhmuc";
    }

    @RequestMapping(path="/LienHe")
    public String lienHe(){
        return "lienhe";
    }

    @RequestMapping(path="/GioHang")
    public String gioHang(){
        return "giohang";
    }
}

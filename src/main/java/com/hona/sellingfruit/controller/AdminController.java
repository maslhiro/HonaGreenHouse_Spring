package com.hona.sellingfruit.controller;

import com.hona.sellingfruit.entity.TraiCay;
import com.hona.sellingfruit.service.TraiCayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Admin")
public class AdminController {
    @Autowired
    TraiCayService traiCayService;

    @RequestMapping("/TraiCay")
    public String traiCay() {
        return "traicay";
    }

    @RequestMapping("/LoaiTraiCay")
    public String loaiTraiCay() {
        return "loaitraicay";
    }

    @RequestMapping("/ChiTietTraiCay")
    @ResponseBody
    public ModelAndView  chiTietTraiCay(@RequestParam("Id") String id){
        ModelAndView mav = new ModelAndView("chitiettraicay");

        TraiCay traiCay = traiCayService.getTraiCayById(id);
        mav.addObject("maTraiCay","Chi tiết trái cây mã " + id);
        mav.addObject("traiCay",traiCay);
        return mav;
    }

    @RequestMapping("/Voucher")
    public String voucher() {
        return "voucher";
    }

    @RequestMapping("/ThongKeNhap")
    public  String thongKeNhap(){
        return "thongkenhap";
    }

    @RequestMapping("/ThongKeXuat")
    public  String thongKeXuat(){
        return "thongkexuat";
    }


    @RequestMapping("/DonHangMoi")
    public  String donHangMoi(){
        return "donhangmoi";
    }

    @RequestMapping("/DonHangDaXuLi")
    public  String donHangDaXuLi(){
        return "donhangdaxuli";
    }

    @RequestMapping("/ChiTietDonHang")
    public  String chiTietDonHang(){
        return "chitietdonhang";
    }
}

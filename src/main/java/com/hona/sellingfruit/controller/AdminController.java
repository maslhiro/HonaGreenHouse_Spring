package com.hona.sellingfruit.controller;

import com.hona.sellingfruit.entity.TraiCay;
import com.hona.sellingfruit.service.DonHangService;
import com.hona.sellingfruit.service.TraiCayService;
import com.hona.sellingfruit.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Admin")
public class AdminController {

    @Autowired
    DonHangService donHangService;

    @RequestMapping("/voucher")
    public String voucher() {
        return "voucher";
    }
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
    public String voucherPage() {
        return "voucher";
    }

    @RequestMapping("/Dashboard")
    public ModelAndView dashboard(){
        ModelAndView mav = new ModelAndView("dashboard");

        String countTC = (traiCayService.getAllTraiCayList().size()) + " Loại Trái Cây!";
        String countDHH = (donHangService.getListDonHangByTinhTrang(1).size())+ " ĐH Đã Hủy!";
        String countDHM = (donHangService.getListDonHangByTinhTrang(0).size())+" ĐH Mới!";
        String countDHTC = (donHangService.getListDonHangByTinhTrang(2).size())+ " ĐH Thành Công!";

        mav.addObject("countTC",countTC);
        mav.addObject("countDHH",countDHH);
        mav.addObject("countDHM",countDHM);
        mav.addObject("countDHTC",countDHTC);

        return mav;
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

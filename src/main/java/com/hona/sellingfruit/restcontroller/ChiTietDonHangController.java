package com.hona.sellingfruit.restcontroller;

import com.hona.sellingfruit.entity.ChiTietDonHang;
import com.hona.sellingfruit.service.ChiTietDonHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/Api")
public class ChiTietDonHangController {
    @Autowired
    private ChiTietDonHangService chiTietDonHangService;

    @GetMapping(path="/GetChiTietDonHangByID")
    public List<ChiTietDonHang> getListDonHangByTinhTrang(@RequestParam(value="maDonHang") String maDonHang){
        return chiTietDonHangService.getChiTietDonHangByID(maDonHang);
    }
}

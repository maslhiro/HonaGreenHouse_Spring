package com.hona.sellingfruit.restcontroller;

import com.hona.sellingfruit.entity.DonHang;
import com.hona.sellingfruit.service.DonHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Api")
public class DonHangController {
    @Autowired
    private DonHangService donHangService;

    @GetMapping(path="/GetListDonHangMoi")
    public List<DonHang> get(){
        return donHangService.getListDonHangByTinhTrang(0);
    }
}

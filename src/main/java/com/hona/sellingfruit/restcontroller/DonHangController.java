package com.hona.sellingfruit.restcontroller;

import com.hona.sellingfruit.entity.DonHang;
import com.hona.sellingfruit.service.DonHangService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Api")
public class DonHangController {
    @Autowired
    private DonHangService donHangService;

    @GetMapping(path="/GetListDonHangMoi")
    public List<DonHang> getListDonHangMoi(){
        return donHangService.getListDonHangByTinhTrang(0);
    }

    @GetMapping(path="/GetListDonHangDaXacNhan")
    public List<DonHang> getListDonHangDaXacNhan(){
        return donHangService.getListDonHangByTinhTrangIsNot(0);
    }

    @GetMapping(path="/GetDonHangById")
    @ResponseStatus(HttpStatus.OK)
    public DonHang getDonHangById(@RequestParam(value="maDonHang") String maDonHang){
        return donHangService.getDonHangById(maDonHang);
    }

    @GetMapping(path="/HuyDonHangById")
    @ResponseStatus(HttpStatus.OK)
    public Integer huyDonHangById(@RequestParam(value="maDonHang") String maDonHang){
        return donHangService.huyDonHangById(maDonHang);
    }

    @PostMapping(path="/XacNhanDonHangById")
    public Integer xacNhanDonHangById(@RequestBody String stringJSON){
        JSONObject jsonObject = new JSONObject(stringJSON);

        String maDonHang = (String) jsonObject.get("maDonHang");
        String bangChungThanhToan = (String) jsonObject.get("bangChungThanhToan");


        return donHangService.xacNhanDonHangById(maDonHang, bangChungThanhToan);
    }
}

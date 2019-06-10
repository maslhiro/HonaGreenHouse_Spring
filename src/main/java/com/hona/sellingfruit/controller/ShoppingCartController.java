package com.hona.sellingfruit.controller;

import com.hona.sellingfruit.entity.TraiCay;
import com.hona.sellingfruit.entity.Voucher;
import com.hona.sellingfruit.exception.NotEnoughProductsInStockException;
import com.hona.sellingfruit.service.TraiCayService;
import com.hona.sellingfruit.service.ShoppingCartService;
import com.hona.sellingfruit.service.VoucherService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    private final TraiCayService traiCayService;

    private final VoucherService voucherService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService, TraiCayService traiCayService, VoucherService voucherService) {
        this.shoppingCartService = shoppingCartService;
        this.traiCayService = traiCayService;
        this.voucherService = voucherService;
    }

    @RequestMapping("/shoppingCart")
    @ResponseBody
    public ModelAndView shoppingCart(Integer phanTramGiam, Integer tienGiamToiDa) {
        ModelAndView modelAndView = new ModelAndView("/giohang");

        Map<TraiCay, Integer> sanPham = shoppingCartService.getTraiCaysInCart();
        Map<String,Map<String,String>> list =  new HashMap<>();
        Map<String,String> sp;
        for (Map.Entry<TraiCay, Integer> entry : sanPham.entrySet()) {
            sp =  new HashMap<>();
            TraiCay tc = entry.getKey();
            Integer i = entry.getValue();
            sp.put("maTraiCay",tc.getMaTraiCay());
            sp.put("tenTraiCay",tc.getTenTraiCay());
            sp.put("giaTraiCay",tc.getDonGiaXuat().toString());
            sp.put("soLuong",i.toString());
            list.put(tc.getMaTraiCay(),sp);
        }

        String tongTien = shoppingCartService.getTotal(phanTramGiam, tienGiamToiDa).toString();

        modelAndView.addObject("sanPham", list);
        modelAndView.addObject("tongTien", tongTien);
        return modelAndView;
    }

    @RequestMapping("/shoppingCart/addProduct/{productId}/{numberProduct}")
    public ModelAndView addTraiCayToCart(@PathVariable("productId") String productId, @PathVariable("numberProduct") String numberProduct) {
        TraiCay traiCay =traiCayService.getTraiCayById(productId);
        if(traiCay!=null){
            shoppingCartService.addTraiCay(traiCay, numberProduct);
        }
        return shoppingCart(null, null);
    }

    @RequestMapping("/shoppingCart/removeProduct/{productId}")
    public ModelAndView removeTraiCayFromCart(@PathVariable("productId") String productId) {
        TraiCay traiCay =traiCayService.getTraiCayById(productId);
        if(traiCay!=null){
            shoppingCartService.removeTraiCay(traiCay);
        }
        return shoppingCart(null, null);
    }

    @RequestMapping("/shoppingCart/updateProduct/{productId}/{numberProduct}")
    public ModelAndView removeTraiCayFromCart(@PathVariable("productId") String productId, @PathVariable("numberProduct") String numberProduct) {
        TraiCay traiCay =traiCayService.getTraiCayById(productId);
        if(traiCay!=null){
            shoppingCartService.updateTraiCay(traiCay, numberProduct);
        }
        return shoppingCart(null, null);
    }

    @RequestMapping("/shoppingCart/checkout")
    public ModelAndView checkout() {
        try {
            shoppingCartService.checkout();
        } catch (NotEnoughProductsInStockException e) {
            return shoppingCart(null, null).addObject("outOfStockMessage", e.getMessage());
        }
        return shoppingCart(null, null);
    }

    @RequestMapping("/shoppingCart/voucher/{voucherId}")
    public ModelAndView voucher(@PathVariable("voucherId") String voucherId) {
        Voucher vc =voucherService.getVoucherByMaGiamGia(voucherId);
        if(vc!=null){
            if(vc.getTrangThai() == 1 && vc.getSoLanSuDung() < vc.getSoLanSuDungToiDa()) {
                vc.setSoLanSuDung(vc.getSoLanSuDung() + 1);
                return shoppingCart(vc.getPhanTramGiam(), vc.getTienGiamToiDa());
            }
        }
        return shoppingCart(null, null);
    }

    @PostMapping(path="/shoppingCart/checkOut")
    public String checkOut(@RequestBody String stringJSON){
        JSONObject jsonObject = new JSONObject(stringJSON);

        Map<String,String> thongTinNguoiMua = new HashMap<>();
        thongTinNguoiMua.put("voucher", (String) jsonObject.get( "voucher"));
        thongTinNguoiMua.put("tongTien", (String) jsonObject.get( "tongTien"));
        thongTinNguoiMua.put("tenNguoiNhan", (String) jsonObject.get( "tenNguoiNhan"));
        thongTinNguoiMua.put("SDT", (String) jsonObject.get( "SDT"));
        thongTinNguoiMua.put("diaChiNhanHang", (String) jsonObject.get( "diaChiNhanHang"));
        thongTinNguoiMua.put("ghiChu", (String) jsonObject.get( "ghiChu"));
        checkout();
        String maDonHang = shoppingCartService.insertDonHang(thongTinNguoiMua);
        return maDonHang;
    }
}

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    private final TraiCayService traiCayService;

    private VoucherService voucherService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService, TraiCayService traiCayService) {
        this.shoppingCartService = shoppingCartService;
        this.traiCayService = traiCayService;
    }

    @RequestMapping("/shoppingCart")
    @ResponseBody
    public ModelAndView shoppingCart() {
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

        String tongTien = shoppingCartService.getTotal().toString();
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
        return shoppingCart();
    }

    @RequestMapping("/shoppingCart/removeProduct/{productId}")
    public ModelAndView removeTraiCayFromCart(@PathVariable("productId") String productId) {
        TraiCay traiCay =traiCayService.getTraiCayById(productId);
        if(traiCay!=null){
            shoppingCartService.removeTraiCay(traiCay);
        }
        return shoppingCart();
    }

    @RequestMapping("/shoppingCart/updateProduct/{productId}/{numberProduct}")
    public ModelAndView removeTraiCayFromCart(@PathVariable("productId") String productId, @PathVariable("numberProduct") String numberProduct) {
        TraiCay traiCay =traiCayService.getTraiCayById(productId);
        if(traiCay!=null){
            shoppingCartService.updateTraiCay(traiCay, numberProduct);
        }
        return shoppingCart();
    }

    @RequestMapping("/shoppingCart/checkout")
    public ModelAndView checkout() {
        try {
            shoppingCartService.checkout();
        } catch (NotEnoughProductsInStockException e) {
            return shoppingCart().addObject("outOfStockMessage", e.getMessage());
        }
        return shoppingCart();
    }
}

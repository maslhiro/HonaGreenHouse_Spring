package com.hona.sellingfruit.controller;

import com.hona.sellingfruit.entity.TraiCay;
import com.hona.sellingfruit.exception.NotEnoughProductsInStockException;
import com.hona.sellingfruit.service.TraiCayService;
import com.hona.sellingfruit.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    private final TraiCayService traiCayService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService, TraiCayService traiCayService) {
        this.shoppingCartService = shoppingCartService;
        this.traiCayService = traiCayService;
    }

    @RequestMapping("/shoppingCart")
    @ResponseBody
    public ModelAndView shoppingCart() {
        ModelAndView modelAndView = new ModelAndView("/giohang");
        modelAndView.addObject("Sản phẩm", shoppingCartService.getTraiCaysInCart());
        modelAndView.addObject("Tổng tiền", shoppingCartService.getTotal().toString());
        return modelAndView;
    }

    @RequestMapping("/shoppingCart/addProduct/{productId}")
    public ModelAndView addTraiCayToCart(@PathVariable("productId") String productId) {
        TraiCay traiCay =traiCayService.getTraiCayById(productId);
        if(traiCay!=null){
            shoppingCartService.addTraiCay(traiCay);
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

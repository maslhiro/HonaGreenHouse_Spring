package com.hona.sellingfruit.service;

import com.hona.sellingfruit.exception.NotEnoughProductsInStockException;
import com.hona.sellingfruit.entity.TraiCay;

import java.math.BigDecimal;
import java.util.Map;

public interface ShoppingCartService {

    void addTraiCay(TraiCay traiCay, String numberProduct);

    void removeTraiCay(TraiCay traiCay);

    Map<TraiCay, Integer> getTraiCaysInCart();

    void checkout() throws NotEnoughProductsInStockException;

    BigDecimal getTotal();

    void updateTraiCay(TraiCay traiCay, String numberProduct);
}

package com.hona.sellingfruit.exception;

import com.hona.sellingfruit.entity.TraiCay;

public class NotEnoughProductsInStockException extends Exception {

    private static final String DEFAULT_MESSAGE = "Không đủ sản phẩm trong kho";

    public NotEnoughProductsInStockException() {
        super(DEFAULT_MESSAGE);
    }

    public NotEnoughProductsInStockException(TraiCay traiCay) {
        super(String.format("Không đủ %s trong kho. Chỉ còn lại %d", traiCay.getTenTraiCay(), traiCay.getSoLuong()));
    }

}

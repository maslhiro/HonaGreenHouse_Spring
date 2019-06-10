package com.hona.sellingfruit.service;

import com.hona.sellingfruit.exception.NotEnoughProductsInStockException;
import com.hona.sellingfruit.entity.TraiCay;
import com.hona.sellingfruit.repository.TraiCayRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Triển khai giỏ hàng với Map và session bean
 *
 * @author HaiTho
 */
@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final TraiCayRepository traiCayRepositorys;

    private Map<TraiCay, Integer> traiCays = new HashMap<>();

    @Autowired
    public ShoppingCartServiceImpl(TraiCayRepository traiCayRepository) {
        this.traiCayRepositorys = traiCayRepository;
    }


    @Override
    public void addTraiCay(TraiCay traiCay, String numberProduct) {
        int soLuong = Integer.parseInt(numberProduct);
        if(traiCays.size() == 0){
            traiCays.put(traiCay, soLuong);
        } else {
            for (Map.Entry<TraiCay, Integer> entry : traiCays.entrySet()) {
                TraiCay tc = entry.getKey();
                Integer i = entry.getValue();
                if (traiCay.getMaTraiCay().equals(tc.getMaTraiCay()) == true) {
                    traiCays.put(tc, i + soLuong);
                } else {
                    traiCays.put(traiCay, soLuong);
                }
            }
        }
    }


    @Override
    public void removeTraiCay(TraiCay traiCay) {
        if (traiCays != null) {
            for (Map.Entry<TraiCay, Integer> entry : traiCays.entrySet()) {
                TraiCay tc = entry.getKey();
                if (traiCay.getMaTraiCay().equals(tc.getMaTraiCay()) == true) {
                    traiCays.remove(tc);
                }
            }
        }
    }

    @Override
    public void updateTraiCay(TraiCay traiCay, String numberProduct){
        if (traiCays != null) {
            for (Map.Entry<TraiCay, Integer> entry : traiCays.entrySet()) {
                TraiCay tc = entry.getKey();
                if (traiCay.getMaTraiCay().equals(tc.getMaTraiCay()) == true) {
                    traiCays.put(tc, Integer.parseInt(numberProduct));
                }
            }
        }
    }

    @Override
    public Map<TraiCay, Integer> getTraiCaysInCart() {
        return Collections.unmodifiableMap(traiCays);
    }

    /**
     * Check sản phẩm trong kho
     *
     * @throws NotEnoughProductsInStockException
     */
    @Override
    public void checkout() throws NotEnoughProductsInStockException {
        TraiCay traiCay;
        for (Map.Entry<TraiCay, Integer> entry : traiCays.entrySet()) {
            // Làm mới số lượng cho mỗi sản phẩm trước khi kiểm tra
            traiCay = traiCayRepositorys.findById(entry.getKey().getMaTraiCay()).get();
            if (traiCay.getSoLuong() < entry.getValue())
            {
                throw new NotEnoughProductsInStockException(traiCay);
            }else
                {
                // Trừ số lượng mua
                entry.getKey().setSoLuong(traiCay.getSoLuong() - entry.getValue());
                // Lưu lại DB
                traiCayRepositorys.save(entry.getKey());
            }
        }
        traiCayRepositorys.flush();
        // Xóa map
        traiCays.clear();
    }

    @Override
    public BigDecimal getTotal(Integer phanTramGiam, Integer tienGiamToiDa) {
        if (phanTramGiam != null && tienGiamToiDa != null){
            BigDecimal tongTien = traiCays.entrySet().stream()
                    .map(entry -> BigDecimal.valueOf(entry.getKey().getDonGiaXuat()).multiply(BigDecimal.valueOf(entry.getValue())))
                    .reduce(BigDecimal::add)
                    .orElse(BigDecimal.ZERO);

        double tong = tongTien.doubleValue();
        Double tienGiam = (tong * phanTramGiam)/100;
        if (tienGiam > tienGiamToiDa){
            tienGiam = (double)tienGiamToiDa;
        }

        tong -= tienGiam;

        BigDecimal tienSauGiamGia = new BigDecimal(tong, MathContext.DECIMAL64);

        return tienSauGiamGia;

        } else {
            return traiCays.entrySet().stream()
                    .map(entry -> BigDecimal.valueOf(entry.getKey().getDonGiaXuat()).multiply(BigDecimal.valueOf(entry.getValue())))
                    .reduce(BigDecimal::add)
                    .orElse(BigDecimal.ZERO);
        }
    }
}

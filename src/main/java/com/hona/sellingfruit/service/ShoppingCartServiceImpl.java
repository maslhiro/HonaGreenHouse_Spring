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
    public void addTraiCay(TraiCay traiCay) {
        if (traiCays.containsKey(traiCay)) {
            traiCays.replace(traiCay, traiCays.get(traiCay) + 1);
        } else {
            traiCays.put(traiCay, 1);
        }
    }


    @Override
    public void removeTraiCay(TraiCay traiCay) {
        if (traiCays.containsKey(traiCay)) {
            if (traiCays.get(traiCay) > 1)
                traiCays.replace(traiCay, traiCays.get(traiCay) - 1);
            else if (traiCays.get(traiCay) == 1) {
                traiCays.remove(traiCay);
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
    public BigDecimal getTotal() {
        return traiCays.entrySet().stream()
                .map(entry -> BigDecimal.valueOf(entry.getKey().getDonGiaXuat()).multiply(BigDecimal.valueOf(entry.getValue())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}

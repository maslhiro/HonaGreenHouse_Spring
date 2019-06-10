package com.hona.sellingfruit.service;

import com.hona.sellingfruit.entity.ChiTietDonHang;

import java.util.List;

public interface ChiTietDonHangService {
    public List<ChiTietDonHang> getChiTietDonHangByID(String maDonHang);
}
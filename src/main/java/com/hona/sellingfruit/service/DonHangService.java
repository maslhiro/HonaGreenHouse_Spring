package com.hona.sellingfruit.service;

import com.hona.sellingfruit.entity.DonHang;

import java.util.List;

public interface DonHangService {
    public List<DonHang> getListDonHangByTinhTrang(int tinhTrang);
}

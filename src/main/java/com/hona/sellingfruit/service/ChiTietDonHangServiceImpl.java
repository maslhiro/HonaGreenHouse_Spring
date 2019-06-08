package com.hona.sellingfruit.service;

import com.hona.sellingfruit.entity.ChiTietDonHang;
import com.hona.sellingfruit.repository.ChiTietDonHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChiTietDonHangServiceImpl implements ChiTietDonHangService {
    @Autowired
    private ChiTietDonHangRepository chiTietDonHangRepository;

    @Override
    public List<ChiTietDonHang> getChiTietDonHangByID(String maDonHang) {
        return chiTietDonHangRepository.getAllByMaDonHang(maDonHang);
    }
}

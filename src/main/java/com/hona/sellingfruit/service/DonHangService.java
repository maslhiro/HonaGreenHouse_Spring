package com.hona.sellingfruit.service;

import com.hona.sellingfruit.entity.DonHang;

import java.util.List;

public interface DonHangService {
     public List<DonHang> getListDonHangByTinhTrang(int tinhTrang);
     public List<DonHang> getListDonHangByTinhTrangIsNot(int tinhTrang);
     public Integer huyDonHangById(String maDonHang);
     public Integer xacNhanDonHangById(String maDonHang, String bangChungThanhToan);
     public DonHang getDonHangById(String maDonHang);
}
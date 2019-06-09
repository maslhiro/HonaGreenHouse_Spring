package com.hona.sellingfruit.service;

import com.hona.sellingfruit.entity.DonHang;
import java.util.Date;
import java.util.List;

public interface DonHangService {

    List<DonHang> getAll();

    List<DonHang> getListDonHangByTinhTrang(int tinhTrang);

    List<DonHang> getListDonHangByTinhTrangIsNot(int tinhTrang);

    Integer huyDonHangById(String maDonHang);

    Integer xacNhanDonHangById(String maDonHang, String bangChungThanhToan);

    DonHang getDonHangById(String maDonHang);

    List<DonHang> getListDonHangByNgayDatBetween(Date fromDate, Date toDate);
}

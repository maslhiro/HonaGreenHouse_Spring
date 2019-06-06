package com.hona.sellingfruit.service;

import com.hona.sellingfruit.entity.DonHang;
import com.hona.sellingfruit.repository.DonHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DonHangServiceImpl implements DonHangService{
    @Autowired
    private DonHangRepository donHangRepository;

    @Override
    public List<DonHang> getListDonHangByTinhTrang(int tinhTrang){
        List<DonHang> listDonHang = null;
        List<DonHang> listDonHang_temp = donHangRepository.getAllByTinhTrang(tinhTrang);
        DonHang donHang;

        for (DonHang i:listDonHang_temp
             ) {
            donHang = new DonHang();

            donHang.setMaDonHang(i.getMaDonHang());
            donHang.setNgayDatString(i.getNgayDat().toString());
            donHang.setBangChungThanhToan(i.getBangChungThanhToan());
            donHang.setTinhTrangString(ConvertTinhTrang(i.getTinhTrang()));

            donHang.setTongTien(i.getTongTien());
            donHang.setHoTen(i.getHoTen());
            donHang.setDiaChiNhan(i.getDiaChiNhan());
            donHang.setSoDienThoai(i.getSoDienThoai());
            donHang.setGhiChu(i.getGhiChu());

            listDonHang.add(donHang);
        }

        return listDonHang;
    }

    public String ConvertTinhTrang(int tinhTrang){
        String tinhTrangString="";

        switch (tinhTrang){
            case 0:
                tinhTrangString = "Chờ xác nhận";
                break;
            case 1:
                tinhTrangString = "Hủy";
                break;
            case 2:
                tinhTrangString = "Thành công";
                break;
        }

        return tinhTrangString;
    }
}

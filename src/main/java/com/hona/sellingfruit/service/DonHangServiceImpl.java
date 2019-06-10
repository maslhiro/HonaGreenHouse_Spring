package com.hona.sellingfruit.service;

import com.hona.sellingfruit.entity.DonHang;
import com.hona.sellingfruit.repository.DonHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DonHangServiceImpl implements DonHangService {
    @Autowired
    private DonHangRepository donHangRepository;

    @Override
    public List<DonHang> getListDonHangByTinhTrang(int tinhTrang) {
        return donHangRepository.getAllByTinhTrang(tinhTrang);
    }

    @Override
    public List<DonHang> getAll(){
        return donHangRepository.getAllByMaDonHangIsNot("");
    }


    @Override
    public List<DonHang> getListDonHangByTinhTrangIsNot(int tinhTrang) {
        return donHangRepository.getAllByTinhTrangIsNot(tinhTrang);
    }

    @Override
    public Integer huyDonHangById(String maDonHang) {
        try {
            DonHang donHang = donHangRepository.findById(maDonHang).get();

            donHang.setTinhTrang(1);

            donHangRepository.saveAndFlush(donHang);
            return 0;
        } catch (Exception e) {
            System.out.println(e);
            return 1;
        }
    }

    @Override
    public Integer xacNhanDonHangById(String maDonHang, String bangChungThanhToan) {
        try {
            DonHang donHang = donHangRepository.findById(maDonHang).get();

            donHang.setTinhTrang(2);
            donHang.setBangChungThanhToan(bangChungThanhToan);

            donHangRepository.saveAndFlush(donHang);
            return 0;
        }
        catch (Exception e){
            System.out.println(e);
            return 1;
        }
    }

    @Override
    public DonHang getDonHangById(String maDonHang) {
        return donHangRepository.getByMaDonHang(maDonHang);
    }

    @Override
    public  List<DonHang> getListDonHangByNgayDatBetween(Date fromDate, Date toDate){
        return donHangRepository.getAllByNgayDatBetweenAndTinhTrang(fromDate,toDate,2);
    }

}
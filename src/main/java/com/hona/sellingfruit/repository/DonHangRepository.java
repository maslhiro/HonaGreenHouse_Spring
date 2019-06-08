package com.hona.sellingfruit.repository;

import com.hona.sellingfruit.entity.DonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonHangRepository extends JpaRepository<DonHang, String> {
    List<DonHang> getAllByTinhTrang(int tinhTrang);
    List<DonHang> getAllByTinhTrangIsNot(int tinhTrang);
    DonHang getByMaDonHang(String maDonHang);
}

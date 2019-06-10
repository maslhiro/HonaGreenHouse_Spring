package com.hona.sellingfruit.repository;

import com.hona.sellingfruit.entity.ChiTietDonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ChiTietDonHangRepository extends JpaRepository<ChiTietDonHang, String> {
    List<ChiTietDonHang> getAllByMaDonHang(String maDonHang);
    long countAllByMaChiTietDHIsNot(String maChiTietDonHang);
}
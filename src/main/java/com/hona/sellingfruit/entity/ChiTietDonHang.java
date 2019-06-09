package com.hona.sellingfruit.entity;

import javax.persistence.*;

@Entity
@Table(name = "chi_tiet_don_hang")
public class ChiTietDonHang {

    @Id
    @Column(name = "Ma_Chi_Tiet_DH")
    private String maChiTietDH;

    @Column(name = "So_Luong_Xuat")
    private Integer soLuongXuat;

    @Column(name = "Don_Gia_Xuat")
    private Integer donGiaXuat;

    @Column(name = "Ma_Don_Hang")
    private String maDonHang;

    @JoinColumn(name = "Ma_Trai_Cay", referencedColumnName = "Ma_Trai_Cay", insertable = false, updatable = false)
    @ManyToOne(targetEntity = TraiCay.class)
    private TraiCay traiCay;

    public ChiTietDonHang(){}

    public ChiTietDonHang(String maChiTietDH, Integer soLuongXuat, Integer donGiaXuat, String maDonHang, TraiCay traiCay) {
        this.maChiTietDH = maChiTietDH;
        this.soLuongXuat = soLuongXuat;
        this.donGiaXuat = donGiaXuat;
        this.maDonHang = maDonHang;
        this.traiCay = traiCay;
    }

    public String getMaChiTietDH() {
        return maChiTietDH;
    }

    public void setMaChiTietDH(String maChiTietDH) {
        this.maChiTietDH = maChiTietDH;
    }

    public Integer getSoLuongXuat() {
        return soLuongXuat;
    }

    public void setSoLuongXuat(Integer soLuongXuat) {
        this.soLuongXuat = soLuongXuat;
    }

    public Integer getDonGiaXuat() {
        return donGiaXuat;
    }

    public void setDonGiaXuat(Integer donGiaXuat) {
        this.donGiaXuat = donGiaXuat;
    }

    public String getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(String maDonHang) {
        this.maDonHang = maDonHang;
    }

    public TraiCay getTraiCay() {
        return traiCay;
    }

    public void setTraiCay(TraiCay traiCay) {
        this.traiCay = traiCay;
    }
}
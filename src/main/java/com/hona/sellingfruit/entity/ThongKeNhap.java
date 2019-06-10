package com.hona.sellingfruit.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "log_nhap_tc")
public class ThongKeNhap {

    @Id
    @Column(name = "Auto_ID")
    String autoID;

    @ManyToOne(targetEntity = TraiCay.class)
    @JoinColumn(name = "Ma_trai_Cay")
    TraiCay traiCay;

    @Column(name = "Thoi_Gian")
    Date thoiGian;

    @Column(name = "Tong_Tien_Nhap")
    Integer tongTienNhap;

    @Column(name = "So_Luong_Nhap")
    Integer soLuongNhap;

    @Column(name = "Don_Gia_Nhap")
    Integer donGiaNhap;

    public ThongKeNhap() {
    }

    public ThongKeNhap(String autoID, TraiCay traiCay, Date thoiGian, Integer tongTienNhap, Integer soLuongNhap, Integer donGiaNhap) {
        this.autoID = autoID;
        this.traiCay = traiCay;
        this.thoiGian = thoiGian;
        this.tongTienNhap = tongTienNhap;
        this.soLuongNhap = soLuongNhap;
        this.donGiaNhap = donGiaNhap;
    }

    public String getAutoID() {
        return autoID;
    }

    public void setAutoID(String autoID) {
        this.autoID = autoID;
    }

    public TraiCay getTraiCay() {
        return traiCay;
    }

    public void setTraiCay(TraiCay traiCay) {
        this.traiCay = traiCay;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }

    public Integer getTongTienNhap() {
        return tongTienNhap;
    }

    public void setTongTienNhap(Integer tongTienNhap) {
        this.tongTienNhap = tongTienNhap;
    }

    public Integer getSoLuongNhap() {
        return soLuongNhap;
    }

    public void setSoLuongNhap(Integer soLuongNhap) {
        this.soLuongNhap = soLuongNhap;
    }

    public Integer getDonGiaNhap() {
        return donGiaNhap;
    }

    public void setDonGiaNhap(Integer donGiaNhap) {
        this.donGiaNhap = donGiaNhap;
    }
}

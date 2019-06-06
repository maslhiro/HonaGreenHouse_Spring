package com.hona.sellingfruit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "don_hang")
public class DonHang {
    @Id

    @Column(name = "Ma_Don_Hang")
    private String maDonHang;

    @Column(name = "Ngay_Dat")
    private Date ngayDat;

    @Column(name = "Bang_Chung_Thanh_Toan")
    private String bangChungThanhToan;

    @Column(name = "Tinh_Trang")
    private Integer tinhTrang;

    @Column(name = "Tong_Tien")
    private Float tongTien;

    @Column(name = "Ho_Ten")
    private String hoTen;

    @Column(name = "So_Dien_Thoai")
    private String soDienThoai;

    @Column(name = "Dia_Chi_Nhan")
    private String diaChiNhan;

    @Column(name = "Ghi_Chu")
    private String ghiChu;

    @Column(name = "Ma_Voucher")
    private String maVoucher;

    private String ngayDatString;
    private String tinhTrangString;


    public DonHang(){}

    public DonHang(String maDonHang, Date ngayDat, String bangChungThanhToan, Integer tinhTrang, Float tongTien, String hoTen, String soDienThoai, String diaChiNhan, String ghiChu, String maVoucher, String ngayDatString, String tinhTrangString) {
        this.maDonHang = maDonHang;
        this.ngayDat = ngayDat;
        this.bangChungThanhToan = bangChungThanhToan;
        this.tinhTrang = tinhTrang;
        this.tongTien = tongTien;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.diaChiNhan = diaChiNhan;
        this.ghiChu = ghiChu;
        this.maVoucher = maVoucher;
        this.ngayDatString = ngayDatString;
        this.tinhTrangString = tinhTrangString;
    }

    public String getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(String maDonHang) {
        this.maDonHang = maDonHang;
    }

    public Date getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }

    public String getBangChungThanhToan() {
        return bangChungThanhToan;
    }

    public void setBangChungThanhToan(String bangChungThanhToan) {
        this.bangChungThanhToan = bangChungThanhToan;
    }

    public Integer getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(Integer tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public Float getTongTien() {
        return tongTien;
    }

    public void setTongTien(Float tongTien) {
        this.tongTien = tongTien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChiNhan() {
        return diaChiNhan;
    }

    public void setDiaChiNhan(String diaChiNhan) {
        this.diaChiNhan = diaChiNhan;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getMaVoucher() {
        return maVoucher;
    }

    public void setMaVoucher(String maVoucher) {
        this.maVoucher = maVoucher;
    }

    public String getNgayDatString() {
        return ngayDatString;
    }

    public void setNgayDatString(String ngayDatString) {
        this.ngayDatString = ngayDatString;
    }

    public String getTinhTrangString() {
        return tinhTrangString;
    }

    public void setTinhTrangString(String tinhTrangString) {
        this.tinhTrangString = tinhTrangString;
    }
}

package com.hona.sellingfruit.entity;

import javax.persistence.*;

@Entity
@Table(name = "trai_cay")
public class TraiCay {

    @Id
    @Column(name = "Ma_Trai_Cay")
    private  String maTraiCay ;

    @Column(name = "Ten_Trai_Cay")
    private String tenTraiCay;

    @JoinColumn(name = "Loai_ID")
    @ManyToOne(targetEntity = LoaiTraiCay.class)
    private LoaiTraiCay loaiTraiCay;

    @Column(name = "So_Luong")
    private Integer soLuong;

    @Column(name = "Don_Vi_Tinh")
    private String donViTinh;

    @Column(name = "Xuat_Xu")
    private String xuatXu;

    @Column(name = "Mo_Ta")
    private String moTa;

    @Column(name = "Url_Anh")
    private String urlAnh;

    @Column(name = "Don_Gia_Xuat")
    private Integer donGiaXuat;

    @Column(name = "Don_Gia_Nhap")
    private Integer donGiaNhap;

    @Column(name = "Count")
    private Integer count;

    @Column(name = "Is_Deleted")
    private Integer isDeleted;

    public TraiCay() {
    }

    public TraiCay(String maTraiCay, String tenTraiCay, LoaiTraiCay loaiTraiCay, Integer soLuong, String donViTinh, String xuatXu, String moTa, String urlAnh, Integer donGiaXuat, Integer donGiaNhap, Integer count, Integer isDeleted) {
        this.maTraiCay = maTraiCay;
        this.tenTraiCay = tenTraiCay;
        this.loaiTraiCay = loaiTraiCay;
        this.soLuong = soLuong;
        this.donViTinh = donViTinh;
        this.xuatXu = xuatXu;
        this.moTa = moTa;
        this.urlAnh = urlAnh;
        this.donGiaXuat = donGiaXuat;
        this.donGiaNhap = donGiaNhap;
        this.count = count;
        this.isDeleted = isDeleted;
    }

    public String getMaTraiCay() {
        return maTraiCay;
    }

    public void setMaTraiCay(String maTraiCay) {
        this.maTraiCay = maTraiCay;
    }

    public String getTenTraiCay() {
        return tenTraiCay;
    }

    public void setTenTraiCay(String tenTraiCay) {
        this.tenTraiCay = tenTraiCay;
    }

    public LoaiTraiCay getLoaiTraiCay() {
        return loaiTraiCay;
    }

    public void setLoaiTraiCay(LoaiTraiCay loaiTraiCay) {
        this.loaiTraiCay = loaiTraiCay;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getUrlAnh() {
        return urlAnh;
    }

    public void setUrlAnh(String urlAnh) {
        this.urlAnh = urlAnh;
    }

    public Integer getDonGiaXuat() {
        return donGiaXuat;
    }

    public void setDonGiaXuat(Integer donGiaXuat) {
        this.donGiaXuat = donGiaXuat;
    }

    public Integer getDonGiaNhap() {
        return donGiaNhap;
    }

    public void setDonGiaNhap(Integer donGiaNhap) {
        this.donGiaNhap = donGiaNhap;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}

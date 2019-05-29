package com.hona.sellingfruit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @Column(name = "Auto_ID")
    String auToID;

    @Column(name = "Ten_Dang_Nhap")
    private String tenDangNhap;

    @Column(name = "Mat_Khau")
    private String matKhau;

    public Admin() {
    }

    public Admin(String auToID, String tenDangNhap, String matKhau) {
        this.auToID = auToID;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
    }

    public String getAuToID() {
        return auToID;
    }

    public void setAuToID(String auToID) {
        this.auToID = auToID;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
}

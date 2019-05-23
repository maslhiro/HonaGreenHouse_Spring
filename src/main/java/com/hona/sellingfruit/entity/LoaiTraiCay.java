package com.hona.sellingfruit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loai_trai_cay")
public class LoaiTraiCay {

    @Id
    @Column(name = "Ma_Loai_Trai_Cay")
    private String maLoaiTraiCay;

    @Column(name = "Ten_Loai_Trai_Cay")
    private String tenLoaiTraiCay;

    public LoaiTraiCay(String maLoaiTraiCay, String tenLoaiTraiCay) {
        this.maLoaiTraiCay = maLoaiTraiCay;
        this.tenLoaiTraiCay = tenLoaiTraiCay;
    }

    public LoaiTraiCay() {
    }

    public String getMaLoaiTraiCay() {
        return maLoaiTraiCay;
    }

    public void setMaLoaiTraiCay(String maLoaiTraiCay) {
        this.maLoaiTraiCay = maLoaiTraiCay;
    }

    public String getTenLoaiTraiCay() {
        return tenLoaiTraiCay;
    }

    public void setTenLoaiTraiCay(String tenLoaiTraiCay) {
        this.tenLoaiTraiCay = tenLoaiTraiCay;
    }
}

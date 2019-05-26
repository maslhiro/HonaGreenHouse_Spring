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

    @Column(name = "Is_Deleted")
    private Integer isDeleted;

    public LoaiTraiCay() {
    }

    public LoaiTraiCay(String maLoaiTraiCay, String tenLoaiTraiCay, Integer isDeleted) {
        this.maLoaiTraiCay = maLoaiTraiCay;
        this.tenLoaiTraiCay = tenLoaiTraiCay;
        this.isDeleted = isDeleted;
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

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}

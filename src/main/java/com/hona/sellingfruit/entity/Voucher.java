package com.hona.sellingfruit.entity;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "voucher")
public class Voucher {

    @Id
    @Column(name = "Auto_ID")
    private  String autoID ;

    @Column(name = "Ma_Giam_Gia")
    private String maGiamGia;

    @Column(name = "Phan_Tram_Giam")
    private Integer phanTramGiam;

    @Column(name = "So_Lan_Su_Dung")
    private Integer soLanSuDung;

    @Column(name = "So_Lan_Su_Dung_Toi_Da")
    private Integer soLanSuDungToiDa;

    @Column(name = "Tien_Giam_Toi_Da")
    private Integer tienGiamToiDa;

    @Column(name = "Trang_Thai")
    private Integer trangThai;

    public Voucher() {
    }

    public Voucher(String autoID, String maGiamGia, Integer phanTramGiam, Integer soLanSuDung, Integer soLanSuDungToiDa, Integer tienGiamToiDa, Integer trangThai) {
        this.autoID = autoID;
        this.maGiamGia = maGiamGia;
        this.phanTramGiam = phanTramGiam;
        this.soLanSuDung = soLanSuDung;
        this.soLanSuDungToiDa = soLanSuDungToiDa;
        this.tienGiamToiDa = tienGiamToiDa;
        this.trangThai = trangThai;
    }

    public String getAutoID() {
        return autoID;
    }

    public void setAutoID(String autoID) {
        this.autoID = autoID;
    }

    public String getMaGiamGia() {
        return maGiamGia;
    }

    public void setMaGiamGia(String maGiamGia) {
        this.maGiamGia = maGiamGia;
    }

    public Integer getPhanTramGiam() {
        return phanTramGiam;
    }

    public void setPhanTramGiam(Integer phanTramGiam) {
        this.phanTramGiam = phanTramGiam;
    }

    public Integer getSoLanSuDung() {
        return soLanSuDung;
    }

    public void setSoLanSuDung(Integer soLanSuDung) {
        this.soLanSuDung = soLanSuDung;
    }

    public Integer getSoLanSuDungToiDa() {
        return soLanSuDungToiDa;
    }

    public void setSoLanSuDungToiDa(Integer soLanSuDungToiDa) {
        this.soLanSuDungToiDa = soLanSuDungToiDa;
    }

    public Integer getTienGiamToiDa() {
        return tienGiamToiDa;
    }

    public void setTienGiamToiDa(Integer tienGiamToiDa) {
        this.tienGiamToiDa = tienGiamToiDa;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }
}



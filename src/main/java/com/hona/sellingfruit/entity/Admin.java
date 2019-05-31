package com.hona.sellingfruit.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "admin")
public class Admin implements UserDetails {

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return authorities;    }

    @Override
    public String getPassword() {
        return matKhau;
    }

    @Override
    public String getUsername() {
        return tenDangNhap;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

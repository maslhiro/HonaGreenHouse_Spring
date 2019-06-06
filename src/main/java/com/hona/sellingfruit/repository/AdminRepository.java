package com.hona.sellingfruit.repository;

import com.hona.sellingfruit.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, String> {
    Admin findByTenDangNhap(String tenDangNhap);

}

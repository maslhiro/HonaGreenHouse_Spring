package com.hona.sellingfruit.service;

import com.hona.sellingfruit.entity.Admin;

public interface AdminService {
    Admin findAdminByTenDangNhap(String tenDangNhap);
}

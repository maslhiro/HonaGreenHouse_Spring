package com.hona.sellingfruit.service;

import com.hona.sellingfruit.entity.Admin;
import com.hona.sellingfruit.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository;

    @Override
    public  Admin findAdminByTenDangNhap(String tenDangNhap){
        return adminRepository.findByTenDangNhap(tenDangNhap);
    }

}

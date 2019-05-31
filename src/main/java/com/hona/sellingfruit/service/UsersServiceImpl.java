package com.hona.sellingfruit.service;

import com.hona.sellingfruit.entity.Users;
import com.hona.sellingfruit.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepository usersRepository ;

    @Override
    public Users getUserByTenDangNhap(String tenDangNhap){
        return  usersRepository.findByTenDangNhap(tenDangNhap);
    }
}

package com.hona.sellingfruit.service;

import com.hona.sellingfruit.entity.Users;
import com.hona.sellingfruit.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Users findUsersByTenDangNhap(String tenDangNhap){
        return usersRepository.findByTenDangNhap(tenDangNhap);
    }

}

package com.hona.sellingfruit.repository;

import com.hona.sellingfruit.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, String> {
    Users findByTenDangNhap(String tenDangNhap);
}

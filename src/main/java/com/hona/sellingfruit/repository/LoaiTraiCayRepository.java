package com.hona.sellingfruit.repository;

import com.hona.sellingfruit.entity.LoaiTraiCay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiTraiCayRepository extends JpaRepository<LoaiTraiCay, String> {
}

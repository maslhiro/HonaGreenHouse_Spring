package com.hona.sellingfruit.repository;

import com.hona.sellingfruit.entity.LoaiTraiCay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoaiTraiCayRepository extends JpaRepository<LoaiTraiCay, String> {
    List<LoaiTraiCay> findAllByIsDeleted(int isDeleted);

    LoaiTraiCay getLoaiTraiCayByMaLoaiTraiCay(String maLoai);
}

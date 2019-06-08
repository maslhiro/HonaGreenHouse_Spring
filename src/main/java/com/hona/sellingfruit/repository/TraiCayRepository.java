package com.hona.sellingfruit.repository;

import com.hona.sellingfruit.entity.LoaiTraiCay;
import com.hona.sellingfruit.entity.TraiCay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TraiCayRepository  extends JpaRepository<TraiCay, String> {
    List<TraiCay> findAllByIsDeleted(int isDeleted);
    List<TraiCay> findAllByIsDeletedOrderByCountDesc(int isDeleted);
    List<TraiCay> findAllByIsDeletedAndLoaiTraiCay(int isDeleted, LoaiTraiCay loaiTraiCay);
    long count();
}
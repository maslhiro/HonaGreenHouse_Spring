package com.hona.sellingfruit.repository;

import com.hona.sellingfruit.entity.TraiCay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraiCayRepository  extends JpaRepository<TraiCay, String> {
}
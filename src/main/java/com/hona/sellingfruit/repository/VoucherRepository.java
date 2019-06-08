package com.hona.sellingfruit.repository;
import com.hona.sellingfruit.entity.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoucherRepository  extends JpaRepository<Voucher, String> {
    List<Voucher> findAll();
    Voucher getVoucherByMaGiamGia(String maGiamGia);
    long count();
}
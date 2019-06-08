package com.hona.sellingfruit.repository;

import com.hona.sellingfruit.entity.ThongKeNhap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ThongKeNhapRepository  extends JpaRepository<ThongKeNhap,String> {
    long count();

    List<ThongKeNhap> findAllByThoiGianBetween(Date fromDate, Date toDate);

    @Query(value = "SELECT SUM(Tong_Tien_Nhap)FROM LOG_NHAP_TC",nativeQuery = true)

    double sumTongTienNhap();
}

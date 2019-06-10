package com.hona.sellingfruit.service;

import com.hona.sellingfruit.entity.ThongKeNhap;

import java.util.Date;
import java.util.List;

public interface ThongKeNhapService {
    List<ThongKeNhap> getAll();

    List<ThongKeNhap> getAllByDate(Date fromDate , Date toDate);

    Double getTongTien();
}

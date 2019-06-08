package com.hona.sellingfruit.service;

import com.hona.sellingfruit.entity.LoaiTraiCay;
import java.util.List;

public interface LoaiTraiCayService {
     List<LoaiTraiCay> getAllLoaiTraiCayList();

     Integer insertLoaiTraiCay(LoaiTraiCay loaiTraiCay);

     long countAllLoaiTraiCay();

     Integer updateLoaiTraiCay(LoaiTraiCay loaiTraiCay);

     Integer deleteLoaiTraiCayById(String maLoai);

     LoaiTraiCay getLoaiTraiCayById(String maLoai);
}

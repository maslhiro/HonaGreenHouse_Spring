package com.hona.sellingfruit.service;

import com.hona.sellingfruit.entity.LoaiTraiCay;
import java.util.List;

public interface LoaiTraiCayService {
     List<LoaiTraiCay> getAllLoaiTraiCayList();


     LoaiTraiCay getLoaiTraiCayById(String maLoai);
}

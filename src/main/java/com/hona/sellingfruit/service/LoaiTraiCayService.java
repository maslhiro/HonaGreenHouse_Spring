package com.hona.sellingfruit.service;

import com.hona.sellingfruit.entity.LoaiTraiCay;
import java.util.List;

public interface LoaiTraiCayService {
    public List<LoaiTraiCay> getAllLoaiTraiCayList();


    public LoaiTraiCay getLoaiTraiCayById(String maLoai);
}

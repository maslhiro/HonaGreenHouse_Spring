package com.hona.sellingfruit.service;

import com.hona.sellingfruit.entity.LoaiTraiCay;
import com.hona.sellingfruit.entity.TraiCay;

import java.util.List;

public interface TraiCayService {
     List<TraiCay> getAllTraiCayList();

     TraiCay getTraiCayById(String maTraiCay);

     Integer insertTraiCay(TraiCay traiCay);

     long countAllTraiCay();

     Integer updateTraiCay(TraiCay traiCay);

     Integer deleteTraiCayById(String maTraiCay);

    public List<TraiCay> getTraiCayBanChayList();

    public List<TraiCay> getTraiCayByLoaiList(LoaiTraiCay loaiTraiCay);

}

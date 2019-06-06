package com.hona.sellingfruit.service;

import com.hona.sellingfruit.entity.LoaiTraiCay;
import com.hona.sellingfruit.entity.TraiCay;

import java.util.List;

public interface TraiCayService {
    public List<TraiCay> getAllTraiCayList();

    public TraiCay getTraiCayById(String maTraiCay);

    public Integer insertTraiCay(TraiCay traiCay);

    public long countAllTraiCay();

    public Integer updateTraiCay(TraiCay traiCay);

    public Integer deleteTraiCayById(String maTraiCay);

    public List<TraiCay> getTraiCayBanChayList();

    public List<TraiCay> getTraiCayByLoaiList(LoaiTraiCay loaiTraiCay);

}

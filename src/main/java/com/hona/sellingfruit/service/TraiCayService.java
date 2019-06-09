package com.hona.sellingfruit.service;

import com.hona.sellingfruit.entity.LoaiTraiCay;
import com.hona.sellingfruit.entity.TraiCay;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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

    //HaiTho upcode hỗ trợ Map và session bean
    Page<TraiCay> findAllTraiCayPageable(Pageable pageable);

}

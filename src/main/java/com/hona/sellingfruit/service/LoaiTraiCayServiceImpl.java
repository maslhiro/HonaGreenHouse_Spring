package com.hona.sellingfruit.service;

import com.hona.sellingfruit.entity.LoaiTraiCay;
import com.hona.sellingfruit.repository.LoaiTraiCayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaiTraiCayServiceImpl implements LoaiTraiCayService{
    @Autowired
    private LoaiTraiCayRepository loaiTraiCayRepository;

    @Override
    public List<LoaiTraiCay> getAllLoaiTraiCayList(){
        return loaiTraiCayRepository.findAllByIsDeleted(0);
    }

    @Override
    public  LoaiTraiCay getLoaiTraiCayById(String maLoai){
        return loaiTraiCayRepository.getLoaiTraiCayByMaLoaiTraiCay(maLoai);
    }
}

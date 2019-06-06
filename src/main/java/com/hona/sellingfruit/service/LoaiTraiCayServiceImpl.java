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

    @Override
    public Integer insertLoaiTraiCay(LoaiTraiCay loaiTraiCay){
        try {
            loaiTraiCayRepository.saveAndFlush(loaiTraiCay);
            return  0;
        }
        catch (Exception e)
        {
            System.out.println(e);
            return  1;
        }
    }

    @Override
    public long countAllLoaiTraiCay(){
        return loaiTraiCayRepository.count();
    }

    @Override
    public Integer updateLoaiTraiCay(LoaiTraiCay loaiTraiCay){
        try{
            loaiTraiCayRepository.saveAndFlush(loaiTraiCay);
            return 0;
        }
        catch (Exception e){
            System.out.println(e);
            return  1;        }
    }

    @Override
    public Integer deleteLoaiTraiCayById(String maLoai){
        try{
            LoaiTraiCay loaiTraiCay = loaiTraiCayRepository.findById(maLoai).get();

            loaiTraiCay.setIsDeleted(1);

            loaiTraiCayRepository.saveAndFlush(loaiTraiCay);
            return 0;
        }
        catch (Exception e){
            System.out.println(e);
            return 1;
        }
    }
}

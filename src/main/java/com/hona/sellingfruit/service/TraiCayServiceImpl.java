package com.hona.sellingfruit.service;

import com.hona.sellingfruit.entity.LoaiTraiCay;
import com.hona.sellingfruit.entity.TraiCay;
import com.hona.sellingfruit.repository.TraiCayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraiCayServiceImpl implements TraiCayService {

    @Autowired
    private TraiCayRepository traiCayRepository;

    @Override
    public List<TraiCay> getAllTraiCayList(){
        return traiCayRepository.findAllByIsDeleted(0);
    }

    @Override
    public TraiCay getTraiCayById(String maTraiCay){
        return traiCayRepository.findById(maTraiCay).get();
    }

    @Override
    public Integer insertTraiCay(TraiCay traiCay){
        try {
            traiCayRepository.saveAndFlush(traiCay);
            return  0;
        }
        catch (Exception e)
        {
            System.out.println(e);
            return  1;
        }
    }

    @Override
    public long countAllTraiCay(){
        return traiCayRepository.count();
    }

    @Override
    public Integer updateTraiCay(TraiCay traiCay){
        try{
            traiCayRepository.saveAndFlush(traiCay);
            return 0;
        }
        catch (Exception e){
            System.out.println(e);
            return  1;        }
    }

    @Override
    public Integer deleteTraiCayById(String maTraiCay){
        try{
            TraiCay traiCay = traiCayRepository.findById(maTraiCay).get();

            traiCay.setIsDeleted(1);

            traiCayRepository.saveAndFlush(traiCay);
            return 0;
        }
        catch (Exception e){
            System.out.println(e);
            return 1;
        }
    }

    @Override
    public List<TraiCay> getTraiCayBanChayList() {
        return traiCayRepository.findAllByIsDeletedOrderByCountDesc(0);
    }

    @Override
    public List<TraiCay> getTraiCayByLoaiList(LoaiTraiCay loaiTraiCay){
        return traiCayRepository.findAllByIsDeletedAndLoaiTraiCay(0, loaiTraiCay);
    }
    //HaiTho upcode Map và session bean
    @Override
    public Page<TraiCay> findAllTraiCayPageable(Pageable pageable) {
        return traiCayRepository.findAll(pageable);
    }

}

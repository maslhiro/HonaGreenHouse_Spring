package com.hona.sellingfruit.service;

import com.hona.sellingfruit.entity.ThongKeNhap;
import com.hona.sellingfruit.repository.ThongKeNhapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ThongKeNhapServiceImpl implements ThongKeNhapService {

    @Autowired
    ThongKeNhapRepository thongKeNhapRepository;

    @Override
    public List<ThongKeNhap> getAll(){
        return thongKeNhapRepository.findAll();
    }

    @Override
    public List<ThongKeNhap> getAllByDate(Date fromDate , Date toDate){
        return thongKeNhapRepository.findAllByThoiGianBetween(fromDate,toDate);
    }

    @Override
    public Double getTongTien(){
        return  thongKeNhapRepository.sumTongTienNhap();
    }

}

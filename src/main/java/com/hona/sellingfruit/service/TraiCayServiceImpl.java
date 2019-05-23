package com.hona.sellingfruit.service;

import com.hona.sellingfruit.entity.TraiCay;
import com.hona.sellingfruit.repository.TraiCayRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}

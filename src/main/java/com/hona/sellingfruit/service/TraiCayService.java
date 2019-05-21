package com.hona.sellingfruit.service;

import com.hona.sellingfruit.entity.TraiCay;

import java.util.List;

public interface TraiCayService {
    public List<TraiCay> getAllTraiCayList();

    public TraiCay getTraiCayById(String maTraiCay);
}

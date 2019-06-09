package com.hona.sellingfruit.untils;


import com.hona.sellingfruit.entity.TraiCay;
import org.springframework.data.domain.Page;

public class Pager {

    private final Page<TraiCay> traiCays;

    public Pager(Page<TraiCay> traiCays) {
        this.traiCays = traiCays;
    }

    public int getPageIndex() {
        return traiCays.getNumber() + 1;
    }

    public int getPageSize() {
        return traiCays.getSize();
    }

    public boolean hasNext() {
        return traiCays.hasNext();
    }

    public boolean hasPrevious() {
        return traiCays.hasPrevious();
    }

    public int getTotalPages() {
        return traiCays.getTotalPages();
    }

    public long getTotalElements() {
        return traiCays.getTotalElements();
    }

    public boolean indexOutOfBounds() {
        return this.getPageIndex() < 0 || this.getPageIndex() > this.getTotalElements();
    }

}
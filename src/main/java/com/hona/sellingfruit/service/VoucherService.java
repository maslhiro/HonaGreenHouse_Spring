package com.hona.sellingfruit.service;

import com.hona.sellingfruit.entity.Voucher;

import java.util.List;

public interface VoucherService{
    public List<Voucher> getAllVoucherList();

    public Voucher getVoucherById(String autoID);

    public Voucher getVoucherByMaGiamGia(String maGiamGia);

    public Integer insertVoucher(Voucher voucher);

    public long countAllVoucher();

    public Integer updateVoucher(Voucher voucher);

    public Integer huyVoucher(String autoID);
}

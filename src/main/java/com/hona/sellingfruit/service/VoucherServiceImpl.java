package com.hona.sellingfruit.service;

import com.hona.sellingfruit.entity.Voucher;
import com.hona.sellingfruit.repository.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoucherServiceImpl implements VoucherService {

    @Autowired
    private VoucherRepository voucherRepository;

    @Override
    public List<Voucher> getAllVoucherList(){
        return voucherRepository.findAll();
    }

    @Override
    public Voucher getVoucherById(String autoID){
        return voucherRepository.findById(autoID).get();
    }

    @Override
    public Voucher getVoucherByMaGiamGia(String maGiamGia){
        return voucherRepository.getVoucherByMaGiamGia((maGiamGia));
    }

    @Override
    public Integer insertVoucher(Voucher voucher){
        try {
            voucherRepository.saveAndFlush(voucher);
            return  0;
        }
        catch (Exception e)
        {
            System.out.println(e);
            return  1;
        }
    }

    @Override
    public long countAllVoucher(){
        return voucherRepository.count();
    }

    @Override
    public Integer updateVoucher(Voucher voucher){
        try{
            voucherRepository.saveAndFlush(voucher);
            return 0;
        }
        catch (Exception e){
            System.out.println(e);
            return  1;        }
    }

    @Override
    public Integer huyVoucher(String autoID){
        try {
            Voucher voucher =  voucherRepository.findById(autoID).get();
            voucher.setTrangThai(1);

            voucherRepository.saveAndFlush(voucher);
            return 0;
        }catch (Exception ex)
        {
            System.out.println(ex);
            return 1;
        }

    }


}

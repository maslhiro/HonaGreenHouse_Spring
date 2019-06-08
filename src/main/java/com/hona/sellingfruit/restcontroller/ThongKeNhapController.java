package com.hona.sellingfruit.restcontroller;


import com.hona.sellingfruit.entity.ThongKeNhap;
import com.hona.sellingfruit.service.ThongKeNhapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RequestMapping("/Api")
@RestController
public class ThongKeNhapController {
    @Autowired
    ThongKeNhapService thongKeNhapService;

    @GetMapping("/GetListThongKeNhap")
    public List<ThongKeNhap> getListThongKeNhap(){
        return thongKeNhapService.getAll();
    }

    @GetMapping("/GetListThongKeNhapByDate")
    public Object getListThongKeNhapByDate(@RequestParam(name = "From_Date") String fromDate, @RequestParam(name = "To_Date") String toDate)
    {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date from = dateFormat.parse(fromDate);
            Date to = dateFormat.parse(toDate);
            return thongKeNhapService.getAllByDate(from,to);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
            return null;
        }

    }

    @GetMapping("/TongTienListThongKeNhap")
    public double tongTien(){
        return thongKeNhapService.getTongTien();
    }
}

package com.hona.sellingfruit.controller;

import com.hona.sellingfruit.entity.TraiCay;
import com.hona.sellingfruit.service.LoaiTraiCayService;
import com.hona.sellingfruit.service.TraiCayService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/Api")
public class RestApiTraiCayController {
    @Autowired
    private TraiCayService traiCayService;

    @Autowired
    private LoaiTraiCayService loaiTraiCayService;

    @RequestMapping(path="/GetListTraiCay", method= RequestMethod.GET)
    public List<TraiCay> getAllTraiCay(){
        return traiCayService.getAllTraiCayList();
    }

    @RequestMapping(path="/GetTraiCayById", method= RequestMethod.GET)
    public TraiCay getTraiCayById(@RequestParam(value="maTraiCay") String maTraiCay){
        return traiCayService.getTraiCayById(maTraiCay);
    }

    @RequestMapping(path="/InsertTraiCay", method= RequestMethod.POST)
    public String insertTraiCay(@RequestBody String strTraiCay){
        JSONObject traiCay = new JSONObject(strTraiCay);

        // Kiem tra du lieu json co du ko ?
        String check = checkInput(traiCay);

        if(check != ""){
            return  "Vui lòng nhập " +check;
        }

//        int addTraiCay = traiCayService.insertTraiCay();

        return  traiCay.toString();
    }


    String checkInput(JSONObject traiCay){
        String result ="";

        if(traiCay.get("tenTraiCay")=="")
        {
            result += " Tên trái cây,";
        }
        if((Integer)traiCay.get("soLuong")==0)
        {
            result += " Số lượng,";
        }
        if((Integer)traiCay.get("donGia")==0)
        {
            result += " Đơn giá,";
        }
        if(traiCay.get("donViTinh")=="")
        {
            result += " Đơn vị tính ";
        }

        result = result.substring(0,result.length()-1);

        return result;

    }

    TraiCay jsonToEntity(JSONObject json){

        String tenTraiCay = (String) json.get("tenTraiCay");
        String maTraiCay = (String) json.get("maTraiCay");
        String xuatXu = (String) json.get("xuatXu");
        String moTa = (String) json.get("moTa");
        String loaiTraiCay = (String) json.get("loaiTraiCay");
        String donViTinh = (String) json.get("donViTinh");
        Integer soLuong = (Integer) json.get("soLuong");
        Integer donGia = (Integer) json.get("donGia");


        return null;
    }
}

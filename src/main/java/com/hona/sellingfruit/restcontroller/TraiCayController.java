package com.hona.sellingfruit.restcontroller;

import com.hona.sellingfruit.entity.LoaiTraiCay;
import com.hona.sellingfruit.entity.TraiCay;
import com.hona.sellingfruit.service.LoaiTraiCayService;
import com.hona.sellingfruit.service.TraiCayService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/Api")
public class TraiCayController {
    @Autowired
    private TraiCayService traiCayService;

    @Autowired
    private LoaiTraiCayService loaiTraiCayService;

    @GetMapping(path="/GetListTraiCay")
    public List<TraiCay> getAllTraiCay(){
        return traiCayService.getAllTraiCayList();
    }

    @GetMapping(path="/GetTraiCayById")
    public TraiCay getTraiCayById(@RequestParam(value="maTraiCay") String maTraiCay){
        return traiCayService.getTraiCayById(maTraiCay);
    }

    @PostMapping(path="/InsertTraiCay")
    @ResponseStatus(HttpStatus.OK)
    public String insertTraiCay(@RequestBody String stringJSON){
        JSONObject jsonObject = new JSONObject(stringJSON);

        // Kiem tra du lieu json co du ko ?
        String check = checkInput((jsonObject));

        if(check != ""){
            return  "Vui lòng nhập" +check;
        }

        TraiCay traiCay = jsonToEntity(jsonObject);

        Integer ma = Math.toIntExact(traiCayService.countAllTraiCay());
        String maTraiCay = "TC" + String.format("%03d",ma);
        traiCay.setMaTraiCay(maTraiCay);

        Integer result = traiCayService.insertTraiCay(traiCay);
        if(result == 1 )return  "Lỗi kết nối cơ sở dữ liệu";
        return  "";
    }

    @PostMapping(path="/UpdateTraiCay")
    public String updateTraiCay(@RequestBody String stringJSON){
        JSONObject jsonObject = new JSONObject(stringJSON);

        // Kiem tra du lieu json co du ko ?
        String check = checkInput((jsonObject));

        if(check != ""){
            return  "Vui lòng nhập" +check;
        }

        TraiCay traiCay = jsonToEntity(jsonObject);

        String maTraiCay = (String) jsonObject.get("maTraiCay");
        traiCay.setMaTraiCay(maTraiCay);

        Integer result = traiCayService.updateTraiCay(traiCay);
        if(result == 1 )return  "Lỗi kết nối cơ sở dữ liệu";
        return  "";
    }

    @GetMapping(path="/DeleteTraiCay")
    @ResponseStatus(HttpStatus.OK)
    public Integer deleteTraiCayById(@RequestParam(value="maTraiCay") String maTraiCay){
        return traiCayService.deleteTraiCayById(maTraiCay);
    }

    String checkInput(JSONObject traiCay){
        String result ="";
        String tenTraiCay = (String) traiCay.get("tenTraiCay");
        String strMaLoaiTraiCay = (String) traiCay.get("loaiTraiCay");
        String donViTinh = (String) traiCay.get("donViTinh");
        Integer soLuong = (Integer) traiCay.get("soLuong");
        Integer donGia = (Integer) traiCay.get("donGia");

        if(tenTraiCay.isEmpty())
        {
            result += " Tên trái cây,";
        }
        if(soLuong==0)
        {
            result += " Số lượng,";
        }
        if(donGia==0)
        {
            result += " Đơn giá,";
        }
        if(donViTinh.isEmpty())
        {
            result += " Đơn vị tính ";
        }
        if(!result.isEmpty()) result = result.substring(0,result.length()-1);

        return result;

    }

    TraiCay jsonToEntity(JSONObject json){

        if (json == null) return null;

        String tenTraiCay = (String) json.get("tenTraiCay");
        String xuatXu = (String) json.get("xuatXu");
        String strMaLoaiTraiCay = (String) json.get("loaiTraiCay");
        String donViTinh = (String) json.get("donViTinh");
        Integer soLuong = (Integer) json.get("soLuong");
        Integer donGia = (Integer) json.get("donGia");

        TraiCay traiCay = new TraiCay();
        LoaiTraiCay loaiTraiCay = loaiTraiCayService.getLoaiTraiCayById(strMaLoaiTraiCay);

        traiCay.setTenTraiCay(tenTraiCay);
        traiCay.setXuatXu(xuatXu);
        traiCay.setLoaiTraiCay(loaiTraiCay);
        traiCay.setDonViTinh(donViTinh);
        traiCay.setSoLuong(soLuong);
        traiCay.setDonGia(donGia);

        traiCay.setCount(0);
        traiCay.setIsDeleted(0);

        return traiCay;
    }
}

package com.hona.sellingfruit.restcontroller;

import com.hona.sellingfruit.entity.LoaiTraiCay;
import com.hona.sellingfruit.service.LoaiTraiCayService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Api")
public class LoaiTraiCayController {
    @Autowired
    private LoaiTraiCayService loaiTraiCayService;

    @RequestMapping(path="/GetListLoaiTraiCay", method= RequestMethod.GET)
    public List<LoaiTraiCay> getAllLoaiTraiCay(){
        return loaiTraiCayService.getAllLoaiTraiCayList();
    }

    @RequestMapping(path="/GetLoaiTraiCayById", method= RequestMethod.GET)
    public LoaiTraiCay getLoaiTraiCayById(@RequestParam(value="maLoai") String maLoai){
        return loaiTraiCayService.getLoaiTraiCayById(maLoai);
    }

    @PostMapping(path="/InsertLoaiTraiCay")
    @ResponseStatus(HttpStatus.OK)
    public String insertLoaiTraiCay(@RequestBody String stringJSON){
        JSONObject jsonObject = new JSONObject(stringJSON);

        // Kiem tra du lieu json co du ko ?
        String check = checkInput((jsonObject));

        if(!check.isEmpty()){
            return  "Vui lòng nhập" +check;
        }

        LoaiTraiCay loaiTraiCay = jsonToEntity(jsonObject);

        Integer ma = Math.toIntExact(loaiTraiCayService.countAllLoaiTraiCay());
        String maLoaiTraiCay = "LTC" + String.format("%02d",ma);
        loaiTraiCay.setMaLoaiTraiCay(maLoaiTraiCay);

        Integer result = loaiTraiCayService.insertLoaiTraiCay(loaiTraiCay);
        if(result == 1 )return  "Lỗi kết nối cơ sở dữ liệu";
        return  "";
    }

    @PostMapping(path="/UpdateLoaiTraiCay")
    public String updateLoaiTraiCay(@RequestBody String stringJSON){
        JSONObject jsonObject = new JSONObject(stringJSON);

        // Kiem tra du lieu json co du ko ?
        String check = checkInput((jsonObject));

        if(!check.isEmpty()){
            return  "Vui lòng nhập" +check;
        }

        LoaiTraiCay loaiTraiCay = jsonToEntity(jsonObject);

        String maLoaiTraiCay = (String) jsonObject.get("maLoaiTraiCay");
        loaiTraiCay.setMaLoaiTraiCay(maLoaiTraiCay);

        Integer result = loaiTraiCayService.updateLoaiTraiCay(loaiTraiCay);
        if(result == 1 )return  "Lỗi kết nối cơ sở dữ liệu";
        return  "";
    }

    @GetMapping(path="/DeleteLoaiTraiCay")
    @ResponseStatus(HttpStatus.OK)
    public Integer deleteLoaiTraiCayById(@RequestParam(value="maLoai") String maLoai){
        return loaiTraiCayService.deleteLoaiTraiCayById(maLoai);
    }

    String checkInput(JSONObject loaiTraiCay){
        String result ="";
        String tenLoaiTraiCay = (String) loaiTraiCay.get("tenLoaiTraiCay");

        if(tenLoaiTraiCay.isEmpty())
        {
            result += " Tên loại trái cây,";
        }

        return result;

    }

    LoaiTraiCay jsonToEntity(JSONObject json){

        if (json == null) return null;

        String tenLoaiTraiCay = (String) json.get("tenLoaiTraiCay");

        LoaiTraiCay loaiTraiCay = new LoaiTraiCay();

        loaiTraiCay.setTenLoaiTraiCay(tenLoaiTraiCay);
        loaiTraiCay.setIsDeleted(0);

        return loaiTraiCay;
    }
}

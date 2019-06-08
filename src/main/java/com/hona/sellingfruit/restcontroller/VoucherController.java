package com.hona.sellingfruit.restcontroller;

import com.hona.sellingfruit.entity.Voucher;
import com.hona.sellingfruit.service.VoucherService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Random;


@RestController
@RequestMapping(path = "/Api")
public class VoucherController {
    @Autowired
    private VoucherService voucherService;

    @GetMapping(path="/GetListVoucher")
    public List<Voucher> getAllVoucher(){
        return voucherService.getAllVoucherList();
    }

    @GetMapping(path="/GetVoucherById")
    public Voucher getVoucherById(@RequestParam(value="autoID") String autoID){
        return voucherService.getVoucherById(autoID);
    }
    @GetMapping(path="/GetVoucherByMaGiamGia")
    public Voucher getVoucherByMaGiamGia(@RequestParam(value="maGiamGia") String maGiamGia){
        return voucherService.getVoucherByMaGiamGia(maGiamGia);
    }

    @PostMapping(path="/InsertVoucher")
    @ResponseStatus(HttpStatus.OK)
    public String insertVoucher(@RequestBody String stringJSON){
        JSONObject jsonObject = new JSONObject(stringJSON);

        // Kiem tra du lieu json co du ko ?
        String check = checkInput((jsonObject));

        if(check != ""){
            return  "Vui lòng nhập" +check;
        }

        Voucher voucher = jsonToEntity(jsonObject);

        Integer ma = Math.toIntExact(voucherService.countAllVoucher());
        String autoID = "VC" + String.format("%03d",ma+1);
        voucher.setAutoID(autoID);
        // Tạo mã voucher và check xem nó có tồn tại dưới db chưa
        String codeVoucher="";
        do{
                codeVoucher=CreateVoucher(6);
        }while(voucherService.getVoucherByMaGiamGia(codeVoucher)!=null);
        voucher.setMaGiamGia(codeVoucher);
        Integer result = voucherService.insertVoucher(voucher);
        if(result == 1 )return  "Lỗi kết nối cơ sở dữ liệu";
        return  "";
    }

    @PostMapping(path="/UpdateVoucher")
    public String updateVoucher(@RequestBody String stringJSON){
        JSONObject jsonObject = new JSONObject(stringJSON);

        // Kiem tra du lieu json co du ko ?
        String check = checkInput((jsonObject));

        if(check != ""){
            return  "Vui lòng nhập" +check;
        }

        Voucher voucher = jsonToEntity(jsonObject);

        String autoID = (String) jsonObject.get("autoID");
        voucher.setAutoID(autoID);

        Integer result = voucherService.updateVoucher(voucher);
        if(result == 1 )return  "Lỗi kết nối cơ sở dữ liệu";
        return  "";
    }


    String checkInput(JSONObject voucher){
        String result ="";
        String maGiamGia = (String) voucher.get("maGiamGia");
        Integer phanTramGiam = (Integer) voucher.get("phanTramGiam");
        Integer soLanSuDung = (Integer) voucher.get("soLanSuDung");
        Integer soLanSuDungToiDa = (Integer) voucher.get("soLanSuDungToiDa");
        Integer tienGiamToiDa = (Integer) voucher.get("tienGiamToiDa");
        Integer trangThai = (Integer) voucher.get("trangThai");

        if(phanTramGiam==0||phanTramGiam>100)
        {
            result += " Phần trăm giảm,";
        }
        if(soLanSuDungToiDa==0)
        {
            result += " Số lần sử dụng tối đa,";
        }
        if(tienGiamToiDa==0)
        {
            result += " Tiền giảm tối đa,";
        }
        if(trangThai!=0 && trangThai!=1)
        {
            result += " Trạng thái,";
        }

              if(!result.isEmpty()) result = result.substring(0,result.length()-1);

        return result;

    }

    Voucher jsonToEntity(JSONObject json){

        if (json == null) return null;

        String maGiamGia = (String) json.get("maGiamGia");
        Integer phanTramGiam = (Integer) json.get("phanTramGiam");
        Integer soLanSuDung = (Integer) json.get("soLanSuDung");
        Integer soLanSuDungToiDa = (Integer) json.get("soLanSuDungToiDa");
        Integer tienGiamToiDa = (Integer) json.get("tienGiamToiDa");
        Integer trangThai = (Integer) json.get("trangThai");

        Voucher voucher = new Voucher();
        voucher.setMaGiamGia(maGiamGia);
        voucher.setPhanTramGiam(phanTramGiam);
        voucher.setSoLanSuDung(soLanSuDung);
        voucher.setSoLanSuDungToiDa(soLanSuDungToiDa);
        voucher.setTienGiamToiDa(tienGiamToiDa);
        voucher.setTrangThai(trangThai);
           return voucher;
    }

    String CreateVoucher( int len ){
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i<len; i++ )
        sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NhanKhauController;

import NhanKhauView.DanhSachHoKhau;
import service.HoKhauService;

/**
 *
 * @author MY PC
 */
public class chonHoKhauController {
    DanhSachHoKhau view;
    HoKhauService service;
    
    public chonHoKhauController(DanhSachHoKhau view) {
        this.view = view;
        this.service = new HoKhauService();
    }
    
    public void getHoKhauTable(){
      view.hienThiBangHoKhau(service.getDSHoKhau());
    }
    
    public void timHoKhau(String s){
        view.hienThiBangHoKhau(service.timKiemHoKhau(s));
    }

}

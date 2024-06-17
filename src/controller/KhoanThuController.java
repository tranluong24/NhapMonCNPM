/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import service.KhoanThuService;
import view.KhoanThuView;

/**
 *
 * @author MY PC
 */
public class KhoanThuController {
    KhoanThuService service;
    KhoanThuView view;
    
    public KhoanThuController(KhoanThuView view) {
        this.service = new KhoanThuService();
        this.view = view;
    }
    
    
    public void getKhoanThuTable(){
      view.hienThiBangKhoanThu(service.getDSKhoanThu());
    }
    
    public void timKhoanThu(String s){
        view.hienThiBangKhoanThu(service.timKiemKhoanThu(s));
    }    
    
    public void thongkeKhoanThu(String tinhtrang, String loai){
        String q = new String();
        if(!tinhtrang.equals("Tất cả")){
            q+=" trangThai = '"+tinhtrang+"'";
            q+=" AND ";
        }
        if(!loai.equals("Tất cả")){
            q+= "loaiKhoanThu = '"+loai+"'";
            q+=" AND ";
        }

        q+= "idKhoanThu IS NOT NULL";
                
        
        System.out.println(q+"");
        view.hienThiBangKhoanThu(service.thongKeKhoanThu(q));
     
    }    
    
    
}

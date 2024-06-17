/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import javax.print.attribute.standard.MediaSize;
import model.NhanKhauModel;
import model.ThanhVienModel;
import service.NhanKhauService;
import view.NhanKhauView;
import service.HoKhauService;

/**
 *
 * @author MY PC
 */
public class NhanKhauController {
    
    NhanKhauView view;
    NhanKhauModel model;
    NhanKhauService service;
    HoKhauService service2;

    public NhanKhauController(NhanKhauView view) {
        this.service = new NhanKhauService();
        this.view = view;
        this.service2 = new HoKhauService();
    }
    
    public void getNhanKhauTable(){
      view.hienThiBangNhanKhau(service.getDSNhanKhau());
    }
    
    public void timNhanKhau(String name){
        view.hienThiBangNhanKhau(service.timKiemNhanKhau(name));
    }
    
    public void thongkeNhanKhau(String gioiTinh, String tinhTrang, String from, String to){
        String q = new String();
        if(!gioiTinh.equals("Tất cả")){
            q+=" gioiTinh = '"+gioiTinh+"'";
            q+=" AND ";
        }
        if(!tinhTrang.equals("Tất cả")){
            q+= "tinhTrang = '"+tinhTrang+"'";
            q+=" AND ";
        }
        if(!from.equals("") && !to.equals("")){
            q+=" 2024 - year(namSinh) between "+from +" AND "+to;
            q+= " AND ";
        }
        q+= "CCCD IS NOT NULL";
                
        
        System.out.println(q+"");
        view.hienThiBangNhanKhau(service.thongKeNhanKhau(q));
     
    }
    
    public ThanhVienModel getThanhVien(String CCCD){
        return service2.getThanhVienHK(CCCD);
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import service.HoKhauService;
import view.HoKhauView;

/**
 *
 * @author MY PC
 */
public class HoKhauController {
    
    HoKhauService service;
    HoKhauView view;
    
    public HoKhauController(HoKhauView view) {
        this.service = new HoKhauService();
        this.view = view;
    }
    
    
    public void getHoKhauTable(){
      view.hienThiBangHoKhau(service.getDSHoKhau());
    }
    
    public void timHoKhau(String s){
        view.hienThiBangHoKhau(service.timKiemHoKhau(s));
    }
    
    
}

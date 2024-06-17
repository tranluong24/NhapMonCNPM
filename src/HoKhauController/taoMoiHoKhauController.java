/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HoKhauController;

import service.HoKhauService;
import service.NhanKhauService;
import HoKhauView.taoMoiHoKhau;
import javax.swing.JOptionPane;
import model.HoKhauModel;
import model.NhanKhauModel;
import model.ThanhVienModel;
import view.HoKhauView;

/**
 *
 * @author MY PC
 */
public class taoMoiHoKhauController {
    
    NhanKhauService serviceNK;
    HoKhauService serviceHK;
    taoMoiHoKhau view;
    HoKhauView viewMain;

    public taoMoiHoKhauController(taoMoiHoKhau view) {
        this.view = view;
        serviceHK = new HoKhauService();
        serviceNK = new NhanKhauService();
    }
    
    public String addNhanKhau(NhanKhauModel nhankhau){
        if(!serviceNK.addNhanKhau(nhankhau))
            return null;
        nhankhau = serviceNK.getNhanKhau(nhankhau.getCCCD());
        
        if(nhankhau.getCCCD()!=null){
            return nhankhau.getCCCD();
        }else{
            return null;
        }
    }
    
    public boolean addHoKhau(HoKhauModel hk){
        if(!serviceHK.addHoKhau(hk))
            return false;
  
        return true;
    }
    
    public boolean xoaNhanKhau(String CCCD){
        if(serviceNK.xoaNhanKhau(CCCD)){
            return true;
        }
        return false;
    }
    
    public boolean themThanhVien(ThanhVienModel tv){
        if(serviceHK.addThanhVien(tv))
               return true;
        return false;
        
    }
    
    
}

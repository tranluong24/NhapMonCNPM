/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NhanKhauController;

import model.NhanKhauModel;
import service.NhanKhauService;
import view.NhanKhauView;
import NhanKhauView.themNhanKhau;
import javax.swing.JOptionPane;
import model.ThanhVienModel;
import service.HoKhauService;

/**
 *
 * @author MY PC
 */
public class themNhanKhauController {
    
    NhanKhauService service;
    themNhanKhau view;
    NhanKhauView viewMain;
    HoKhauService service2;
    
    
    
    public themNhanKhauController(themNhanKhau addNhanKhau) {
        this.service = new NhanKhauService();
        this.service2 = new HoKhauService();
        this.view = addNhanKhau;
        
    }
    
        
    public boolean addNhanKhau(NhanKhauModel nhankhau){
            if(service.addNhanKhau(nhankhau)){
                JOptionPane.showMessageDialog(viewMain, "Thêm " +nhankhau.getHoTen()+ " thành công");
                viewMain = new NhanKhauView();
                viewMain.setVisible(true);
                view.setVisible(false);
                return true;
            }else{
                JOptionPane.showMessageDialog(viewMain, "Thêm " +nhankhau.getHoTen()+ " thất bại !");  
                return false;                
            }
    }
    
    public void addThanhVien(ThanhVienModel thanhvien){
       service2.addThanhVien(thanhvien);
    }
    
    public void xoaNhanKhau(String CCCD){
        if(service.xoaNhanKhau(CCCD)){
            JOptionPane.showMessageDialog(viewMain, "" +CCCD+ " chuyển đi thành công !");
        }else{
            JOptionPane.showMessageDialog(viewMain, "" +CCCD+ " chuyển đi thất bại !");
                viewMain = new NhanKhauView();
                viewMain.setVisible(true);
                view.setVisible(false);
        }
    }
    
    public void xemNhanKhau(String CCCD){
      
        view.hienThiNhanKhau(service.getNhanKhau(CCCD));
    }
    
    public void xemHoKhau(String maHK){
        view.hienThiHoKhau(service2.getHoKhau(maHK));
    }
    
    public void xemThanhVien(String CCCD){
        view.hienThiThanhVien(service2.getThanhVienHK(CCCD));
    }
    
    public void suaNhanKhau(String CCCD, NhanKhauModel nk){
        if(service.updateNhanKhau(CCCD,nk)){
            JOptionPane.showMessageDialog(viewMain, "Update " +nk.getHoTen()+ " thành công");
                viewMain = new NhanKhauView();
                viewMain.setVisible(true);
                view.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(viewMain, "Update " +nk.getHoTen()+ " thất bại !");
                viewMain = new NhanKhauView();
                viewMain.setVisible(true);
                view.setVisible(false);
        }   
    }
    
    public void suaHoKhau(ThanhVienModel tv){
        if(service2.updateHKThanhVien(tv)){
            JOptionPane.showMessageDialog(viewMain, "Update " +tv.getIdNhanKhau()+ " thành công !!");
        }else{
            JOptionPane.showMessageDialog(viewMain, "Update " +tv.getIdNhanKhau()+ " thất bại !!");
                viewMain = new NhanKhauView();
                viewMain.setVisible(true);
                view.setVisible(false);
        }
    }
}

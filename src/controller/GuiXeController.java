/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JOptionPane;
import model.PhuongTien;
import service.GuiXeService;
import view.GuiXeView;

/**
 *
 * @author MY PC
 */
public class GuiXeController {
    GuiXeService service;
    GuiXeView view;

    public GuiXeController(GuiXeView view) {
        this.view = view;
        service = new  GuiXeService();
    }
    
    public void getPhuongTienTable(){
      view.hienThiBangPhuongTien(service.getDSPhuongTien());
    }
    
    public void xoaPhuongTien(String bienso){
        
        if(service.xoaPhuongTien(bienso)){
            JOptionPane.showMessageDialog(view, "Xóa " +bienso+ " thành công");
            view.dispose();
            this.view = new GuiXeView();
        }else{
            JOptionPane.showMessageDialog(view, "Xóa " +bienso+ " thất bại !");
        }
    }    
    
    public boolean updatePhuongTienhk(int oto, int xemay, String soNha){
        
        String maHK = service.getThongTinHK(soNha);
        
        if(service.updatePhuongTien_HK(oto, xemay, maHK)){
                return true;
        }else{
                return false;
        }
    }
    
    public void timPhuongTien(String s){
        view.hienThiBangPhuongTien(service.timKiemPhuongTien(s));
    }      
    


    public void thongkeKhoanThu(String loaixe){
        String q = new String();
        if(!loaixe.equals("Tất cả")){
            q+=" LoaiXe = '"+loaixe+"'";
            q+=" AND ";
        }

        q+= "BienSo IS NOT NULL";
                
        
        System.out.println(q+"");
        view.hienThiBangPhuongTien(service.thongKePhuongTien(q));
     
    }        
    
}

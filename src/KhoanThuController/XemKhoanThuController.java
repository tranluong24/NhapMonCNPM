/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package KhoanThuController;

import service.KhoanThuService;
import KhoanThuView.XemKhoanThu;
import javax.swing.JOptionPane;

/**
 *
 * @author MY PC
 */
public class XemKhoanThuController {
    XemKhoanThu view;
    KhoanThuService service;
    
    
    public XemKhoanThuController(XemKhoanThu view){
        this.view = view;
        service = new KhoanThuService();
    }
    
    public void getKhoanThu(String maKhoanThu, String loaiKhoanThu){
        view.hienThiKhoanThu(service.getKhoanThu(maKhoanThu,loaiKhoanThu));
    }
    
    public void getDanhSachCanThu(String maKhoanThu){
        view.hienThiDanhSachCanThu(service.getDanhSachCanThu(maKhoanThu));
    }
    
    public void xoaKhoanThu(String maKhoanThu){
        if(service.xoaKhoanThu(maKhoanThu)){
            JOptionPane.showMessageDialog(view, "Xóa khoản thu " +maKhoanThu+ " thành công");
        }else{
            JOptionPane.showMessageDialog(view, "Xóa khoản thu " +maKhoanThu+ " chưa thành công");
        }
    
    }
    
    public void hoanThanhKhoanThu(String maKhoanThu){
        if(service.hoanThanhKhoanThu(maKhoanThu)){
            JOptionPane.showMessageDialog(view, "Khoản thu " +maKhoanThu+ " hoàn thành");
        }else{
            JOptionPane.showMessageDialog(view, "Khoản thu " +maKhoanThu+ " chưa hoàn thành");
        }
    }
}

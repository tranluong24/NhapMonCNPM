/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaiKhoanController;

import TaiKhoanView.DoiMatKhauView;
import controller.DangNhapController;
import javax.swing.JOptionPane;
import model.TaiKhoanModel;
import service.TaiKhoanService;
import view.MainView;

/**
 *
 * @author MY PC
 */
public class doiMatKhauController {
    TaiKhoanService  service;
    DoiMatKhauView view;
    MainView mainview;

    public doiMatKhauController(DoiMatKhauView view) {
        this.view = view;
        service = new TaiKhoanService();
    }
    
    public void thongTinTaiKhoan(String role){
        view.hienThiThongTinTaiKhoan( service.thongTinTaiKhoan(role));
    }
    
    public void updateTaiKhoan(TaiKhoanModel tk, String usernameold){
        if(service.xoaTaiKhoan(usernameold)){
            if(service.addTaiKhoan(tk)){
                JOptionPane.showMessageDialog(mainview, "Thay đổi mật khẩu thành công !");
                view.dispose();
                mainview = new MainView(tk.getRole());
            }else{
                JOptionPane.showMessageDialog(view, "Thay đổi mật khẩu thất bại !");
            }
        }else{
               JOptionPane.showMessageDialog(view, "Thay đổi mật khẩu thất bại !!");
        }
    }
}

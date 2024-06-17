/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.TaiKhoanModel;
import service.TaiKhoanService;
import view.LoginView;

/**
 *
 * @author MY PC
 */
public class DangNhapController {
    TaiKhoanService service;
    LoginView view;

    public DangNhapController(LoginView view) {
        service = new TaiKhoanService();
        this.view = view;
    }
    
    public String login(String user, String pass){
        TaiKhoanModel tk = service.login(user);
        if(tk!=null){
            if(user.equals(user) && tk.getPassword().equals(pass)){
                return tk.getRole();
            }else{
                return "";
            }
        }else{
            return "";
        }
    }
    
    
}

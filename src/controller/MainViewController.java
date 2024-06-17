/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import service.GuiXeService;
import service.HoKhauService;
import service.KhaiBaoService;
import service.NhanKhauService;
import view.MainView;

/**
 *
 * @author MY PC
 */
public class MainViewController {
    NhanKhauService serviceNK;
    HoKhauService serviceHK;
    KhaiBaoService serviceKB;
    GuiXeService serviewGX;
    MainView view;

    public MainViewController(MainView view) {
        serviceNK = new NhanKhauService();
        serviceKB = new KhaiBaoService();
        serviceHK = new HoKhauService();
        serviewGX = new GuiXeService();
        this.view = view;
    }
    
    public void thongTinChungCu(){
        view.hienThiThongTinChungCu(serviceHK.slHoKhau(), serviceNK.slNhanKhau(), serviceKB.slKhaiBao().get(0), serviceKB.slKhaiBao().get(1), serviewGX.slPhuongTien());
    }
    
    
}

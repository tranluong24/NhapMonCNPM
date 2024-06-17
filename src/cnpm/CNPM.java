/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cnpm;

import view.NhanKhauView;

import java.awt.Color;

import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;

import HoKhauView.taoMoiHoKhau;
import NhanKhauView.themNhanKhau;
import view.GuiXeView;
import view.HoKhauView;
import view.KhoanThuView;
import view.LoginView;
import view.MainView;

/**
 *
 * @author MY PC
 */
public class CNPM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	
    	ThemeConfig.applyTheme();
    	
        // TODO code application logic here
       //NhanKhauView view1 = new NhanKhauView ();
       //HoKhauView view2 = new HoKhauView ();
      //KhoanThuView view3 = new KhoanThuView ();
    //    GuiXeView view4 = new GuiXeView();
      //  MainView view = new MainView("Quản lý");
      LoginView viewLog = new LoginView();
    //	taoMoiHoKhau view5 = new taoMoiHoKhau(null);
    }
}

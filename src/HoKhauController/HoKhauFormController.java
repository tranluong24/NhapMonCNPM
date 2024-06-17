/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HoKhauController;
import HoKhauView.HoKhauForm;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.HoKhauModel;
import model.ThanhVienModel;
import service.HoKhauService;
import service.NhanKhauService;

/**
 *
 * @author MY PC
 */
public class HoKhauFormController {
    
    HoKhauForm view;
    HoKhauService service;
    NhanKhauService serviceNK;
    
    
    public HoKhauFormController(HoKhauForm view){
        this.view = view;
        service = new HoKhauService();
        serviceNK = new NhanKhauService();
    }
    
    public void getHoKhau(String maHK){
        view.hienThiHoKhau(service.getHoKhau(maHK));
    }
    
    public void getChuHo(String Id_chuHo){
        view.hienThiChuHo(serviceNK.getNhanKhau(Id_chuHo+""));
    }
    
    public void getThanhVien(String maHK){
        view.hienThiThanhVien(service.getDSThanhVien(maHK));
    }
    
    public void chuyenDiNoiKhac(String maHK){
        ArrayList<ThanhVienModel> listTV = service.getDSThanhVien(maHK);
        for(ThanhVienModel i : listTV){
            if(!(serviceNK.xoaNhanKhau(i.getIdNhanKhau()))){
                JOptionPane.showMessageDialog(view, "" +i.getHoTen()+ " chuyển đi thất bại !");
            }
        }
        JOptionPane.showMessageDialog(view, "" +maHK+ " chuyển đi nhà thành công !");
        
        
    }
    
    
    
    
    
    
    
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DongTienController;
import service.DongTienService;
import DongTienView.DongTienHK;
import java.util.ArrayList;
import model.DongTienModel;
import model.KhoanThu;
import model.PhuongTienHKModel;
import model.ThuHoModel;
import service.GuiXeService;
import service.KhoanThuService;
import service.ThuHoService;

/**
 *
 * @author MY PC
 */
public class DongTienControl {
    DongTienService service;
    DongTienHK view;
    GuiXeService serviceGX;
    ThuHoService serviceTH;
    KhoanThuService serviceKT;

    public DongTienControl(DongTienHK view) {
        this.view = view;
        service = new DongTienService();
        serviceGX = new GuiXeService();
        serviceTH = new ThuHoService();
        serviceKT = new KhoanThuService();
    }
    
    public ArrayList<DongTienModel> getKhoanThuTable(String maHK){
        
      return service.getDSKhoanThu(maHK);
      
    }
    
    public void getThongTinHoKhau(String maHK){
        view.hienThiThongTinHoKhau(service.getThongTinHoKhau(maHK));
    }
    
    public void UpdateKhoanThu(ArrayList<DongTienModel> list){
        
        service.updateCacKhoanThu(list);
        
    }
    
    public PhuongTienHKModel getPhuongTien(String maHK){
        return serviceGX.getPhuongTienHK(maHK);
    }
    
    public ThuHoModel getDichVu(String maHK, String loai){
        return serviceTH.getThuHo(maHK,loai);
    }
    
    public KhoanThu trangThaiKhoanThu(String maKT){
        return serviceKT.getKhoanThu(maKT);
    }
    
    public void updatePhiDongGop(String maKT, int sum){
        serviceKT.updatePhiDongGop(maKT, sum);
    
    
    }
    
    
}

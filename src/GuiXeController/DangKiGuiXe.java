/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GuiXeController;

import service.GuiXeService;
import GuiXeView.DangKiGuiXeView;
import javax.swing.JOptionPane;
import model.PhuongTien;
import service.HoKhauService;
import service.NhanKhauService;

/**
 *
 * @author MY PC
 */
public class DangKiGuiXe {
    GuiXeService service;
    DangKiGuiXeView view;
    HoKhauService serviceHK;
    NhanKhauService serviceNK;

    public DangKiGuiXe(DangKiGuiXeView view) {
        this.view = view;
        service = new GuiXeService();
        serviceNK = new NhanKhauService();
        serviceHK = new HoKhauService();
    }
    
    public boolean addPhuongTien(PhuongTien pt){
        String maHK = service.getThongTinHK(pt.getSoNha());
        String maNK = service.getThongTinNK(pt.getTenChuXe(), maHK);
        
        if(service.addPhuongTien(maHK,maNK,pt.getBienSo(),pt.getLoaiXe())){
            JOptionPane.showMessageDialog(view, "Thêm " +pt.getBienSo()+ " thành công");
            
             int xemay = 0;
             int oto = 0;
             if(pt.getLoaiXe().equals("Xe máy")){
                    xemay = 1;
             }else if(pt.getLoaiXe().equals("Ô tô")){
                    oto = 1;
             }
             
             if(!(this.addPhuongTien_hk(oto,xemay,maHK))){
                this.updatePhuongTien_hk(oto, xemay, maHK);
             }
             
             return true;
        }else{
            JOptionPane.showMessageDialog(view, "Thêm " +pt.getBienSo()+ " thất bại !");
                return false;
        }
        
    }    
    
    public boolean addPhuongTien_hk(int oto, int xemay, String mahk){
        if(service.addPhuongTien_HK(oto, xemay, mahk)){
                return true;
        }else{
                return false;
        }
    }
    
    public boolean updatePhuongTien_hk(int oto, int xemay, String mahk){
        if(service.updatePhuongTien_HK(oto, xemay, mahk)){
                return true;
        }else{
                return false;
        }
    }
    
    public boolean kiemTraThanhVien(String maHK, String hoTen){
        String maNK = service.getThongTinNK(hoTen, maHK);
        if(maNK!=null){
            return true;
        }
        return false;
    }
    
    
    
    
}

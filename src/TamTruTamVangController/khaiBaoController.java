/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TamTruTamVangController;

import HoKhauView.KhaiBaoTinhTrangView;
import javax.swing.JOptionPane;
import model.HoKhauModel;
import model.NhanKhauModel;
import model.TamTruTamVangModel;
import model.ThanhVienModel;
import service.HoKhauService;
import service.KhaiBaoService;
import service.NhanKhauService;

/**
 *
 * @author MY PC
 */
public class khaiBaoController {
    KhaiBaoService service;
    KhaiBaoTinhTrangView view;
    NhanKhauService serviceNK;
    HoKhauService serviceHK;
    
    
    
    public khaiBaoController(KhaiBaoTinhTrangView view) {
        this.service = new KhaiBaoService();
        this.view = view;
        this.serviceNK = new NhanKhauService();
        this.serviceHK = new HoKhauService();
        
    }    
    
    public boolean addKhaiBao(TamTruTamVangModel kb){
        NhanKhauModel nhankhauTinhTrang = serviceNK.getNhanKhau(kb.getCCCD());
        nhankhauTinhTrang.setTinhTrang(kb.getLoaiDangKy());
        System.out.println(nhankhauTinhTrang.getCCCD()+nhankhauTinhTrang.getTinhTrang() +"");
        if(service.addKhaiBao(kb) && serviceNK.updateNhanKhau(kb.getCCCD(), nhankhauTinhTrang)){
                JOptionPane.showMessageDialog(view, "Khai báo " +kb.getName()+ " thành công");
                return true;
        }else{
            JOptionPane.showMessageDialog(view, "Khai báo " +kb.getName()+ " thất bại !");  
                return false;
        }
    }
    
    public NhanKhauModel getNhanKhau(String CCCD){
        return serviceNK.getNhanKhau(CCCD);
    }
    
    public HoKhauModel getHoKhau(String soNha){
        return serviceHK.getHoKhau(soNha);
    }    
    
    public ThanhVienModel getKiemTraThanhVien(String CCCD){
        return serviceHK.getThanhVienHK(CCCD);
    }    
    
    public void xemKhaiBao(String CCCD, String tinhTrang){
        view.hienThiThongTinKhaiBao(service.xemKhaiBao(CCCD,tinhTrang),serviceHK.getThanhVienHK(CCCD).getIdHoKhau());
    } 
    
    public void hoanThanh(String CCCD,String opt){
         NhanKhauModel nhankhauTinhTrang = serviceNK.getNhanKhau(CCCD);
         String tinhTrang = nhankhauTinhTrang.getTinhTrang();
        if(service.xoaKhaiBao(CCCD, tinhTrang)){
            String soNha = serviceHK.getThanhVienHK(CCCD).getIdHoKhau();
            String loaiSo = serviceHK.getHoKhau(soNha).getLoaiSo();
           
            //Hoan thanh tam tru
            if(nhankhauTinhTrang.getTinhTrang().equals("Tạm trú")){
                if(serviceNK.xoaNhanKhau(CCCD)){
                    JOptionPane.showMessageDialog(view, "Hoàn thành " +CCCD+ " thành công");
                }
            }
            //Hoan thanh tam vang cho tam tru
            if(loaiSo.equals("Tạm trú")){
                nhankhauTinhTrang.setTinhTrang("Tạm trú");            
                if(serviceNK.updateNhanKhau(CCCD, nhankhauTinhTrang)){
                    JOptionPane.showMessageDialog(view, "Hoàn thành " +CCCD+ " thành công");
                } 
            }
            //Hoan thanh tam vang cho thuong tru (và //Hoan thanh tam vang cho tam tru o thuong tru
            if(loaiSo.equals("Thường trú")){
                if(nhankhauTinhTrang.getTinhTrang().equals("tạm vắng")){
                    nhankhauTinhTrang.setTinhTrang("Tạm trú");  
                }else{
                    nhankhauTinhTrang.setTinhTrang("Thường trú"); 
                }         
                if(serviceNK.updateNhanKhau(CCCD, nhankhauTinhTrang)){
                    JOptionPane.showMessageDialog(view, "Hoàn thành " +CCCD+ " thành công");
                } 
            }
            
            
        }else{
            JOptionPane.showMessageDialog(view, "Hoàn thành " +CCCD+ " thất bại");
        }
    }
}

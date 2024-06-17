/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package KhoanThuController;
import service.KhoanThuService;
import KhoanThuView.ThemKhoanThu;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import model.DongTienModel;
import model.HoKhauModel;
import model.KhoanThu;
import model.PhuongTien;
import model.PhuongTienHKModel;
import model.ThuHoModel;
import service.ExcelReader;
import service.GuiXeService;
import service.HoKhauService;
/**
 *
 * @author MY PC
 */
public class ThemKhoanThuController {
    KhoanThuService service;
    ThemKhoanThu view;
    HoKhauService serviceHK;
    GuiXeService serviceGX;
    ExcelReader serviceEX;
    
    public ThemKhoanThuController(ThemKhoanThu view) {
        this.service = new KhoanThuService();
        this.view = view;
        this.serviceHK = new HoKhauService();
        this.serviceGX = new GuiXeService();
        serviceEX = new ExcelReader();
                
                
    }
    
    public boolean addKhoanThu(KhoanThu khoanthu){
        if(service.addKhoanThu(khoanthu)){
            //JOptionPane.showMessageDialog(view, "Thêm " +khoanthu.getTenKhoanThu()+ " thành công");
                return true;
        }else{
            //JOptionPane.showMessageDialog(view, "Thêm " +khoanthu.getTenKhoanThu()+ " thất bại !");
                return false;
        }
    }
    
    public boolean addPhiBatBuoc(KhoanThu khoanthu){
        if(service.addPhiBatBuoc(khoanthu)){
            JOptionPane.showMessageDialog(view, "Thêm " +khoanthu.getTenKhoanThu()+ " thành công");
                return true;
        }else{
            JOptionPane.showMessageDialog(view, "Thêm " +khoanthu.getTenKhoanThu()+ " thất bại !");
                return false;
        }
    }
    
    public boolean addPhiDongGop(KhoanThu khoanthu){
        if(service.addPhiDongGop(khoanthu)){
            JOptionPane.showMessageDialog(view, "Thêm " +khoanthu.getTenKhoanThu()+ " thành công");
                return true;
        }else{
            JOptionPane.showMessageDialog(view, "Thêm " +khoanthu.getTenKhoanThu()+ " thất bại !");
                return false;
        }
    }    
        
    public boolean addPhiThuHo(KhoanThu khoanthu){
        if(service.addPhiThuHo(khoanthu)){
            JOptionPane.showMessageDialog(view, "Thêm " +khoanthu.getTenKhoanThu()+ " thành công");
                return true;
        }else{
            JOptionPane.showMessageDialog(view, "Thêm " +khoanthu.getTenKhoanThu()+ " thất bại !");
                return false;
        }
    }
            
    public boolean addPhiGuiXe(KhoanThu khoanthu){
        if(service.addPhiGuiXe(khoanthu)){
            JOptionPane.showMessageDialog(view, "Thêm " +khoanthu.getTenKhoanThu()+ " thành công");
                return true;
        }else{
            JOptionPane.showMessageDialog(view, "Thêm " +khoanthu.getTenKhoanThu()+ " thất bại !");
                return false;
        }
    }
                
     public void themDanhSachHoDong(KhoanThu kt){
              Date ngayDong;
              SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
               try{
                    ngayDong = dateFormat.parse("1111-11-11");
                }catch(ParseException e){
                    ngayDong = null;            
                }
               
        ArrayList<DongTienModel> thuList = new ArrayList<>();
        ArrayList<HoKhauModel> hkList = new ArrayList<>();
        
        ArrayList<PhuongTienHKModel> ptList = new ArrayList<>();
         
        
        String loaiKhoanPhi = kt.getLoaiKhoanThu();
        String maKhoanThu = kt.getIdKhoanThu();
        String tenKhoanThu = kt.getTenKhoanThu();
        String trangThaiDong ="Chưa đóng";
        
      if(loaiKhoanPhi.equals("Phí quản lý") || loaiKhoanPhi.equals("Phí dịch vụ")){
        hkList = this.serviceHK.getDSHoKhau();
        int donGia = kt.getDonGia();
        
        
        for(HoKhauModel i: hkList){
             String tenChuHo = i.getTenChu();
             String soNha = i.getSoNha();
             String maHK = i.getSoNha();
             
             int DienTich = i .getDienTich();
             
             int soTienCanDong = DienTich * donGia;

             
             DongTienModel dt = new DongTienModel(maKhoanThu, maHK, tenChuHo, tenKhoanThu, soNha,ngayDong, soTienCanDong, trangThaiDong);
             thuList.add(dt);
         }
        
        
        this.service.themDSHoCanDong(thuList);
        
        }else if(loaiKhoanPhi.equals("Phí gửi xe")){
            ptList = this.serviceGX.getDSPhuongTienHK();
         int giaOTO = kt.getOto();
         int giaXeMay = kt.getXemay();
         
         for(PhuongTienHKModel i:ptList){
             int soTienCanDong = giaOTO*i.getOto() + giaXeMay*i.getXemay();
             String maHK = i.getMahk();
             String tenChuHo = i.getTenChuHo();
             String soNha = i.getSoNha();
             
             DongTienModel dt = new DongTienModel(maKhoanThu, maHK, soTienCanDong, trangThaiDong,ngayDong);
             thuList.add(dt);
         }
        this.service.themDSHoCanDong(thuList);
        
        }else if(loaiKhoanPhi.equals("Phí thu hộ")){
            
            ArrayList<ThuHoModel> thuhoList = new ArrayList<>();
            thuhoList = serviceEX.readExcelFile();
            
            for(ThuHoModel th : thuhoList){
                th.setMakhoanthu(maKhoanThu);
                th.setMahokhau(serviceGX.getThongTinHK(th.getMahokhau()));
                DongTienModel dt = new DongTienModel(maKhoanThu, th.getMahokhau(), th.getSoTien(), trangThaiDong, ngayDong);
                thuList.add(dt);
            }
            service.themDSThuHo(thuhoList);
            this.service.themDSHoCanDong(thuList);   
        }else if(loaiKhoanPhi.equals("Phí đóng góp")){
            hkList = this.serviceHK.getDSHoKhau();
             for(HoKhauModel i: hkList){
                String tenChuHo = i.getTenChu();
                String soNha = i.getSoNha();
                String maHK = i.getSoNha();

                int soTienCanDong = 0;
             
                DongTienModel dt = new DongTienModel(maKhoanThu, maHK, tenChuHo, tenKhoanThu, soNha, ngayDong, soTienCanDong, trangThaiDong);
                thuList.add(dt);
            }
             this.service.themDSHoCanDong(thuList);
        }
     }
}


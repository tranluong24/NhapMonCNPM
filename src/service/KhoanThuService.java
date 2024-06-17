/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.DongTienModel;
import model.KhoanThu;
import model.ThuHoModel;

/**
 *
 * @author MY PC
 */
public class KhoanThuService {
    
    public ArrayList<DongTienModel> getDanhSachCanThu(String maKhoanThu){
        ArrayList<DongTienModel> list = new ArrayList<>();
       
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
            String query = "SELECT * FROM dongtien INNER JOIN hokhau ON dongtien.maHoKhau = hokhau.soNha INNER JOIN nhankhau ON hokhau.IdChuHo = nhankhau.CCCD WHERE dongtien.maKhoanThu = ?";
            
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, maKhoanThu);
            ResultSet rs = preparedStatement.executeQuery();
            
        while (rs.next()){    
                DongTienModel dongtien = new DongTienModel();
                dongtien.setSoTien(rs.getInt("soTien"));
                dongtien.setNgayDong(rs.getDate("ngayDong"));
                dongtien.setTrangThai(rs.getString("trangThai"));
                dongtien.setTenChuHo(rs.getString("hoTen"));
                dongtien.setSoNha(rs.getString("soNha"));
                
                list.add(dongtien);
                //System.out.println(dongtien.getMaHoKhau()+"");
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Ho Khau Serice: "+e.getMessage());
        }
     
        return list;
    }
    
    public boolean addKhoanThu(KhoanThu kt){
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
          
            String query = "Insert into khoanthu (idKhoanThu,tenKhoanThu, loaiKhoanThu, ngayKhoiTao, trangThai)Values (?,?,?,?,?);";
            //String query = "Insert into nhankhau (CCCD, hoTen, namSinh, gioiTinh, nguyenQuan, danToc,quocTich, noiLamViec, ngheNghiep, tinhTrang, DiaChi)Values ('1233657893', 'Nguyễn Văn Hùng c','2000-06-02','nam','Hà Nội','Kinh','Việt Nam','Hà Nội','Kĩ sư','Thường trú', 'BlueMoon') ;";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, kt.getIdKhoanThu());
            preparedStatement.setString(2, kt.getTenKhoanThu());
            preparedStatement.setString(3, kt.getLoaiKhoanThu());
            
            java.util.Date dat = kt.getNgayBatDau();
            java.sql.Date sqldat = new java.sql.Date(dat.getTime());
            
            preparedStatement.setDate(4, sqldat);
             preparedStatement.setString(5, kt.getTrangThai());
            
            preparedStatement.executeUpdate();
            
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Khoan Thu Serice: "+e.getMessage());
            return false;
        }
        return true;
    }
    
    public boolean addPhiThuHo(KhoanThu kt){
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
          
            String query = "Insert into phithuho (maKhoanThu, tenCongTy, loaiDichVu)Values (?,?,?);";
            
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, kt.getIdKhoanThu());
            preparedStatement.setString(2, kt.getTenCongTy());
            
            
            preparedStatement.setString(3, kt.getDichVu());
            
            preparedStatement.executeUpdate();
            
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Khoan Thu Serice: "+e.getMessage());
            return false;
        }
        return true;
    }
    
    public boolean addPhiBatBuoc(KhoanThu kt){
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
          
            String query = "Insert into phibatbuoc (maKhoanThu, donGia)Values (?,?);";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, kt.getIdKhoanThu());
            preparedStatement.setInt(2, kt.getDonGia());
           
            preparedStatement.executeUpdate();
            
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Khoan Thu Serice: "+e.getMessage());
            return false;
        }
        return true;
    }
    
    public boolean addPhiDongGop(KhoanThu kt){
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
          
            String query = "Insert into phidonggop (maKhoanThu, tongTien)Values (?,?);";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, kt.getIdKhoanThu());
            preparedStatement.setInt(2, kt.getTongThu());
           
            preparedStatement.executeUpdate();
            
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Khoan Thu dg Serice: "+e.getMessage());
            return false;
        }
        return true;
    }    
    
    public boolean addPhiGuiXe(KhoanThu kt){
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
          
            String query = "Insert into phiguixe (maKhoanThu, oto, xemay)Values (?,?,?);";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, kt.getIdKhoanThu());
            preparedStatement.setInt(2, kt.getOto());
            
            
            preparedStatement.setInt(3, kt.getXemay());
            
            preparedStatement.executeUpdate();
            
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Khoan Thu Serice: "+e.getMessage());
            return false;
        }
        return true;
    }
    
public ArrayList<KhoanThu> getDSKhoanThu(){
        ArrayList<KhoanThu> list = new ArrayList<KhoanThu>();
       
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
            String query = "SELECT * FROM khoanthu";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = preparedStatement.executeQuery();
            
        while (rs.next()){
                
                KhoanThu khoanthu = new KhoanThu();
                khoanthu.setIdKhoanThu(rs.getString("idKhoanThu"));
                khoanthu.setTenKhoanThu(rs.getString("tenKhoanThu"));
                khoanthu.setLoaiKhoanThu(rs.getString("loaiKhoanThu"));
                khoanthu.setNgayBatDau(rs.getDate("ngayKhoiTao"));
                khoanthu.setTrangThai(rs.getString("trangThai"));
                
                list.add(khoanthu);
                //System.out.println(nhankhau.getHoTen()+"");
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Ho Khau Serice: "+e.getMessage());
        }
     
        return list;
    }

    public KhoanThu getKhoanThu(String maKhoanThu, String loaiKhoanPhi){
        String query = "";
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
            if(loaiKhoanPhi.equals("Phí dịch vụ")||loaiKhoanPhi.equals("Phí quản lý"))
                query = "SELECT * FROM khoanthu INNER JOIN phibatbuoc ON khoanthu.idKhoanThu = phibatbuoc.maKhoanThu Where idKhoanThu = ?";
            else if(loaiKhoanPhi.equals("Phí gửi xe"))
                  query = "SELECT * FROM khoanthu INNER JOIN phiguixe ON khoanthu.idKhoanThu = phiguixe.maKhoanThu Where idKhoanThu = ?";
            else if(loaiKhoanPhi.equals("Phí thu hộ"))
                query = "SELECT * FROM khoanthu INNER JOIN phithuho ON khoanthu.idKhoanThu = phithuho.maKhoanThu Where idKhoanThu =?";
            else if(loaiKhoanPhi.equals("Phí đóng góp")){
               query = "SELECT * FROM khoanthu INNER JOIN phidonggop ON khoanthu.idKhoanThu = phidonggop.maKhoanThu Where idKhoanThu =?"; 
            }
            
            
            preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, maKhoanThu);
            ResultSet rs = preparedStatement.executeQuery();
            
            if(rs.first()){
                KhoanThu kt = new KhoanThu();
                kt.setIdKhoanThu(rs.getString("idKhoanThu"));
                kt.setTenKhoanThu(rs.getString("tenKhoanThu"));
                kt.setLoaiKhoanThu(rs.getString("loaiKhoanThu"));
                kt.setNgayBatDau(rs.getDate("ngayKhoiTao"));
                kt.setTrangThai(rs.getString("trangThai"));
                if(loaiKhoanPhi.equals("Phí dịch vụ")||loaiKhoanPhi.equals("Phí quản lý"))
                    kt.setDonGia(rs.getInt("donGia"));
                if(loaiKhoanPhi.equals("Phí gửi xe")){
                    kt.setOto(rs.getInt("oto"));
                    kt.setXemay(rs.getInt("xemay"));
                }
                if(loaiKhoanPhi.equals("Phí thu hộ")){
                    kt.setTenCongTy(rs.getString("tenCongTy"));
                    kt.setDichVu(rs.getString("loaiDichVu"));
                }
                if(loaiKhoanPhi.equals("Phí đóng góp")){
                    kt.setTongThu(rs.getInt("tongTien"));
                }
               
                return kt;
            }
        } catch (Exception e) {
            System.out.println("KhoanThu Serice: "+e.getMessage());
            System.out.println(query);
        }
                
        return null; 
    }
    
    public boolean themDSHoCanDong(ArrayList<DongTienModel> dt){
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
          
            String query = "Insert into dongtien (maKhoanThu, maHoKhau, soTien, ngayDong,trangThai)Values (?,?,?,?,?);";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
          for(DongTienModel DT : dt){  
            preparedStatement.setString(1, DT.getMaKhoanThu());
            preparedStatement.setString(2, DT.getMaHoKhau());
            
            
            preparedStatement.setInt(3, DT.getSoTien());
            java.util.Date dat = DT.getNgayDong();
            java.sql.Date sqldat = new java.sql.Date(dat.getTime());
            preparedStatement.setDate(4, sqldat);
            preparedStatement.setString(5, DT.getTrangThai());
           preparedStatement.addBatch();
            
          }
          //preparedStatement.executeUpdate();
          preparedStatement.executeBatch();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Khoan Thu Serice themDSDOng: "+e.getMessage());
            return false;
        }
        return true;
    }
    
    public boolean themDSThuHo(ArrayList<ThuHoModel> th){
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
          
            String query = "Insert into thuho_hk (maHK, mkhoanthu,suDung , soTien)Values (?,?,?,?);";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
          for(ThuHoModel thuho : th){  
            preparedStatement.setString(1, thuho.getMahokhau());
            preparedStatement.setString(2, thuho.getMakhoanthu());
            
            
            preparedStatement.setString(3, thuho.getSuDung());
            preparedStatement.setInt(4, thuho.getSoTien());
           preparedStatement.addBatch();
            
          }
          //preparedStatement.executeUpdate();
          preparedStatement.executeBatch();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Khoan Thu Serice: "+e.getMessage());
            return false;
        }
        return true;
    }
    
 public boolean themDSHoCanThuHo(ArrayList<DongTienModel> dt){
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
          
            String query = "Insert into dongtien (maKhoanThu, maHoKhau, soTien, trangThai)Values (?,?,?,?);";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
          for(DongTienModel DT : dt){  
            preparedStatement.setString(1, DT.getMaKhoanThu());
            preparedStatement.setString(2, DT.getMaHoKhau());
            
            
            preparedStatement.setInt(3, DT.getSoTien());
            preparedStatement.setString(4, DT.getTrangThai());
           preparedStatement.addBatch();
            
          }
          //preparedStatement.executeUpdate();
          preparedStatement.executeBatch();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Khoan Thu Serice: "+e.getMessage());
            return false;
        }
        return true;
    }
       public boolean xoaKhoanThu(String khoanthu){
        String query = "";
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
            query = "DELETE FROM khoanthu WHERE idKhoanThu = ?";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            preparedStatement.setString(1, khoanthu);
            preparedStatement.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("pt Serice k xoa dc: "+e.getMessage());
            return false;
        }
                       
        return true;
    }
    public boolean hoanThanhKhoanThu(String khoanthu){
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
            String query = "UPDATE khoanthu SET trangThai = ? WHERE idKhoanThu = ?";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            preparedStatement.setString(1, "Hoàn thành");
            preparedStatement.setString(2, khoanthu);
            preparedStatement.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Helo Serice: "+e.getMessage());
        }
                
        return true;
    }
    public KhoanThu getKhoanThu(String maKhoanThu){
        String query = "";
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
               query = "SELECT * FROM khoanthu Where idKhoanThu =?"; 
            
            
            preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, maKhoanThu);
            ResultSet rs = preparedStatement.executeQuery();
            
            if(rs.first()){
                KhoanThu kt = new KhoanThu();
                kt.setIdKhoanThu(rs.getString("idKhoanThu"));
                kt.setTenKhoanThu(rs.getString("tenKhoanThu"));
                kt.setLoaiKhoanThu(rs.getString("loaiKhoanThu"));
                kt.setNgayBatDau(rs.getDate("ngayKhoiTao"));
                kt.setTrangThai(rs.getString("trangThai"));
                return kt;
            }
        } catch (Exception e) {
            System.out.println("KhoanThu Serice: "+e.getMessage());
            System.out.println(query);
        }
                
        return null; 
    }
    
    public boolean updatePhiDongGop(String maHK, int sum){
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
            String query = "UPDATE phidonggop SET tongTien = tongTien + ? WHERE maKhoanThu = ?";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
                    preparedStatement.setInt(1, sum);
                     preparedStatement.setString(2, maHK);

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Helo Serice: "+e.getMessage());
        }
                
        return true;
    }


    public ArrayList<KhoanThu> timKiemKhoanThu(String timkiem){
        ArrayList<KhoanThu> list = new ArrayList<>();
        String query = "";
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
            query = "SELECT * FROM khoanthu Where idKhoanThu like  ? OR tenKhoanThu like ?";
                
            preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, "%"+timkiem+"%");
            preparedStatement.setString(2, "%"+timkiem+"%");
                
        ResultSet rs = preparedStatement.executeQuery();
            
        while (rs.next()){      
                KhoanThu kt = new KhoanThu();
                kt.setIdKhoanThu(rs.getString("idKhoanThu"));
                kt.setTenKhoanThu(rs.getString("tenKhoanThu"));
                kt.setLoaiKhoanThu(rs.getString("loaiKhoanThu"));
                kt.setNgayBatDau(rs.getDate("ngayKhoiTao"));
                kt.setTrangThai(rs.getString("trangThai"));
                list.add(kt);
            }
            preparedStatement.close();
            connection.close();
            
        } catch (Exception e) {
            System.out.println("khoanthu Serice: "+e.getMessage());
        }
        return list;
        
    }   
    
    public ArrayList<KhoanThu> thongKeKhoanThu(String q){
        ArrayList<KhoanThu> list = new ArrayList<>();
        String query = "";
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");

                query = "SELECT * FROM khoanthu Where "+q;
                
                preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
                ResultSet rs = preparedStatement.executeQuery();
            
        while (rs.next()){      
                KhoanThu kt = new KhoanThu();
                kt.setIdKhoanThu(rs.getString("idKhoanThu"));
                kt.setTenKhoanThu(rs.getString("tenKhoanThu"));
                kt.setLoaiKhoanThu(rs.getString("loaiKhoanThu"));
                kt.setNgayBatDau(rs.getDate("ngayKhoiTao"));
                kt.setTrangThai(rs.getString("trangThai"));

                list.add(kt);
            }
            preparedStatement.close();
            connection.close();
            
        } catch (Exception e) {
            System.out.println("ktSerice: "+e.getMessage());
        }
    
        return list;
    }    
}

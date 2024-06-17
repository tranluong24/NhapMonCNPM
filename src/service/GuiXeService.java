/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.NhanKhauModel;
import model.PhuongTien;
import model.PhuongTienHKModel;

/**
 *
 * @author MY PC
 */
public class GuiXeService {
    
    public ArrayList<PhuongTien> getDSPhuongTien(){
        ArrayList<PhuongTien> list = new ArrayList<>();
        
       
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
            String query = "SELECT * FROM phuongtien INNER JOIN nhankhau ON nhankhau.CCCD = phuongtien.maNK INNER JOIN hokhau ON hokhau.soNha = phuongtien.MaHK ";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = preparedStatement.executeQuery();
            
        while (rs.next()){
                
                PhuongTien pt = new PhuongTien();
                pt.setSoNha(rs.getString("soNha"));
                pt.setTenChuXe(rs.getString("hoTen"));
                pt.setBienSo(rs.getString("BienSo"));
                pt.setLoaiXe(rs.getString("LoaiXe"));
                pt.setMahk(rs.getString("MaHK"));
                pt.setMank(rs.getString("MaNK"));
                list.add(pt);
                //System.out.println(nhankhau.getHoTen()+"");
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("pt Serice: "+e.getMessage());
        }
     
        return list;
    }  
    public int slPhuongTien(){
        String query = "";
        PreparedStatement preparedStatement = null;
        int soLuong = 0;
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
            query = "SELECT COUNT(*) AS SL FROM phuongtien";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = preparedStatement.executeQuery();
            
            if(rs.first()){
                soLuong =  rs.getInt("SL");
            }
            
        } catch (Exception e) {
            System.out.println("PT k dem dc: "+e.getMessage());
            return 0;
        }
        return soLuong;
                       
    }    
    
    public boolean addPhuongTien(String mahk, String mank, String bienso, String loaixe){
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
          
            String query = "Insert into phuongtien (MaHK, MaNK, BienSo, LoaiXe)Values (?,?,?,?);";
            
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, mahk);
           preparedStatement.setString(2, mank);
            preparedStatement.setString(3, bienso);
            preparedStatement.setString(4, loaixe);
            System.out.println(mank+" "+mahk);
            
            preparedStatement.executeUpdate();
            
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("pt Serice: "+e.getMessage());
            return false;
        }
        return true;
    }
    
    public String getThongTinHK(String soNha){
        String query = "";
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
            query = "SELECT soNha FROM hokhau Where soNha ="+soNha;
            preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            if(rs.first()){
                String maHK = rs.getString("soNha");
                
                return maHK;
            }
        } catch (Exception e) {
            System.out.println("pt Serice: "+e.getMessage());
            System.out.println(query);
        }
                
        return null; 
    }
    
    public String getThongTinNK(String hoTen, String maHK){
        String query = "";
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
            query = "SELECT CCCD FROM nhankhau INNER JOIN thanhvien ON nhankhau.CCCD = thanhvien.manhankhau Where mahokhau =? AND hoTen = ?";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, maHK);
            preparedStatement.setString(2, hoTen);
            ResultSet rs = preparedStatement.executeQuery();
            
            if(rs.first()){
                String maNK = rs.getString("CCCD");
                
                return maNK;
            }
        } catch (Exception e) {
            System.out.println("Nhan Khau Serice: "+e.getMessage());
            System.out.println(query);
        }
                
        return null; 
    }   
    
    public boolean xoaPhuongTien(String bienso){
        String query = "";
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
            query = "DELETE FROM phuongtien WHERE bienso = ?";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            preparedStatement.setString(1, bienso);
            preparedStatement.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("pt Serice k xoa dc: "+e.getMessage());
            return false;
        }
                       
        return true;
    }
    
    public boolean addPhuongTien_HK(int oto, int xemay, String mahk){
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
          
            String query = "Insert into phuongtien_hk (mahk, soOTO, soXM)Values (?,?,?);";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, mahk);

            preparedStatement.setInt(2, oto);
            preparedStatement.setInt(3, xemay);
            
            preparedStatement.executeUpdate();
            
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("pthk add Serice: "+e.getMessage());
            return false;
        }
        return true;
    } 
    
    public boolean updatePhuongTien_HK(int oto, int xemay, String mahk){
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
            String query = "UPDATE phuongtien_hk SET soOTO = soOTO +  ?, soXM = soXM + ? WHERE mahk = ?";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            preparedStatement.setInt(1, oto);
            preparedStatement.setInt(2, xemay);
            preparedStatement.setString(3, mahk);
           
            
            preparedStatement.executeUpdate();
            
            return true;
              
        } catch (Exception e) {
            System.out.println("kt Serice: "+e.getMessage());
            return false;
        }
    }  
    
    public ArrayList<PhuongTienHKModel> getDSPhuongTienHK(){
        ArrayList<PhuongTienHKModel> list = new ArrayList<>();
        
       
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
            String query = "SELECT * FROM phuongtien_hk INNER JOIN hokhau ON phuongtien_hk.mahk = hokhau.soNha INNER JOIN nhankhau ON nhankhau.CCCD = hokhau.IdChuHo";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = preparedStatement.executeQuery();
            
        while (rs.next()){
                
                PhuongTienHKModel pthk = new PhuongTienHKModel();
                pthk.setMahk(rs.getString("mahk"));
                pthk.setOto(rs.getInt("soOTO"));
                pthk.setXemay(rs.getInt("soXM"));
                pthk.setTenChuHo(rs.getString("hoTen"));
                pthk.setSoNha(rs.getString("soNha"));
                list.add(pthk);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("pthk Serice: "+e.getMessage());
        }
     
        return list;
    } 
    public PhuongTienHKModel getPhuongTienHK(String mahk){
        
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
            String query = "SELECT * FROM phuongtien_hk where mahk = "+mahk;
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = preparedStatement.executeQuery();
            
        if (rs.first()){
                
                PhuongTienHKModel pthk = new PhuongTienHKModel();
                pthk.setOto(rs.getInt("soOTO"));
                pthk.setXemay(rs.getInt("soXM"));
                return pthk;
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("pthk Serice: "+e.getMessage());
        }
        
        return null;

    }


    public ArrayList<PhuongTien> timKiemPhuongTien(String timkiem){
        ArrayList<PhuongTien> list = new ArrayList<>();
        String query = "";
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
            query = "SELECT * FROM phuongtien INNER JOIN nhankhau ON nhankhau.CCCD = phuongtien.maNK INNER JOIN hokhau ON hokhau.soNha = phuongtien.MaHK Where BienSo  like  ? OR nhankhau.hoTen like ?";
                
            preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, "%"+timkiem+"%");
            preparedStatement.setString(2, "%"+timkiem+"%");
                
        ResultSet rs = preparedStatement.executeQuery();
            
        while (rs.next()){      
                PhuongTien pt = new PhuongTien();
                pt.setSoNha(rs.getString("soNha"));
                pt.setTenChuXe(rs.getString("hoTen"));
                pt.setBienSo(rs.getString("BienSo"));
                pt.setLoaiXe(rs.getString("LoaiXe"));
                pt.setMahk(rs.getString("MaHK"));
                pt.setMank(rs.getString("MaNK"));                
                list.add(pt);
            }
            preparedStatement.close();
            connection.close();
            
        } catch (Exception e) {
            System.out.println("khoanthu Serice: "+e.getMessage());
        }
        return list;
        
    } 
    
 public ArrayList<PhuongTien> thongKePhuongTien(String q){
        ArrayList<PhuongTien> list = new ArrayList<>();
        String query = "";
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");

                query = "SELECT * FROM phuongtien INNER JOIN nhankhau ON nhankhau.CCCD = phuongtien.maNK INNER JOIN hokhau ON hokhau.soNha = phuongtien.MaHK Where "+q;
                
                preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
                ResultSet rs = preparedStatement.executeQuery();
            
        while (rs.next()){      
                PhuongTien pt = new PhuongTien();
                pt.setSoNha(rs.getString("soNha"));
                pt.setTenChuXe(rs.getString("hoTen"));
                pt.setBienSo(rs.getString("BienSo"));
                pt.setLoaiXe(rs.getString("LoaiXe"));
                pt.setMahk(rs.getString("MaHK"));
                pt.setMank(rs.getString("MaNK"));                
                list.add(pt);
            }
            preparedStatement.close();
            connection.close();
            
        } catch (Exception e) {
            System.out.println("pt Serice: "+e.getMessage());
        }
    
        return list;
    }        
}

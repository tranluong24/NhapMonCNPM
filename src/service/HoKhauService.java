/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.HoKhauModel;
import model.NhanKhauModel;
import model.ThanhVienModel;

/**
 *
 * @author MY PC
 */
public class HoKhauService {
    
    ArrayList<HoKhauModel> list = new ArrayList<HoKhauModel>();
    
    public ArrayList<HoKhauModel> getDSHoKhau(){
        list.removeAll(list);
       
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
            String query = "SELECT hokhau.soNha, hokhau.IdChuHo, hokhau.loaiSo,nhankhau.hoTen, hokhau.dienTich FROM hokhau INNER JOIN nhankhau ON nhankhau.CCCD = hokhau.IdChuHo";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = preparedStatement.executeQuery();
            
        while (rs.next()){
                
                HoKhauModel hokhau = new HoKhauModel();
                hokhau.setSoNha(rs.getString("soNha"));
                hokhau.setId_chu(rs.getString("IdChuHo"));
                hokhau.setLoaiSo(rs.getString("loaiSo"));
                hokhau.setTenChu(rs.getString("hoTen"));
                hokhau.setDienTich(rs.getInt("dienTich"));
                list.add(hokhau);
                //System.out.println(nhankhau.getHoTen()+"");
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Ho Khau Serice: "+e.getMessage());
        }
     
        return list;
    }
    public int slHoKhau(){
        String query = "";
        PreparedStatement preparedStatement = null;
        int soLuong = 0;
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
            query = "SELECT COUNT(*) AS SL FROM hokhau";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = preparedStatement.executeQuery();
            
            if(rs.first()){
                soLuong =  rs.getInt("SL");
            }
            
        } catch (Exception e) {
            System.out.println("HK k dem dc: "+e.getMessage());
            return 0;
        }
        return soLuong;
                       
    }    
    
    public boolean addHoKhau(HoKhauModel hk){
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
          
            String query = "Insert into hokhau (soNha, IdChuHo, loaiSo, dienTich)Values (?,?,?,?);";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, hk.getSoNha());
            
            preparedStatement.setString(2, hk.getId_chu());
            preparedStatement.setString(3, hk.getLoaiSo());
            preparedStatement.setInt(4, hk.getDienTich());
            
            preparedStatement.executeUpdate();
            
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Ho Khau Serice: "+e.getMessage());
            return false;
        }
        return true;
    }
    
    public HoKhauModel getHoKhau(String maHK){
        String query = "";
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
            query = "SELECT * FROM hokhau INNER JOIN nhankhau ON nhankhau.CCCD = hokhau.IdChuHo Where soNha = "+maHK;
            preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            if(rs.first()){
                HoKhauModel hokhau= new HoKhauModel();
                hokhau.setSoNha(rs.getString("soNha"));
                hokhau.setId_chu(rs.getString("IdChuHo"));
                hokhau.setLoaiSo(rs.getString("loaiSo"));
                hokhau.setTenChu(rs.getString("hoTen"));
                hokhau.setDienTich(rs.getInt("dienTich"));
                 
                return hokhau;
            }
        } catch (Exception e) {
            System.out.println("Ho Khau Serice: "+e.getMessage());
        }
                
        return null;
    }
    
    public boolean addThanhVien(ThanhVienModel tv){
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
          
            String query = "Insert into thanhvien(manhankhau, mahokhau, quanHeChuHo)Values (?,?,?);";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, tv.getIdNhanKhau());
            preparedStatement.setString(2, tv.getIdHoKhau());
            
            preparedStatement.setString(3, tv.getQuanHeVoiChuHo());
            System.out.println("hello"+tv.getIdNhanKhau()+tv.getIdHoKhau() +tv.getQuanHeVoiChuHo());
            
            preparedStatement.executeUpdate();
            
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Ho Khau Serice: "+e.getMessage());
            return false;
        }
        return true;
        
    }
    
    public ThanhVienModel getThanhVienHK(String CCCD){
                String query = "";
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
            query = "SELECT * FROM thanhvien Where manhankhau = "+CCCD;
            preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            if(rs.first()){
                ThanhVienModel tv = new ThanhVienModel();
                tv.setIdHoKhau(rs.getString("mahokhau"));
                tv.setIdNhanKhau(CCCD);
                tv.setQuanHeVoiChuHo(rs.getString("quanHeChuHo"));
                 
                return tv;
            }
        } catch (Exception e) {
            System.out.println("Ho Khau Serice: "+e.getMessage());
        }
                
        return null;
    }
    
    public boolean updateHKThanhVien(ThanhVienModel tv){
            try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
            String query = "UPDATE thanhvien SET manhankhau = ?, mahokhau = ?, quanHeChuHo = ? WHERE manhankhau =" + tv.getIdNhanKhau();
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            preparedStatement.setString(1, tv.getIdNhanKhau());
            preparedStatement.setString(2, tv.getIdHoKhau());
            preparedStatement.setString(3, tv.getQuanHeVoiChuHo());
           
            
            preparedStatement.executeUpdate();
            
            
              
        } catch (Exception e) {
            System.out.println("Nhan Khau Serice: "+e.getMessage());
        }
                
        return true;
    }
    
    public ArrayList<ThanhVienModel> getDSThanhVien(String maHK){
        ArrayList<ThanhVienModel> listTV = new ArrayList<ThanhVienModel>();
       
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
            String query = "SELECT * FROM thanhvien INNER JOIN nhankhau ON nhankhau.CCCD = thanhvien.manhankhau Where mahokhau = "+maHK;
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = preparedStatement.executeQuery();
            
        while (rs.next()){
                ThanhVienModel thanhvien = new ThanhVienModel();
                thanhvien.setIdHoKhau(rs.getString("mahokhau"));
                thanhvien.setIdNhanKhau(rs.getString("manhankhau"));
                thanhvien.setQuanHeVoiChuHo(rs.getString("quanHeChuHo"));
                thanhvien.setHoTen(rs.getString("hoTen"));
                listTV.add(thanhvien);
                System.out.println(thanhvien.getHoTen()+"");
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Ho Khau Serice: "+e.getMessage());
        }
     
        return listTV;
    }
    
    public ArrayList<HoKhauModel> timKiemHoKhau(String timkiem){
        list.removeAll(list);
        String query = "";
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
            if(timkiem.charAt(0)>='0' && timkiem.charAt(0)<='9'){
                query = "SELECT * FROM hokhau INNER JOIN nhankhau ON nhankhau.CCCD = hokhau.IdChuHo Where  soNha = "+timkiem;
                preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);}
            else {
                query = "SELECT * FROM hokhau INNER JOIN nhankhau ON nhankhau.CCCD = hokhau.IdChuHo Where nhankhau.hoTen like  ?";
                
                preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                preparedStatement.setString(1, "%"+timkiem+"%");
                
            }
            System.out.println(query);
        ResultSet rs = preparedStatement.executeQuery();
            
        while (rs.next()){      
                HoKhauModel hokhau = new HoKhauModel();
                hokhau.setSoNha(rs.getString("soNha"));
                hokhau.setId_chu(rs.getString("IdChuHo"));
                hokhau.setLoaiSo(rs.getString("loaiSo"));
                hokhau.setTenChu(rs.getString("hoTen"));
                hokhau.setDienTich(rs.getInt("dienTich"));
                list.add(hokhau);
            }
            preparedStatement.close();
            connection.close();
            
        } catch (Exception e) {
            System.out.println("HOKhau Serice: "+e.getMessage());
        }
        return list;
        
    }
}

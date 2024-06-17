/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import model.NhanKhauModel;
import view.NhanKhauView;

/**
 *
 * @author MY PC
 */
public class NhanKhauService {
    
    ArrayList<NhanKhauModel> list = new ArrayList<>();
    
    public boolean updateNhanKhau(String CCCD,NhanKhauModel nk){
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
            String query = "UPDATE nhankhau SET CCCD = ?, hoTen = ?, namSinh = ?,gioiTinh =?, nguyenQuan = ?,danToc = ?, quocTich = ?, ngheNghiep = ?,noiLamViec =?,diaChi = ?, tinhTrang = ? WHERE CCCD ="+CCCD;
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            preparedStatement.setString(1, nk.getCCCD());
            preparedStatement.setString(2, nk.getHoTen());
            
            java.util.Date dat = nk.getNamSinh();
            java.sql.Date sqldat = new java.sql.Date(dat.getTime());
            
            preparedStatement.setDate(3, sqldat);
            preparedStatement.setString(4, nk.getGioiTinh());
            preparedStatement.setString(5, nk.getNguyenQuan());
            preparedStatement.setString(6, nk.getDanToc());
            preparedStatement.setString(7, nk.getQuocTich());
            preparedStatement.setString(8, nk.getNgheNghiep());
            preparedStatement.setString(9, nk.getNoiLamViec());
            preparedStatement.setString(10,"BlueMoon");
            preparedStatement.setString(11, nk.getTinhTrang());
            preparedStatement.executeUpdate();
            
              
        } catch (Exception e) {
            System.out.println("Nhan Khau Serice: "+e.getMessage());
        }
                
        return true;
    }
    
    public ArrayList<NhanKhauModel> thongKeNhanKhau(String q){
        list.removeAll(list);
        String query = "";
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");

                query = "SELECT * FROM nhankhau Where "+q;
                
                preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
                ResultSet rs = preparedStatement.executeQuery();
            
        while (rs.next()){      
                NhanKhauModel nhankhau = new NhanKhauModel();
                nhankhau.setCCCD(rs.getString("CCCD"));
                nhankhau.setHoTen(rs.getString("hoTen"));
                nhankhau.setGioiTinh(rs.getString("gioiTinh"));
                nhankhau.setNamSinh(rs.getDate("namSinh"));
                nhankhau.setDiaChiHienNay(rs.getString("diaChi"));
                nhankhau.setNguyenQuan(rs.getString("nguyenQuan"));
                nhankhau.setDanToc(rs.getString("danToc"));
                nhankhau.setQuocTich(rs.getString("quocTich"));
                nhankhau.setNoiLamViec(rs.getString("noiLamViec"));
                nhankhau.setNgheNghiep(rs.getString("ngheNghiep"));
                nhankhau.setTinhTrang(rs.getString("tinhTrang"));
                list.add(nhankhau);
            }
            preparedStatement.close();
            connection.close();
            
        } catch (Exception e) {
            System.out.println("Nhan Khau Serice: "+e.getMessage());
        }
    
        return list;
    }
    
    public ArrayList<NhanKhauModel> timKiemNhanKhau(String timkiem){
        list.removeAll(list);
        String query = "";
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
            if(timkiem.charAt(0)>='0' && timkiem.charAt(0)<='9'){
                query = "SELECT * FROM nhankhau Where CCCD ="+timkiem;
                preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);}
            else {
                query = "SELECT * FROM nhankhau Where hoTen like  ?";
                
                preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                preparedStatement.setString(1, "%"+timkiem+"%");
                //System.out.println(query);
            }
            
        ResultSet rs = preparedStatement.executeQuery();
            
        while (rs.next()){      
                NhanKhauModel nhankhau = new NhanKhauModel();
                nhankhau.setCCCD(rs.getString("CCCD"));
                nhankhau.setHoTen(rs.getString("hoTen"));
                nhankhau.setGioiTinh(rs.getString("gioiTinh"));
                nhankhau.setNamSinh(rs.getDate("namSinh"));
                nhankhau.setDiaChiHienNay(rs.getString("diaChi"));
                nhankhau.setNguyenQuan(rs.getString("nguyenQuan"));
                nhankhau.setDanToc(rs.getString("danToc"));
                nhankhau.setQuocTich(rs.getString("quocTich"));
                nhankhau.setNoiLamViec(rs.getString("noiLamViec"));
                nhankhau.setNgheNghiep(rs.getString("ngheNghiep"));
                nhankhau.setTinhTrang(rs.getString("tinhTrang"));
                list.add(nhankhau);
            }
            preparedStatement.close();
            connection.close();
            
        } catch (Exception e) {
            System.out.println("Nhan Khau Serice: "+e.getMessage());
        }
     
      
        
        return list;
        
    }
    
    public NhanKhauModel getNhanKhau(String s){
        String query = "";
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
            if(s.length()>6)
                query = "SELECT * FROM nhankhau Where CCCD ="+s;
            else if (s.length() >0 && s.length() <=4){
                query = "SELECT * FROM nhankhau Where hoTen ="+s;
            }
            preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            if(rs.first()){
                NhanKhauModel nhankhau = new NhanKhauModel();
                nhankhau.setCCCD(rs.getString("CCCD"));
                nhankhau.setHoTen(rs.getString("hoTen"));
                nhankhau.setGioiTinh(rs.getString("gioiTinh"));
                nhankhau.setNamSinh(rs.getDate("namSinh"));
                nhankhau.setDiaChiHienNay(rs.getString("diaChi"));
                nhankhau.setNguyenQuan(rs.getString("nguyenQuan"));
                nhankhau.setDanToc(rs.getString("danToc"));
                nhankhau.setQuocTich(rs.getString("quocTich"));
                nhankhau.setNoiLamViec(rs.getString("noiLamViec"));
                nhankhau.setNgheNghiep(rs.getString("ngheNghiep"));
                nhankhau.setTinhTrang(rs.getString("tinhTrang"));
                return nhankhau;
            }
        } catch (Exception e) {
            System.out.println("Nhan Khau Serice: "+e.getMessage());
            System.out.println(query);
        }
                
        return null; 
    }
    
    public boolean xoaNhanKhau(String CCCD){
        String query = "";
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
            query = "DELETE FROM nhankhau WHERE CCCD = ?";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            preparedStatement.setString(1, CCCD);
            preparedStatement.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Nhan Khau Serice k xoa dc: "+e.getMessage());
            return false;
        }
                       
        return true;
    }
    
    public ArrayList<NhanKhauModel> getDSNhanKhau(){
        list.removeAll(list);

        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
            String query = "SELECT * FROM nhankhau";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = preparedStatement.executeQuery();
            
        while (rs.next()){
                
                NhanKhauModel nhankhau = new NhanKhauModel();
                nhankhau.setCCCD(rs.getString("CCCD"));
                nhankhau.setHoTen(rs.getString("hoTen"));
                nhankhau.setGioiTinh(rs.getString("gioiTinh"));
                nhankhau.setNamSinh(rs.getDate("namSinh"));
                nhankhau.setDiaChiHienNay(rs.getString("diaChi"));
                nhankhau.setNguyenQuan(rs.getString("nguyenQuan"));
                nhankhau.setDanToc(rs.getString("danToc"));
                nhankhau.setQuocTich(rs.getString("quocTich"));
                nhankhau.setNoiLamViec(rs.getString("noiLamViec"));
                nhankhau.setNgheNghiep(rs.getString("ngheNghiep"));
                nhankhau.setTinhTrang(rs.getString("tinhTrang"));
                list.add(nhankhau);
                System.out.println(nhankhau.getHoTen()+"");
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Nhan Khau Serice: "+e.getMessage());
        }
     
        return list;
    }  
    
    public int slNhanKhau(){
        String query = "";
        PreparedStatement preparedStatement = null;
        int soLuong = 0;
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
            query = "SELECT COUNT(*) AS SL FROM nhankhau";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = preparedStatement.executeQuery();
            
            if(rs.first()){
                soLuong =  rs.getInt("SL");
            }
            
        } catch (Exception e) {
            System.out.println("NK k dem dc: "+e.getMessage());
            return 0;
        }
        return soLuong;
                       
    }
    
    public boolean addNhanKhau(NhanKhauModel nk){
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
          
            String query = "Insert into nhankhau (CCCD, hoTen, namSinh, gioiTinh, nguyenQuan, danToc, quocTich, noiLamViec, ngheNghiep, tinhTrang, DiaChi)Values (?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, nk.getCCCD());
            preparedStatement.setString(2, nk.getHoTen());
            
            java.util.Date dat = nk.getNamSinh();
            java.sql.Date sqldat = new java.sql.Date(dat.getTime());
            
            preparedStatement.setDate(3, sqldat);
            preparedStatement.setString(4, nk.getGioiTinh());
            preparedStatement.setString(5, nk.getNguyenQuan());
            preparedStatement.setString(6, nk.getDanToc());
            preparedStatement.setString(7, nk.getQuocTich());
            preparedStatement.setString(8, nk.getNoiLamViec());
            preparedStatement.setString(9, nk.getNgheNghiep());
            preparedStatement.setString(10,nk.getTinhTrang());
            preparedStatement.setString(11,nk.getDiaChiHienNay());
            
            preparedStatement.executeUpdate();
            
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("add NK Serice: "+e.getMessage());
            return false;
        }
        return true;
    }
}

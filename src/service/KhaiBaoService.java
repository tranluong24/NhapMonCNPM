/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.TamTruTamVangModel;

/**
 *
 * @author MY PC
 */
public class KhaiBaoService {
    public ArrayList<TamTruTamVangModel> getDSKhaiBao(){
        ArrayList<TamTruTamVangModel> list = new ArrayList<>();
        
       
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
            String query = "SELECT * FROM tamtrutamvang  INNER JOIN nhankhau ON nhankhau.CCCD = tamtrutamvang.CCCD";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = preparedStatement.executeQuery();
            
        while (rs.next()){
                
                TamTruTamVangModel khaibao = new TamTruTamVangModel();
                khaibao.setCCCD(rs.getString("CCCD"));
                khaibao.setLoaiDangKy(rs.getString("loaiDangKy"));
                khaibao.setBatDau(rs.getDate("batDau"));
                khaibao.setKetThuc(rs.getDate("ketThuc"));
                khaibao.setDiaDiem(rs.getString("diaDiem"));
                khaibao.setTinhTrang(rs.getString("tinhTrang"));
                khaibao.setName(rs.getString("hoTen"));
                list.add(khaibao);
                //System.out.println(nhankhau.getHoTen()+"");
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("khai bao Serice: "+e.getMessage());
        }
     
        return list;
    }    

    public ArrayList<Integer> slKhaiBao(){
        String query = "";
        PreparedStatement preparedStatement = null;
        int soLuongTT = 0;
        int soLuongTV = 0;
        ArrayList<Integer> list = new ArrayList<>();
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
            query = "SELECT SUM(CASE WHEN loaiDangKy = ? THEN 1 ELSE 0 END) AS SLTT, SUM(CASE WHEN loaiDangKy = ? THEN 1 ELSE 0 END) AS SLTV  FROM tamtrutamvang";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, "Tạm trú");
            preparedStatement.setString(2, "Tạm vắng");
            ResultSet rs = preparedStatement.executeQuery();
            
            if(rs.first()){
                soLuongTT =  rs.getInt("SLTT");
                soLuongTV =  rs.getInt("SLTV");
                list.add(soLuongTT);
                list.add(soLuongTV);
            }
        } catch (Exception e) {
            System.out.println("NK k dem dc: "+e.getMessage());
            
        }
        return list;
                       
    }
    
    public boolean addKhaiBao(TamTruTamVangModel kb){
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
          
            String query = "Insert into tamtrutamvang (CCCD, loaiDangKy, batDau, ketThuc, diaDiem, liDo)Values (?,?,?,?,?,?);";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, kb.getCCCD());
            preparedStatement.setString(2, kb.getLoaiDangKy());
            
            java.util.Date dat1 = kb.getBatDau();
            java.sql.Date sqldat1 = new java.sql.Date(dat1.getTime());
            preparedStatement.setDate(3, sqldat1);
            
            java.util.Date dat = kb.getKetThuc();
            java.sql.Date sqldat = new java.sql.Date(dat.getTime());
            preparedStatement.setDate(4, sqldat);
            
            preparedStatement.setString(5, kb.getDiaDiem());
            
            preparedStatement.setString(6, kb.getLido());
            
            preparedStatement.executeUpdate();
            
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("tttv Service: "+e.getMessage());
            return false;
        }
        return true;
    }   
    
    public TamTruTamVangModel xemKhaiBao(String s, String tinhTrang){
        String query = "";
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
            query = "SELECT * FROM tamtrutamvang INNER JOIN nhankhau ON nhankhau.CCCD = tamtrutamvang.CCCD Where tamtrutamvang.CCCD ="+s+" AND loaiDangKy = ?";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, tinhTrang);
            ResultSet rs = preparedStatement.executeQuery();
            
            if(rs.first()){
                TamTruTamVangModel khaibao = new TamTruTamVangModel();
                khaibao.setCCCD(rs.getString("tamtrutamvang.CCCD"));
                khaibao.setLoaiDangKy(rs.getString("loaiDangKy"));
                System.out.println(khaibao.getLoaiDangKy()+"");
                khaibao.setBatDau(rs.getDate("batDau"));
                khaibao.setKetThuc(rs.getDate("ketThuc"));
                khaibao.setDiaDiem(rs.getString("diaDiem"));
                khaibao.setLido(rs.getString("liDo"));
                khaibao.setTinhTrang(rs.getString("tinhTrang"));
                return khaibao;
            }
        } catch (Exception e) {
            System.out.println("ttmtSerice: "+e.getMessage());
            System.out.println(query);
        }
                
        return null; 
    }
     public boolean xoaKhaiBao(String CCCD, String tinhTrang){
        String query = "";
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
            query = "DELETE FROM tamtrutamvang WHERE CCCD = ? AND loaiDangKy = ?";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            preparedStatement.setString(1, CCCD);
            preparedStatement.setString(2, tinhTrang);
            preparedStatement.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("tmtv Serice k xoa dc: "+e.getMessage());
            return false;
        }
                       
        return true;
    }    
}

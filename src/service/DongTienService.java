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

/**
 *
 * @author MY PC
 */
public class DongTienService {
    
    public ArrayList<DongTienModel> getDSKhoanThu(String maHK){
        ArrayList<DongTienModel> list = new ArrayList<>();
       
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
            String query = "SELECT * FROM dongtien INNER JOIN khoanthu ON dongtien.maKhoanThu = khoanthu.idKhoanThu WHERE maHoKhau = '"+maHK+"'";
            
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = preparedStatement.executeQuery();
            
        while (rs.next()){    
                DongTienModel dongtien = new DongTienModel();
                dongtien.setMaKhoanThu(rs.getString("maKhoanThu"));
                dongtien.setMaHoKhau(rs.getString("maHoKhau"));
                dongtien.setSoTien(rs.getInt("soTien"));
                dongtien.setNgayDong(rs.getDate("ngayDong"));
                dongtien.setTrangThai(rs.getString("trangThai"));
                dongtien.setTenKhoanThu(rs.getString("tenKhoanThu"));
                
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
    
    public DongTienModel getThongTinHoKhau(String maHK){
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
            String query = "SELECT * FROM hokhau INNER JOIN nhankhau ON hokhau.IdChuHo = nhankhau.CCCD WHERE soNha = "+maHK;
            
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = preparedStatement.executeQuery();
            
        if(rs.first()){    
                DongTienModel dongtien = new DongTienModel();
                dongtien.setTenChuHo(rs.getString("hoTen"));
                dongtien.setSoNha(rs.getString("soNha"));
                dongtien.setDienTich(rs.getInt("dienTich"));
                System.out.println(maHK);
                
                return dongtien;
                
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("âcscas: "+e.getMessage());
        }
        return null;
    }  
    
    public boolean updateCacKhoanThu(ArrayList<DongTienModel> list){
            
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
            String query = "UPDATE dongtien SET ngayDong = ?, trangThai = ?, soTien = ? WHERE maHoKhau = ? AND maKhoanThu = ?";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            
            for(DongTienModel d : list){
                if(d.getNgayDong()!=null){
                    java.util.Date dat = d.getNgayDong();
                    java.sql.Date sqldat = new java.sql.Date(dat.getTime());
                    System.out.println(sqldat +" "+d.getTrangThai()+" "+d.getMaHoKhau()+" " +d.getMaKhoanThu());
                    preparedStatement.setDate(1, sqldat);
                    preparedStatement.setString(2, d.getTrangThai());
                    preparedStatement.setInt(3,d.getSoTien());
                    preparedStatement.setString(4, d.getMaHoKhau());
                    preparedStatement.setString(5, d.getMaKhoanThu());
                    
                }
               
                preparedStatement.addBatch();
                
            }

            preparedStatement.executeBatch();
        } catch (Exception e) {
            System.out.println("Helo Serice: "+e.getMessage());
        }
                
        return true;
    }
}

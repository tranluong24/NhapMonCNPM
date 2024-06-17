/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.NhanKhauModel;
import model.TaiKhoanModel;

/**
 *
 * @author MY PC
 */
public class TaiKhoanService {
    public TaiKhoanModel login(String s){
        String query = "";
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
            query = "SELECT * FROM taikhoan Where username = ?";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, s);
            ResultSet rs = preparedStatement.executeQuery();
            
            if(rs.first()){
                TaiKhoanModel taikhoan = new TaiKhoanModel();
                taikhoan.setUsername(rs.getString("username"));
                taikhoan.setPassword(rs.getString("password"));
                taikhoan.setRole(rs.getString("role"));
                return taikhoan;
            }
        } catch (Exception e) {
            System.out.println("tai khoan Service: "+e.getMessage());
            System.out.println(query);
        }
                
        return null; 
    }
    
 public boolean addTaiKhoan(TaiKhoanModel tk){
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
          
            String query = "Insert into taikhoan (username, password, role)Values (?,?,?);";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, tk.getUsername());
            preparedStatement.setString(2, tk.getPassword());
            preparedStatement.setString(3, tk.getRole());
            
            preparedStatement.executeUpdate();
            
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("tk Serice: "+e.getMessage());
            return false;
        }
        return true;
    }
    
    public boolean xoaTaiKhoan(String userOld){
        String query = "";
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
            query = "DELETE FROM taikhoan WHERE username = ?";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            preparedStatement.setString(1, userOld);
            preparedStatement.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Nhan Khau Serice k xoa dc: "+e.getMessage());
            return false;
        }
                       
        return true;
    }
    public TaiKhoanModel thongTinTaiKhoan(String role){
        String query = "";
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
            query = "SELECT * FROM taikhoan Where role = ?";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, role);
            ResultSet rs = preparedStatement.executeQuery();
            
            if(rs.first()){
                TaiKhoanModel taikhoan = new TaiKhoanModel();
                taikhoan.setUsername(rs.getString("username"));
                taikhoan.setPassword(rs.getString("password"));
                taikhoan.setRole(rs.getString("role"));
                return taikhoan;
            }
        } catch (Exception e) {
            System.out.println("tai khoan Service: "+e.getMessage());
            System.out.println(query);
        }
                
        return null; 
    }    
    
}

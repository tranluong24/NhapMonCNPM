/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.PhuongTienHKModel;
import model.ThuHoModel;

/**
 *
 * @author MY PC
 */
public class ThuHoService {
    public ThuHoModel getThuHo(String mahk,String loai){
        
        try {
            Connection connection = mysqlConnection.getMysqlConnection("localhost", "qlhokhau", "root", "123456");
            String query = "SELECT * FROM thuho_hk INNER JOIN khoanthu ON khoanthu.idKhoanThu = thuho_hk.mkhoanthu INNER JOIN phithuho ON khoanthu.idKhoanThu = phithuho.maKhoanThu where maHK = ? AND loaiDichVu = ?";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, mahk);
            preparedStatement.setString(2, loai);
            
            
            ResultSet rs = preparedStatement.executeQuery();
            
        if (rs.first()){
                ThuHoModel th = new ThuHoModel();
                th.setSuDung(rs.getString("suDung"));
                return th;
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("thuho Serice: "+e.getMessage());
        }
        
        return null;

    }
}

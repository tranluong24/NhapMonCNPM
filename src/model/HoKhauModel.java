/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author MY PC
 */
public class HoKhauModel {
    private String soNha;
    private String id_chu;
    private String tenChu;
    private String loaiSo;
    private int DienTich;
    
    public HoKhauModel(){
        
    }

    public HoKhauModel(String soNha, String id_chu, String loaiSo,String tenChu, int DienTich) {
        //this.id = id;
        this.soNha = soNha;
        this.id_chu = id_chu;
        this.loaiSo = loaiSo;
        this.tenChu = tenChu;
        this.DienTich = DienTich;
    }

    public int getDienTich() {
        return DienTich;
    }

    public void setDienTich(int DienTich) {
        this.DienTich = DienTich;
    }
    
    

    public String getTenChu() {
        return tenChu;
    }

    public void setTenChu(String tenChu) {
        this.tenChu = tenChu;
    }
    

    public String getSoNha() {
        return soNha;
    }

    public void setSoNha(String soNha) {
        this.soNha = soNha;
    }

    public String getId_chu() {
        return id_chu;
    }

    public void setId_chu(String id_chu) {
        this.id_chu = id_chu;
    }

    public String getLoaiSo() {
        return loaiSo;
    }

    public void setLoaiSo(String loaiSo) {
        this.loaiSo = loaiSo;
    }
    
    
    
    
}

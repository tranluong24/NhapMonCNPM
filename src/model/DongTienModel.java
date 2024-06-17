/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author MY PC
 */
public class DongTienModel {
    private String maKhoanThu;
    private String maHoKhau;
    
   
    private String soNha;
    private Date ngayDong;
    private int soTien;
    private String trangThai;
    
    
    private String tenKhoanThu;
     private String tenChuHo;
    private int DienTich;

    public DongTienModel(String maKT, String maHK, String ten, String tenKT, String soNha, Date ngay, int soTien, String trangThai) {
        this.maKhoanThu = maKT;
        this.maHoKhau = maHK;
        this.tenChuHo = ten;
        this.soNha = soNha;
        this.tenKhoanThu = tenKT;
        this.ngayDong = ngay;
        this.soTien = soTien;
        this.trangThai  = trangThai;
    }

    public DongTienModel(String maKhoanThu, String maHoKhau, int soTien, String trangThai, Date ngay) {
        this.maKhoanThu = maKhoanThu;
        this.maHoKhau = maHoKhau;
        this.soTien = soTien;
        this.trangThai = trangThai;
        this.ngayDong = ngay;
    }
    
    

    public DongTienModel() {
    }

    public int getDienTich() {
        return DienTich;
    }

    public void setDienTich(int DienTich) {
        this.DienTich = DienTich;
    }
    

    public String getMaKhoanThu() {
        return maKhoanThu;
    }

    public void setMaKhoanThu(String maKhoanThu) {
        this.maKhoanThu = maKhoanThu;
    }

    public void setMaHoKhau(String maHoKhau) {
        this.maHoKhau = maHoKhau;
    }

    public String getMaHoKhau() {
        return maHoKhau;
    }

    public void setSoNha(String soNha) {
        this.soNha = soNha;
    }

    public String getSoNha() {
        return soNha;
    }

    public int getSoTien() {
        return soTien;
    }

    public void setSoTien(int soTien) {
        this.soTien = soTien;
    }

    public Date getNgayDong() {
        return ngayDong;
    }

    public void setNgayDong(Date ngayDong) {
        this.ngayDong = ngayDong;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getTenChuHo() {
        return tenChuHo;
    }

    public void setTenChuHo(String tenChuHo) {
        this.tenChuHo = tenChuHo;
    }

    public String getTenKhoanThu() {
        return tenKhoanThu;
    }

    public void setTenKhoanThu(String tenKhoanThu) {
        this.tenKhoanThu = tenKhoanThu;
    }
    
}

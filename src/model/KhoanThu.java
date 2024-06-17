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
public class KhoanThu {
    
   private String idKhoanThu;
   private String tenKhoanThu;
   private String loaiKhoanThu;
   private Date NgayBatDau;
   private String trangThai;
   
   private int DonGia;
   
   private String tenCongTy;
   private String dichVu;
   
   private int oto;
   private int xemay;
   
   private int tongThu;

    public KhoanThu(String id, String name, String loai, Date ngay, String trangThai, int DonGia, String tenct, String dv, int oto, int xemay) {
        this.idKhoanThu = id;
        this.tenKhoanThu = name;
        this.NgayBatDau = ngay;
        this.loaiKhoanThu = loai;
        this.trangThai = trangThai;
        
        this.DonGia = DonGia;
        
        this.tenCongTy = tenct;
        this.dichVu = dv;
        
        this.oto = oto;
        this.xemay = xemay;
                
        
        
    }

    public KhoanThu() {
    }

    public int getTongThu() {
        return tongThu;
    }

    public void setTongThu(int tongThu) {
        this.tongThu = tongThu;
    }
    
    

    public String getIdKhoanThu() {
        return idKhoanThu;
    }

    public void setIdKhoanThu(String idKhoanThu) {
        this.idKhoanThu = idKhoanThu;
    }

    public String getLoaiKhoanThu() {
        return loaiKhoanThu;
    }

    public void setLoaiKhoanThu(String loaiKhoanThu) {
        this.loaiKhoanThu = loaiKhoanThu;
    }

    public String getTenKhoanThu() {
        return tenKhoanThu;
    }

    public void setTenKhoanThu(String tenKhoanThu) {
        this.tenKhoanThu = tenKhoanThu;
    }

    public Date getNgayBatDau() {
        return NgayBatDau;
    }

    public void setNgayBatDau(Date NgayBatDau) {
        this.NgayBatDau = NgayBatDau;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getDonGia() {
        return DonGia;
    }

    public void setDonGia(int DonGia) {
        this.DonGia = DonGia;
    }

    public String getTenCongTy() {
        return tenCongTy;
    }

    public void setTenCongTy(String tenCongTy) {
        this.tenCongTy = tenCongTy;
    }

    public String getDichVu() {
        return dichVu;
    }

    public void setDichVu(String dichVu) {
        this.dichVu = dichVu;
    }

    public int getOto() {
        return oto;
    }

    public void setOto(int oto) {
        this.oto = oto;
    }

    public int getXemay() {
        return xemay;
    }

    public void setXemay(int xemay) {
        this.xemay = xemay;
    }
    
    
    
}

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
public class NhanKhauModel {
    //private int ID;
    private String CCCD;
    private String hoTen;
    private Date namSinh;
    private String gioiTinh;
    private String nguyenQuan;
    private String danToc;
    private String quocTich;
    private String noiLamViec;
    private String diaChiHienNay;
    private String ngheNghiep;
    private String tinhTrang;

    public NhanKhauModel(String CCCD, String hoTen, Date namSinh, String gioiTinh,String nguyenQuan, String danToc, String quocTich,String noiLamViec,String diaChi,String ngheNghiep,String tinhTrang){
        this.CCCD = CCCD;
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.gioiTinh = gioiTinh;
        this.nguyenQuan = nguyenQuan;
        this.danToc = danToc;
        this.quocTich = quocTich;
        this.noiLamViec = noiLamViec;
        this.diaChiHienNay = diaChi;
        this.ngheNghiep = ngheNghiep;
        this.tinhTrang = tinhTrang;
    }
    
    public NhanKhauModel(){
        
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(Date namSinh) {
        this.namSinh = namSinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgheNghiep() {
        return ngheNghiep;
    }

    public void setNgheNghiep(String ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
    }

    public String getNguyenQuan() {
        return nguyenQuan;
    }

    public void setNguyenQuan(String nguyenQuan) {
        this.nguyenQuan = nguyenQuan;
    }

    public String getDanToc() {
        return danToc;
    }

    public void setDanToc(String danToc) {
        this.danToc = danToc;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public String getDiaChiHienNay() {
        return diaChiHienNay;
    }

    public void setDiaChiHienNay(String diaChiHienNay) {
        this.diaChiHienNay = diaChiHienNay;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getNoiLamViec() {
        return noiLamViec;
    }

    public void setNoiLamViec(String noiLamViec) {
        this.noiLamViec = noiLamViec;
    }
    
    
    
    
    
}

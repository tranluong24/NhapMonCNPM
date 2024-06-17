/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author MY PC
 */
public class ThanhVienModel {
    private String idNhanKhau;
    private String idHoKhau;
    private String quanHeVoiChuHo;
    private String hoTen;

    public ThanhVienModel(String idNhanKhau, String idHoKhau, String quanhe,String hoTen) {
        this.idNhanKhau = idNhanKhau;
        this.idHoKhau = idHoKhau;
        this.quanHeVoiChuHo = quanhe;
        this.hoTen = hoTen;
    }

    public ThanhVienModel() {
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    
    

    public String getIdHoKhau() {
        return idHoKhau;
    }

    public void setIdHoKhau(String idHoKhau) {
        this.idHoKhau = idHoKhau;
    }

    public String getIdNhanKhau() {
        return idNhanKhau;
    }

    public void setIdNhanKhau(String idNhanKhau) {
        this.idNhanKhau = idNhanKhau;
    }
    
    

    public String getQuanHeVoiChuHo() {
        return quanHeVoiChuHo;
    }

    public void setQuanHeVoiChuHo(String quanHeVoiChuHo) {
        this.quanHeVoiChuHo = quanHeVoiChuHo;
    }
    
}

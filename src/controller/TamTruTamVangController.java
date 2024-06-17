/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import HoKhauView.QuanLiTinhTrangView;
import model.TamTruTamVangModel;
import service.KhaiBaoService;

/**
 *
 * @author MY PC
 */
public class TamTruTamVangController {
    QuanLiTinhTrangView view;
    TamTruTamVangModel model;
    KhaiBaoService service;

    public TamTruTamVangController(QuanLiTinhTrangView view) {
        this.service = new KhaiBaoService();
        this.view = view;
    }
    
    public void getKhaiBaoTable(){
      view.hienThiBangKhaiBao(service.getDSKhaiBao());
    }  
}

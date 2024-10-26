/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom2.qlsv.model;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class LopHoc {
    private int ma_lop_hoc;
    private Khoahoc khoaHoc;
    private SinhVien hocVien;
    private Date ngay_dang_ki;
    private boolean tinh_trang;

    public int getMa_lop_hoc() {
        return ma_lop_hoc;
    }

    public void setMa_lop_hoc(int ma_lop_hoc) {
        this.ma_lop_hoc = ma_lop_hoc;
    }

    public Khoahoc getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(Khoahoc khoaHoc) {
        this.khoaHoc = khoaHoc;
    }

    public SinhVien getHocVien() {
        return hocVien;
    }

    public void setHocVien(SinhVien hocVien) {
        this.hocVien = hocVien;
    }

    public Date getNgay_dang_ki() {
        return ngay_dang_ki;
    }

    public void setNgay_dang_ki(Date ngay_dang_ki) {
        this.ngay_dang_ki = ngay_dang_ki;
    }

    public boolean isTinh_trang() {
        return tinh_trang;
    }

    public void setTinh_trang(boolean tinh_trang) {
        this.tinh_trang = tinh_trang;
    }
    
}

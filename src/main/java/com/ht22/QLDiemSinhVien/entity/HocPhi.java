package com.ht22.QLDiemSinhVien.entity;

import java.util.Date;

public class HocPhi {
    private int maHocPhi;
    private String maSV;
    private String tenKhoanPhi;
    private double soTien;
    private Date ngayDong;
    private String trangThai;

    // Constructor không đối số
    public HocPhi() {}

    // Constructor đầy đủ đối số
    public HocPhi(int maHocPhi, String maSV, String tenKhoanPhi, double soTien, Date ngayDong, String trangThai) {
        this.maHocPhi = maHocPhi;
        this.maSV = maSV;
        this.tenKhoanPhi = tenKhoanPhi;
        this.soTien = soTien;
        this.ngayDong = ngayDong;
        this.trangThai = trangThai;
    }

    // Getter và Setter cho các thuộc tính
    public int getMaHocPhi() {
        return maHocPhi;
    }

    public void setMaHocPhi(int maHocPhi) {
        this.maHocPhi = maHocPhi;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getTenKhoanPhi() {
        return tenKhoanPhi;
    }

    public void setTenKhoanPhi(String tenKhoanPhi) {
        this.tenKhoanPhi = tenKhoanPhi;
    }

    public double getSoTien() {
        return soTien;
    }

    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }

    public java.sql.Date getNgayDong() {
        return (java.sql.Date) ngayDong;
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

    // Override phương thức toString() để in thông tin HocPhi
    @Override
    public String toString() {
        return "HocPhi{" +
                "maHocPhi=" + maHocPhi +
                ", maSV='" + maSV + '\'' +
                ", tenKhoanPhi='" + tenKhoanPhi + '\'' +
                ", soTien=" + soTien +
                ", ngayDong=" + ngayDong +
                ", trangThai='" + trangThai + '\'' +
                '}';
    }
}

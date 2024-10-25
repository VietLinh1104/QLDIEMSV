/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ht22.QLDiemSinhVien.entity;

/**
 *
 * @author Admin
 */
public class Diem {
    private int maDiem;
    private String maSV;
    private String maHocPhan;
    private int solanthi;
    private float diemgiuaki;
    private float diemcuoiki;
    private String diemchu;

    public Diem() {
    }

    public Diem(int maDiem, String maSV, String maHocPhan, int solanthi, float diemgiuaki, float diemcuoiki, String diemchu) {
        this.maDiem = maDiem;
        this.maSV = maSV;
        this.maHocPhan = maHocPhan;
        this.solanthi = solanthi;
        this.diemgiuaki = diemgiuaki;
        this.diemcuoiki = diemcuoiki;
        this.diemchu = diemchu;
    }

    public int getMaDiem() {
        return maDiem;
    }

    public void setMaDiem(int maDiem) {
        this.maDiem = maDiem;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getMaHocPhan() {
        return maHocPhan;
    }

    public void setMaHocPhan(String maHocPhan) {
        this.maHocPhan = maHocPhan;
    }

    public int getSolanthi() {
        return solanthi;
    }

    public void setSolanthi(int solanthi) {
        this.solanthi = solanthi;
    }

    public float getDiemgiuaki() {
        return diemgiuaki;
    }

    public void setDiemgiuaki(float diemgiuaki) {
        this.diemgiuaki = diemgiuaki;
    }

    public float getDiemcuoiki() {
        return diemcuoiki;
    }

    public void setDiemcuoiki(float diemcuoiki) {
        this.diemcuoiki = diemcuoiki;
    }

    public String getDiemchu() {
        return diemchu;
    }

    public void setDiemchu(String diemchu) {
        this.diemchu = diemchu;
    }
}

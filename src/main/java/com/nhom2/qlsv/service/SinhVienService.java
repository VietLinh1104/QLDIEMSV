/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom2.qlsv.service;

import com.nhom2.qlsv.model.SinhVien;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface SinhVienService {
    public List<SinhVien> getList();
    
    public String createOrUpdate(SinhVien sinhVien);
    
    public void deleteSinhVien(String maSinhVien); // Thêm phương thức xóa
}


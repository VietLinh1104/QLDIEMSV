/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ht22.QLDiemSinhVien.DAO;

import com.ht22.QLDiemSinhVien.entity.SinhVien;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface SinhVienDAO {
    public List<SinhVien> getList();
    public String createOrUpdate(SinhVien sinhVien);
  
    public void deleteSinhVien(String maSinhVien); // Thêm phương thức xóa
}

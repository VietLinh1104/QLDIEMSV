/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ht22.QLDiemSinhVien.service;
import com.ht22.QLDiemSinhVien.DAO.SinhVienDAO;
import com.ht22.QLDiemSinhVien.DAO.SinhVienDAOImpl;
import com.ht22.QLDiemSinhVien.entity.SinhVien;

import java.util.List;
/**
 *
 * @author DELL
 */
public class SinhVienServiceImpl implements SinhVienService {

    private SinhVienDAO sinhVienDAO = null;
    
    public SinhVienServiceImpl(){
        sinhVienDAO = new SinhVienDAOImpl();
        
    }
    
    @Override
    public List<SinhVien> getList() {
            return sinhVienDAO.getList();
        
    }

    @Override
    public String createOrUpdate(SinhVien sinhVien) {
        return sinhVienDAO.createOrUpdate(sinhVien);
    }
    
    
    @Override
    public void deleteSinhVien(String maSinhVien) {
        sinhVienDAO.deleteSinhVien(maSinhVien);
    }
    
  
  
    
    
}

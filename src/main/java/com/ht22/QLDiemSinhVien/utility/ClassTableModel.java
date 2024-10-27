/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ht22.QLDiemSinhVien.utility;

import com.ht22.QLDiemSinhVien.entity.SinhVien;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class ClassTableModel {
    
    public DefaultTableModel setTableSinhVien ( List<SinhVien> listItem, String[] listColumn){
    DefaultTableModel dtm = new DefaultTableModel(){
        @Override
        public boolean isCellEditable ( int row, int column){
            return false;
        }
        
        @Override
        public Class<?> getColumnClass(int columnIndex){
            return columnIndex == 7 ? Boolean.class : String.class;
        }
        
    };
    dtm.setColumnIdentifiers(listColumn);
    int columns = listColumn.length;
    Object[] obj = null;
    int rows = listItem.size();
    if(rows > 0){
        for (int i = 0; i<rows; i++){
            SinhVien sinhVien = listItem.get(i);
            obj = new Object[columns];
          
            obj[0] = sinhVien.getMaSV();
            obj[1] = ( i + 1 );
            obj[2] = sinhVien.getHoTen();
            obj[3] = sinhVien.getNgaySinh();
            obj[4] = sinhVien.isGioiTinh() == true ? "Nam" : "Nu";
            obj[5] = sinhVien.getSoDT();
            obj[6] = sinhVien.getDiaChi();
            obj[7] = sinhVien.isTinhTrang();
            dtm.addRow(obj);
            
        }
    
    }
    
    
    return dtm;
    
    }
    
}

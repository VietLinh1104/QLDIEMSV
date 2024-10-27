/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom3.qlsv.controller;

import com.nhom2.qlsv.model.SinhVien;
import com.nhom2.qlsv.service.SinhVienService;
import com.nhom2.qlsv.service.SinhVienServiceImpl;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author DELL
 */
public class SinhVienController {
    private JButton btnSubmit;
    private JTextField jtfMaSinhVien;
    private JTextField jtfHoTen;
    private JDateChooser jdcNgaySinh;
    private JRadioButton jrdNam;
    private JRadioButton jrdNu;
    private JTextField jtfSoDienThoai;
    private JTextArea jtaDiaChi;
    private JCheckBox jcbTinhTrang;
    
    private JLabel jlbMsg;
    
    private SinhVien sinhVien = null;
    
    private SinhVienService sinhVienService = null;
    

    public SinhVienController(JButton btnSubmit, JTextField jtfMaSinhVien, JTextField jtfHoTen,
            JDateChooser jdcNgaySinh, JRadioButton jrdNam, JRadioButton jrdNu, JTextField jtfSoDienThoai,
            JTextArea jtaDiaChi, JCheckBox jcbTinhTrang, JLabel jlbMsg) {
        this.btnSubmit = btnSubmit;
        this.jtfMaSinhVien = jtfMaSinhVien;
        this.jtfHoTen = jtfHoTen;
        this.jdcNgaySinh = jdcNgaySinh;
        this.jrdNam = jrdNam;
        this.jrdNu = jrdNu;
        this.jtfSoDienThoai = jtfSoDienThoai;
        this.jtaDiaChi = jtaDiaChi;
        this.jcbTinhTrang = jcbTinhTrang;
        this.jlbMsg = jlbMsg;
        
        this.sinhVienService = new SinhVienServiceImpl();
    }

    


    
    public void setView(SinhVien sinhVien){
        this.sinhVien = sinhVien;
        
       jtfMaSinhVien.setText("#"+sinhVien.getMaSV());
       jtfHoTen.setText(sinhVien.getHoTen());
       jdcNgaySinh.setDate(sinhVien.getNgaySinh());
       if(sinhVien.isGioiTinh()){
           jrdNam.setSelected(true);
           jrdNam.setSelected(false);
           
       }else{
           jrdNam.setSelected(false);
           jrdNam.setSelected(true);
       }
       jtfSoDienThoai.setText(sinhVien.getSoDT());
       jtaDiaChi.setText(sinhVien.getDiaChi());
       jcbTinhTrang.setSelected(sinhVien.isTinhTrang());
       
    }
    // nut luu 
    public void setEvent() {
    btnSubmit.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                if (jtfHoTen.getText().length() == 0 || jdcNgaySinh.getDate() == null) {
                    jlbMsg.setText("Nhập dữ liệu đang trống!");
                    
                   
                } else {
                // Kiểm tra số điện thoại
                String soDienThoai = jtfSoDienThoai.getText();
                if (!soDienThoai.matches("^0\\d{9}$")) {
                    jlbMsg.setText("Số điện thoại phải bắt đầu bằng 0 và có 10 chữ số!");
                    return;
                }
                    
                    sinhVien.setMaSV(jtfMaSinhVien.getText());
                    sinhVien.setMaLop("HT22");
                    sinhVien.setHoTen(jtfHoTen.getText());
                    sinhVien.setNgaySinh(jdcNgaySinh.getDate());
                    sinhVien.setGioiTinh(jrdNam.isSelected());
                    sinhVien.setSoDT(jtfSoDienThoai.getText());
                    sinhVien.setDiaChi(jtaDiaChi.getText());
                    sinhVien.setTinhTrang(jcbTinhTrang.isSelected());

                    String lastId = sinhVienService.createOrUpdate(sinhVien);

                }
            } catch (Exception ex) {
                ex.printStackTrace();  // In lỗi ra console để kiểm tra
                jlbMsg.setText("Đã xảy ra lỗi khi cập nhật dữ liệu!");
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            btnSubmit.setBackground(new Color(0, 200, 83));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            btnSubmit.setBackground(new Color(100, 221, 23));
        }
    });
}
    
}

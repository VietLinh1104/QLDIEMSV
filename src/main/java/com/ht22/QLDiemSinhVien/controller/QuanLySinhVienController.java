/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ht22.QLDiemSinhVien.controller;

import com.ht22.QLDiemSinhVien.entity.SinhVien;
import com.ht22.QLDiemSinhVien.service.SinhVienService;
import com.ht22.QLDiemSinhVien.service.SinhVienServiceImpl;
import com.ht22.QLDiemSinhVien.utility.ClassTableModel;
import com.ht22.QLDiemSinhVien.views.frames.view.SinhVienJFrame;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;


/**
 *
 * @author DELL
 */
public class QuanLySinhVienController {
    
    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    private JButton btnDelete;
    
    private SinhVienService sinhVienService = null;
    
    private String[] listColumn = {"Ma sinh vien", " STT ", "Ho ten", "Ngay sinh", "Gioi tinh", "So dien thoai","Dia chi","Tinh trang"};

    private TableRowSorter<TableModel> rowSorter = null;
    private JTable table; // Thêm biến thành viên cho JTable
    
    public QuanLySinhVienController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch,JButton btnDelete) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        this.btnDelete = btnDelete;
        
        this.sinhVienService = new SinhVienServiceImpl();
        
        setDeleteEvent(); // Đăng ký sự kiện cho nút xóa
    }
    
    public void setDateToTable(){
        List<SinhVien> listItem = sinhVienService.getList();
        
        DefaultTableModel model = new ClassTableModel().setTableSinhVien(listItem, listColumn);
        this.table = new JTable(model); // Sử dụng biến thành viên

        rowSorter = new TableRowSorter<>(this.table.getModel());
        this.table.setRowSorter(rowSorter);
        
        //tim kiem 
        jtfSearch.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if(text.trim().length()==0){
                    rowSorter.setRowFilter(null);  
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if(text.trim().length()==0){
                    rowSorter.setRowFilter(null);  
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });

        // Thay đổi cấu hình cột
        this.table.getColumnModel().getColumn(0).setMinWidth(0);
        this.table.getColumnModel().getColumn(0).setMaxWidth(0);
        this.table.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        this.table.getColumnModel().getColumn(1).setMinWidth(90);
        this.table.getColumnModel().getColumn(1).setMaxWidth(90);
        this.table.getColumnModel().getColumn(1).setPreferredWidth(90);
        
        //tap tap
        this.table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(e.getClickCount() == 2 && table.getSelectedRow() != -1){
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();
                    selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
                    
                    SinhVien sinhVien = new SinhVien();
                    sinhVien.setMaSV((String) model.getValueAt(selectedRowIndex, 0)); // Cột 0
                    sinhVien.setHoTen(model.getValueAt(selectedRowIndex, 2).toString());
                    sinhVien.setNgaySinh((Date) model.getValueAt(selectedRowIndex, 3));
                    sinhVien.setGioiTinh(model.getValueAt(selectedRowIndex, 4).toString().equalsIgnoreCase("Nam"));
                    sinhVien.setSoDT(model.getValueAt(selectedRowIndex, 5) != null ? model.getValueAt(selectedRowIndex, 5).toString() : "");
                    sinhVien.setDiaChi(model.getValueAt(selectedRowIndex, 6) != null ? model.getValueAt(selectedRowIndex, 6).toString() : "");
                    sinhVien.setTinhTrang((boolean) model.getValueAt(selectedRowIndex, 7));
                    
                    SinhVienJFrame frame = new SinhVienJFrame(sinhVien);
                    frame.setTitle("Thông Tin Sinh Viên");
                    frame.setResizable(false);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                    
                    // Sau khi chỉnh sửa, tự động làm mới bảng
                    frame.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                            setDateToTable();  // Tự động cập nhật lại bảng
                        }
                    });
                }
            }
        });
        
        // Cấu hình bảng
        this.table.getTableHeader().setFont(new Font("Arrial", Font.BOLD,14));
        this.table.getTableHeader().setPreferredSize(new Dimension(100,50));
        this.table.setRowHeight(50);
        this.table.validate();
        this.table.repaint();
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().add(this.table);
        scrollPane.setPreferredSize(new Dimension(1300, 400));
        
        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scrollPane);
        jpnView.validate();
        jpnView.repaint();
    }

    // nut add
    public void setEvent(){
        btnAdd.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                SinhVienJFrame frame = new SinhVienJFrame(new SinhVien());
                frame.setTitle("Thông tin sinh viên");
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);   
                frame.setVisible(true);
              
//                // Sau khi chỉnh sửa, tự động làm mới bảng
//                    frame.addWindowListener(new java.awt.event.WindowAdapter() {
//                        @Override
//                        public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                            setDateToTable();  // Tự động cập nhật lại bảng
//                        }
//                    });
            }
        });

    }

    public void setDeleteEvent() {
        btnDelete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Lấy bảng sinh viên
                int selectedRow = table.getSelectedRow(); // Sử dụng biến thành viên table
                // Kiểm tra xem có hàng nào được chọn không
                if (selectedRow != -1) {
                    int modelRowIndex = table.convertRowIndexToModel(selectedRow);
                    String maSinhVien = (String) table.getModel().getValueAt(modelRowIndex, 0); // Sửa cột 1 thành cột 0
                    // Xác nhận xóa
                    int confirm = JOptionPane.showConfirmDialog(null, 
                        "Bạn có chắc chắn muốn xóa sinh viên có mã: " + maSinhVien + "?", 
                        "Xác nhận xóa", 
                        JOptionPane.YES_NO_OPTION);
                    
                    if (confirm == JOptionPane.YES_OPTION) {
                        // Gọi dịch vụ để xóa sinh viên
                        sinhVienService.deleteSinhVien(maSinhVien);
                        // Cập nhật lại bảng sau khi xóa
                        setDateToTable();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Xóa thành công !");
                }
            }
        });
    }
}

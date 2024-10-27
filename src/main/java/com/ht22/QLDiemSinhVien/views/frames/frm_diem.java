/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ht22.QLDiemSinhVien.views.frames;

import com.ht22.QLDiemSinhVien.DAO.DAODiem;
import com.ht22.QLDiemSinhVien.DAO.DAOSubject;
import com.ht22.QLDiemSinhVien.entity.Diem;
import com.ht22.QLDiemSinhVien.entity.Subject;
import com.nhom2.qlsv.dao.SinhVienDAOImpl;
import com.nhom2.qlsv.model.SinhVien;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

/**
 *
 * @author linht
 */
public class frm_diem extends javax.swing.JFrame {

    DAOSubject DAOSubject = new DAOSubject();
    DAODiem diemDAO = new DAODiem();
    SinhVienDAOImpl sinhVienDAO = new SinhVienDAOImpl();
    private String tableValueSelected;


    public frm_diem() {
        initComponents();
        initTable();
        initList();
        initComboBox();
    }

//    setModel Table
    public void setModelTable(List<Diem> diemList ){
        DefaultTableModel tableModel = new DefaultTableModel(
                new String[]{"Mã Điểm","Sinh Viên", "Học Phần", "Lần Thi", "GK", "CK", "Điểm chữ"}, 0
        );


        for (Diem diem : diemList) {
            // Thêm một hàng với các giá trị lấy từ đối tượng Lop
            tableModel.addRow(new Object[]{
                    diem.getMaDiem(),
                    diem.getMaSV(),
                    diem.getMaHocPhan(),
                    diem.getSolanthi(),
                    diem.getDiemgiuaki(),
                    diem.getDiemcuoiki(),
                    diem.getDiemchu()
            });
        }

        jTableDiem.setModel(tableModel);
        jScrollPane2.setViewportView(jTableDiem);
    }

//    setTable
    public void initTable(){
//
        List<Diem> diems = diemDAO.getAll();
//        Set model data for Table
        setModelTable( diems );

//        handle click data on table
        jTableDiem.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int selectedRow = jTableDiem.getSelectedRow(); // Lấy chỉ số hàng được chọn

                if (selectedRow >= 0) { // Kiểm tra xem có hàng nào được chọn không

                    String maDiem = jTableDiem.getValueAt(selectedRow, 0).toString();
                    tableValueSelected = maDiem;
                }
            }
        });
    }

//  set List
    private void initList(){
        //        List Khoa
        List<Subject> subjects = DAOSubject.getAll();

        // Set List data for models
        DefaultListModel<Subject> models = new DefaultListModel<>();

//      add data from khoas list for models
        for (Subject subject : subjects){
            models.addElement(subject);
        }

//        Set models to List
        jListMonHoc.setModel(models);
        jScrollPane1.setViewportView(jListMonHoc);

//        handle click row list
        jListMonHoc.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int selectedRow = jListMonHoc.getSelectedIndex();

                if (selectedRow >= 0) {

                    String maHocPhan = jListMonHoc.getSelectedValue().getMaHocPhan();
                    List<Diem> subjectList = diemDAO.getAllByMaSinhVienAndHocPhan( maHocPhan);

//                    show data table by id of listSelected
                    setModelTable( subjectList );

                }
            }
        });

    }

    // Phương thức generic để tạo model cho ComboBox từ bất kỳ danh sách nào
    public <T> DefaultComboBoxModel<T> createModelComboBoxDiem(List<T> items) {
        // Khởi tạo model
        DefaultComboBoxModel<T> model = new DefaultComboBoxModel<>();

        // Duyệt qua danh sách và thêm vào model
        for (T item : items) {
            model.addElement(item); // Thêm phần tử vào ComboBoxModel
        }

        return model;
    }

    // Phương thức khởi tạo ComboBox với dữ liệu
    public void initComboBox() {
        List<Subject> subjects = DAOSubject.getAll();
        List<SinhVien> sinhvien = sinhVienDAO.getList();

        // Sử dụng phương thức generic cho cả hai loại đối tượng
        DefaultComboBoxModel<Subject> modelSJ = createModelComboBoxDiem(subjects);
        DefaultComboBoxModel<SinhVien> modelSV = createModelComboBoxDiem(sinhvien);

        // Gán model cho các JComboBox
        jComboBoxDiem.setModel(modelSJ);
        jComboBoxMaSV.setModel(modelSV);
    }




    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMonHoc = new javax.swing.JPanel();
        jLabelMonHoc = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListMonHoc = new JList<Subject>();
        jButtonMonHoc = new javax.swing.JButton();
        jPanelLop = new javax.swing.JPanel();
        jLabelDiem = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableDiem = new javax.swing.JTable();
        jPanelLopAction = new javax.swing.JPanel();
        jPanelInputTenLop = new javax.swing.JPanel();
        jLabelInputTenLop = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPaneInputDiemGiuaKy = new javax.swing.JTextPane();
        jPanelInputMaLop = new javax.swing.JPanel();
        jLabelInputMaLop = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPaneInputLanThi = new javax.swing.JTextPane();
        jPanelInputMaLop1 = new javax.swing.JPanel();
        jLabelInputKhoa = new javax.swing.JLabel();
        jComboBoxDiem = new JComboBox<Subject>();
        jButtonThemDiem = new javax.swing.JButton();
        jButtonXoaDiem = new javax.swing.JButton();
        jPanelInputTenLop1 = new javax.swing.JPanel();
        jLabelInputTenLop1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextPaneInputCuoiKy = new javax.swing.JTextPane();
        jPanelInputTenLop2 = new javax.swing.JPanel();
        jLabelInputTenLop2 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextPaneInputDiemChu = new javax.swing.JTextPane();
        jPanelInputMaLop2 = new javax.swing.JPanel();
        jLabelInputKhoa1 = new javax.swing.JLabel();
        jComboBoxMaSV = new JComboBox<SinhVien>();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuHome = new javax.swing.JMenu();
        jMenuBack = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelMonHoc.setText("Mon Hoc");


        jButtonMonHoc.setText("Quản Lý Môn Học");
        jButtonMonHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButtonQuanLyKhoaActionPerformed(evt);
            }
        });

        jLabelDiem.setText("Bảng Điểm");

        jTableDiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTableDiem);

        jLabelInputTenLop.setText("Điểm giữa kỳ");

        jScrollPane3.setViewportView(jTextPaneInputDiemGiuaKy);

        javax.swing.GroupLayout jPanelInputTenLopLayout = new javax.swing.GroupLayout(jPanelInputTenLop);
        jPanelInputTenLop.setLayout(jPanelInputTenLopLayout);
        jPanelInputTenLopLayout.setHorizontalGroup(
            jPanelInputTenLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInputTenLopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInputTenLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jLabelInputTenLop, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelInputTenLopLayout.setVerticalGroup(
            jPanelInputTenLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInputTenLopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelInputTenLop)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelInputMaLop.setText("Số lần thi");

        jScrollPane4.setViewportView(jTextPaneInputLanThi);

        javax.swing.GroupLayout jPanelInputMaLopLayout = new javax.swing.GroupLayout(jPanelInputMaLop);
        jPanelInputMaLop.setLayout(jPanelInputMaLopLayout);
        jPanelInputMaLopLayout.setHorizontalGroup(
            jPanelInputMaLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInputMaLopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInputMaLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                    .addComponent(jLabelInputMaLop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelInputMaLopLayout.setVerticalGroup(
            jPanelInputMaLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInputMaLopLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelInputMaLop)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabelInputKhoa.setText("Mã học phần");


        javax.swing.GroupLayout jPanelInputMaLop1Layout = new javax.swing.GroupLayout(jPanelInputMaLop1);
        jPanelInputMaLop1.setLayout(jPanelInputMaLop1Layout);
        jPanelInputMaLop1Layout.setHorizontalGroup(
            jPanelInputMaLop1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInputMaLop1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInputMaLop1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelInputKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelInputMaLop1Layout.createSequentialGroup()
                        .addComponent(jComboBoxDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 12, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelInputMaLop1Layout.setVerticalGroup(
            jPanelInputMaLop1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInputMaLop1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelInputKhoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jButtonThemDiem.setText("Thêm Điểm");
        jButtonThemDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThemDiemActionPerformed(evt);
            }
        });

        jButtonXoaDiem.setText("Xóa Điểm");
        jButtonXoaDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXoaDiemActionPerformed(evt);
            }
        });

        jLabelInputTenLop1.setText("Điểm cuối kỳ");

        jScrollPane5.setViewportView(jTextPaneInputCuoiKy);

        javax.swing.GroupLayout jPanelInputTenLop1Layout = new javax.swing.GroupLayout(jPanelInputTenLop1);
        jPanelInputTenLop1.setLayout(jPanelInputTenLop1Layout);
        jPanelInputTenLop1Layout.setHorizontalGroup(
            jPanelInputTenLop1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInputTenLop1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInputTenLop1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addComponent(jLabelInputTenLop1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelInputTenLop1Layout.setVerticalGroup(
            jPanelInputTenLop1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInputTenLop1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelInputTenLop1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabelInputTenLop2.setText("Điểm chữ");

        jScrollPane6.setViewportView(jTextPaneInputDiemChu);

        javax.swing.GroupLayout jPanelInputTenLop2Layout = new javax.swing.GroupLayout(jPanelInputTenLop2);
        jPanelInputTenLop2.setLayout(jPanelInputTenLop2Layout);
        jPanelInputTenLop2Layout.setHorizontalGroup(
            jPanelInputTenLop2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInputTenLop2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInputTenLop2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addComponent(jLabelInputTenLop2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelInputTenLop2Layout.setVerticalGroup(
            jPanelInputTenLop2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInputTenLop2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelInputTenLop2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelInputKhoa1.setText("Mã Sinh Viên");



        javax.swing.GroupLayout jPanelInputMaLop2Layout = new javax.swing.GroupLayout(jPanelInputMaLop2);
        jPanelInputMaLop2.setLayout(jPanelInputMaLop2Layout);
        jPanelInputMaLop2Layout.setHorizontalGroup(
            jPanelInputMaLop2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInputMaLop2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInputMaLop2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelInputKhoa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelInputMaLop2Layout.createSequentialGroup()
                        .addComponent(jComboBoxMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelInputMaLop2Layout.setVerticalGroup(
            jPanelInputMaLop2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInputMaLop2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelInputKhoa1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelLopActionLayout = new javax.swing.GroupLayout(jPanelLopAction);
        jPanelLopAction.setLayout(jPanelLopActionLayout);
        jPanelLopActionLayout.setHorizontalGroup(
            jPanelLopActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLopActionLayout.createSequentialGroup()
                .addGroup(jPanelLopActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLopActionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonXoaDiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonThemDiem))
                    .addGroup(jPanelLopActionLayout.createSequentialGroup()
                        .addGroup(jPanelLopActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanelInputTenLop1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelInputTenLop, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelLopActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanelInputMaLop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelInputTenLop2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelLopActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelInputMaLop1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelInputMaLop2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelLopActionLayout.setVerticalGroup(
            jPanelLopActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLopActionLayout.createSequentialGroup()
                .addGroup(jPanelLopActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelInputMaLop1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelInputMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelInputTenLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelLopActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelInputTenLop1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelInputTenLop2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelInputMaLop2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelLopActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonXoaDiem)
                    .addComponent(jButtonThemDiem)))
        );

        javax.swing.GroupLayout jPanelLopLayout = new javax.swing.GroupLayout(jPanelLop);
        jPanelLop.setLayout(jPanelLopLayout);
        jPanelLopLayout.setHorizontalGroup(
            jPanelLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLopLayout.createSequentialGroup()
                .addGroup(jPanelLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelLopLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelDiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
                    .addComponent(jPanelLopAction, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanelLopLayout.setVerticalGroup(
            jPanelLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelLopAction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelMonHocLayout = new javax.swing.GroupLayout(jPanelMonHoc);
        jPanelMonHoc.setLayout(jPanelMonHocLayout);
        jPanelMonHocLayout.setHorizontalGroup(
            jPanelMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMonHocLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelMonHoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jButtonMonHoc, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelMonHocLayout.setVerticalGroup(
            jPanelMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMonHocLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelMonHoc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonMonHoc)
                .addContainerGap())
            .addComponent(jPanelLop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenuHome.setText("Home");
        jMenuHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuHomeActionPerformed(evt);
            }
        });
        jMenuBar.add(jMenuHome);

        jMenuBack.setText("Back");
        jMenuBar.add(jMenuBack);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMonHoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    /**
     * Handle Clicked
     */


    private void jButtonQuanLyKhoaActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        // Ẩn frame hiện tại
        setVisible(false);

        // Hiển thị frame mới
        new FrmQLMH().setVisible(true);
    }                                             

    private void jComboBoxDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxDiemActionPerformed

    private void jButtonXoaDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoaDiemActionPerformed
        // TODO add your handling code here:
        diemDAO.delete(tableValueSelected);
        System.out.println(tableValueSelected);
        initTable();
    }//GEN-LAST:event_jButtonXoaDiemActionPerformed

    private void jMenuHomeActionPerformed(MouseEvent evt) {//GEN-FIRST:event_jMenuHomeActionPerformed
        // TODO add your handling code here:
        // Ẩn frame hiện tại
        setVisible(false);

        // Hiển thị frame mới
        new Main().setVisible(true);
    }//GEN-LAST:event_jMenuHomeActionPerformed

    private void jButtonThemDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThemDiemActionPerformed
        // TODO add your handling code here:

        String diemgiuaki = jTextPaneInputDiemGiuaKy.getText();
        String diemcuoiki = jTextPaneInputCuoiKy.getText();
        String solanthi = jTextPaneInputLanThi.getText();
        String diemchu = jTextPaneInputDiemChu.getText();

//        get Khoa ID from comboBox selected
        Subject selectedDiem = (Subject) jComboBoxDiem.getSelectedItem();
        String maHocPhan = selectedDiem.getMaHocPhan();

        SinhVien selectedMaSV = (SinhVien) jComboBoxMaSV.getSelectedItem();
        String maSV = selectedMaSV.getMaSV();


        //  Create object from form input
        Diem diem = new Diem( 0,  maSV,  maHocPhan,  Integer.parseInt(solanthi),  Float.parseFloat(diemgiuaki), Float.parseFloat( diemcuoiki),  diemchu);

        try {
//            DAO insert
            diemDAO.insert(diem);
        } catch (SQLIntegrityConstraintViolationException e) {
            // Lỗi trùng khóa chính (hoặc unique key)
            JOptionPane.showMessageDialog(this, "Mã lớp đã tồn tại. Vui lòng nhập mã lớp khác.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (SQLException e) {
            // Lỗi chung liên quan đến cơ sở dữ liệu
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi thêm dữ liệu: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            // Bắt các ngoại lệ khác nếu có
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi không xác định: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

        // Cập nhật lại bảng sau khi thêm thành công
        initTable();
    }//GEN-LAST:event_jButtonThemDiemActionPerformed

    private void jComboBoxMaSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMaSVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxMaSVActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frm_diem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_diem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_diem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_diem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_diem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonMonHoc;
    private javax.swing.JButton jButtonThemDiem;
    private javax.swing.JButton jButtonXoaDiem;
    private JComboBox<Subject> jComboBoxDiem;
    private JComboBox<SinhVien> jComboBoxMaSV;
    private javax.swing.JLabel jLabelDiem;
    private javax.swing.JLabel jLabelInputKhoa;
    private javax.swing.JLabel jLabelInputKhoa1;
    private javax.swing.JLabel jLabelInputMaLop;
    private javax.swing.JLabel jLabelInputTenLop;
    private javax.swing.JLabel jLabelInputTenLop1;
    private javax.swing.JLabel jLabelInputTenLop2;
    private javax.swing.JLabel jLabelMonHoc;
    private JList<Subject> jListMonHoc;
    private javax.swing.JMenu jMenuBack;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuHome;
    private javax.swing.JPanel jPanelInputMaLop;
    private javax.swing.JPanel jPanelInputMaLop1;
    private javax.swing.JPanel jPanelInputMaLop2;
    private javax.swing.JPanel jPanelInputTenLop;
    private javax.swing.JPanel jPanelInputTenLop1;
    private javax.swing.JPanel jPanelInputTenLop2;
    private javax.swing.JPanel jPanelLop;
    private javax.swing.JPanel jPanelLopAction;
    private javax.swing.JPanel jPanelMonHoc;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTableDiem;
    private javax.swing.JTextPane jTextPaneInputCuoiKy;
    private javax.swing.JTextPane jTextPaneInputDiemChu;
    private javax.swing.JTextPane jTextPaneInputDiemGiuaKy;
    private javax.swing.JTextPane jTextPaneInputLanThi;
    // End of variables declaration//GEN-END:variables
}

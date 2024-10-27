/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ht22.QLDiemSinhVien.views.frames;

import com.ht22.QLDiemSinhVien.DAO.DAOHocPhi;
import com.ht22.QLDiemSinhVien.entity.HocPhi;
import com.ht22.QLDiemSinhVien.DAO.SinhVienDAOImpl;
import com.ht22.QLDiemSinhVien.entity.SinhVien;
import com.ht22.QLDiemSinhVien.views.frames.view.MainJFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author linht
 */
public class frm_hocphi extends JFrame {

    SinhVienDAOImpl sinhVienDAO = new SinhVienDAOImpl();
    DAOHocPhi hocPhiDao = new DAOHocPhi();
    private String tableValueSelected;

// Constructor
    public frm_hocphi() {
        initComponents();
        initTable();
        initList();
        initComboBox();
    }




    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMonHoc = new JPanel();
        jLabelSinhVien = new JLabel();
        jScrollPane1 = new JScrollPane();
        jListSinhVien = new JList<SinhVien>();
        jButtonSinhVien = new JButton();
        jPanelLop = new JPanel();
        jLabelHocPhi = new JLabel();
        jScrollPane2 = new JScrollPane();
        jTableHocPhi = new JTable();
        jPanelLopAction = new JPanel();
        jPanelInputTenLop = new JPanel();
        jLabelInputTenKhoanPhi = new JLabel();
        jScrollPane3 = new JScrollPane();
        jTextPaneInputTenKhoanPhi = new JTextPane();
        jPanelInputMaLop = new JPanel();
        jLabelInputNgayDong = new JLabel();
        jScrollPane4 = new JScrollPane();
        jTextPaneInputNgayDong = new JTextPane();
        jPanelInputMaLop1 = new JPanel();
        jLabelInputTrangThai = new JLabel();
        jComboBoxTrangThai = new JComboBox<>();
        jButtonThem = new JButton();
        jButtonXoa = new JButton();
        jPanelInputTenLop2 = new JPanel();
        jLabelInputSoTien = new JLabel();
        jScrollPane6 = new JScrollPane();
        jTextPaneInputSoTien = new JTextPane();
        jPanelInputMaLop2 = new JPanel();
        jLabelInputMaSinhVien = new JLabel();
        jComboBoxMaSV = new JComboBox<SinhVien>();
        jButtonSua = new JButton();
        jMenuBar = new JMenuBar();
        jMenuHome = new JMenu();
        jMenuBack = new JMenu();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabelSinhVien.setText("Sinh Vien");



        jButtonSinhVien.setText("Quản Lý Sinh Viên");
        jButtonSinhVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonSinhVienActionPerformed(evt);
            }
        });

        jLabelHocPhi.setText("Học Phí");

        jTableHocPhi.setModel(new DefaultTableModel(
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
        jScrollPane2.setViewportView(jTableHocPhi);

        jLabelInputTenKhoanPhi.setText("Tên Khoản phí");

        jScrollPane3.setViewportView(jTextPaneInputTenKhoanPhi);

        GroupLayout jPanelInputTenLopLayout = new GroupLayout(jPanelInputTenLop);
        jPanelInputTenLop.setLayout(jPanelInputTenLopLayout);
        jPanelInputTenLopLayout.setHorizontalGroup(
            jPanelInputTenLopLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInputTenLopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInputTenLopLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jLabelInputTenKhoanPhi, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelInputTenLopLayout.setVerticalGroup(
            jPanelInputTenLopLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInputTenLopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelInputTenKhoanPhi)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelInputNgayDong.setText("Ngày đóng(dd/MM/yyyy)");

        jScrollPane4.setViewportView(jTextPaneInputNgayDong);

        GroupLayout jPanelInputMaLopLayout = new GroupLayout(jPanelInputMaLop);
        jPanelInputMaLop.setLayout(jPanelInputMaLopLayout);
        jPanelInputMaLopLayout.setHorizontalGroup(
            jPanelInputMaLopLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInputMaLopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInputMaLopLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                    .addComponent(jLabelInputNgayDong, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelInputMaLopLayout.setVerticalGroup(
            jPanelInputMaLopLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInputMaLopLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelInputNgayDong)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        jLabelInputTrangThai.setText("Trạng thái");

        jComboBoxTrangThai.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jComboBoxTrangThaiActionPerformed(evt);
            }
        });

        GroupLayout jPanelInputMaLop1Layout = new GroupLayout(jPanelInputMaLop1);
        jPanelInputMaLop1.setLayout(jPanelInputMaLop1Layout);
        jPanelInputMaLop1Layout.setHorizontalGroup(
            jPanelInputMaLop1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInputMaLop1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInputMaLop1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelInputTrangThai, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelInputMaLop1Layout.createSequentialGroup()
                        .addComponent(jComboBoxTrangThai, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 12, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelInputMaLop1Layout.setVerticalGroup(
            jPanelInputMaLop1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInputMaLop1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelInputTrangThai)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxTrangThai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jButtonThem.setText("Thêm Khoản Phí");
        jButtonThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonThemActionPerformed(evt);
            }
        });

        jButtonXoa.setText("Xóa Khoản phí");
        jButtonXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonXoaActionPerformed(evt);
            }
        });

        jLabelInputSoTien.setText("Số tiền");

        jScrollPane6.setViewportView(jTextPaneInputSoTien);

        GroupLayout jPanelInputTenLop2Layout = new GroupLayout(jPanelInputTenLop2);
        jPanelInputTenLop2.setLayout(jPanelInputTenLop2Layout);
        jPanelInputTenLop2Layout.setHorizontalGroup(
            jPanelInputTenLop2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInputTenLop2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInputTenLop2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addComponent(jLabelInputSoTien, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelInputTenLop2Layout.setVerticalGroup(
            jPanelInputTenLop2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInputTenLop2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelInputSoTien)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelInputMaSinhVien.setText("Mã Sinh Viên");



        GroupLayout jPanelInputMaLop2Layout = new GroupLayout(jPanelInputMaLop2);
        jPanelInputMaLop2.setLayout(jPanelInputMaLop2Layout);
        jPanelInputMaLop2Layout.setHorizontalGroup(
            jPanelInputMaLop2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInputMaLop2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInputMaLop2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelInputMaSinhVien, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelInputMaLop2Layout.createSequentialGroup()
                        .addComponent(jComboBoxMaSV, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelInputMaLop2Layout.setVerticalGroup(
            jPanelInputMaLop2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInputMaLop2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelInputMaSinhVien)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxMaSV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonSua.setText("Sửa Khoản Phí");
        jButtonSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonSuaActionPerformed(evt);
            }
        });

        GroupLayout jPanelLopActionLayout = new GroupLayout(jPanelLopAction);
        jPanelLopAction.setLayout(jPanelLopActionLayout);
        jPanelLopActionLayout.setHorizontalGroup(
            jPanelLopActionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLopActionLayout.createSequentialGroup()
                .addGroup(jPanelLopActionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelInputTenLop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelLopActionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonXoa)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonThem)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLopActionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLopActionLayout.createSequentialGroup()
                        .addGroup(jPanelLopActionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanelInputMaLop, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelInputTenLop2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelLopActionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelInputMaLop1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelInputMaLop2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButtonSua))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelLopActionLayout.setVerticalGroup(
            jPanelLopActionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLopActionLayout.createSequentialGroup()
                .addGroup(jPanelLopActionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelInputMaLop1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelInputMaLop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelInputTenLop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelLopActionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelInputTenLop2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelInputMaLop2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanelLopActionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonXoa)
                    .addComponent(jButtonThem)
                    .addComponent(jButtonSua)))
        );

        GroupLayout jPanelLopLayout = new GroupLayout(jPanelLop);
        jPanelLop.setLayout(jPanelLopLayout);
        jPanelLopLayout.setHorizontalGroup(
            jPanelLopLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLopLayout.createSequentialGroup()
                .addGroup(jPanelLopLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addGroup(GroupLayout.Alignment.LEADING, jPanelLopLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelHocPhi, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
                    .addComponent(jPanelLopAction, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanelLopLayout.setVerticalGroup(
            jPanelLopLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelHocPhi, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelLopAction, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        GroupLayout jPanelMonHocLayout = new GroupLayout(jPanelMonHoc);
        jPanelMonHoc.setLayout(jPanelMonHocLayout);
        jPanelMonHocLayout.setHorizontalGroup(
            jPanelMonHocLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMonHocLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMonHocLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelSinhVien, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jButtonSinhVien, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelLop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        jPanelMonHocLayout.setVerticalGroup(
            jPanelMonHocLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMonHocLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelSinhVien)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSinhVien)
                .addContainerGap())
            .addComponent(jPanelLop, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMonHoc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMonHoc, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    /**
     * Handle Clicked
     */

    //    setModelTable
    public void setModelTable(List<HocPhi> hocPhis ){
        DefaultTableModel tableModel = new DefaultTableModel(
                new String[]{"Mã Học Phí","Sinh Viên", "Tên Khoản Phí", "Số Tiền", "Ngày Đóng", "Trạng Thái"}, 0
        );


        for (HocPhi hocPhi : hocPhis) {
            // Thêm một hàng với các giá trị lấy từ đối tượng Lop
            tableModel.addRow(new Object[]{
                    hocPhi.getMaHocPhi(),
                    hocPhi.getMaSV(),
                    hocPhi.getTenKhoanPhi(),
                    hocPhi.getSoTien(),
                    hocPhi.getNgayDong(),
                    hocPhi.getTrangThai(),
                    hocPhi});
        }

        jTableHocPhi.setModel(tableModel);
        jScrollPane2.setViewportView(jTableHocPhi);
    }

    //    initTable
    public void initTable(){
//
        List<HocPhi> hocPhis = null;
        try {
            hocPhis = hocPhiDao.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        Set model data for Table
        setModelTable( hocPhis );

//        handle click data on table
        jTableHocPhi.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int selectedRow = jTableHocPhi.getSelectedRow(); // Lấy chỉ số hàng được chọn

                if (selectedRow >= 0) { // Kiểm tra xem có hàng nào được chọn không

                    String select = jTableHocPhi.getValueAt(selectedRow, 0).toString();
                    tableValueSelected = select;
                }
            }
        });
    }

    //  init list
    private void initList(){
        //        List Khoa
        List<SinhVien> sinhViens = sinhVienDAO.getList();

        // Set List data for models
        DefaultListModel<SinhVien> models = new DefaultListModel<>();

//      add data from khoas list for models
        for (SinhVien obj : sinhViens){
            models.addElement(obj);
        }

//        Set models to List
        jListSinhVien.setModel(models);
        jScrollPane1.setViewportView(jListSinhVien);

//        handle click row list
        jListSinhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int selectedRow = jListSinhVien.getSelectedIndex();

                if (selectedRow >= 0) {

                    String selectID = jListSinhVien.getSelectedValue().getMaSV();
                    List<HocPhi> objList = null;
                    try {
                        objList = hocPhiDao.getByID(selectID);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

//                    show data table by id of listSelected
                    setModelTable(objList);

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

    // initComboBox
    public void initComboBox() {

        List<SinhVien> sinhvien = sinhVienDAO.getList();
        // Sử dụng phương thức generic cho cả hai loại đối tượng

        DefaultComboBoxModel<SinhVien> modelSV = createModelComboBoxDiem(sinhvien);

        // Gán model cho các JComboBox
        jComboBoxTrangThai.setModel(new DefaultComboBoxModel<>(new String[] { "Đã đóng", "Chưa đóng" }));
        jComboBoxMaSV.setModel(modelSV);
    }



    //chuyển sang trang sinh viên
    private void jButtonSinhVienActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        // Ẩn frame hiện tại
        setVisible(false);

        // Hiển thị frame mới
        new MainJFrame().setVisible(true);
    }

    private void jComboBoxTrangThaiActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jComboBoxTrangThaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTrangThaiActionPerformed

//    nút xóa
    private void jButtonXoaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonXoaActionPerformed
        // TODO add your handling code here:
        try {
            hocPhiDao.delete(tableValueSelected);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(tableValueSelected);
        initTable();
    }//GEN-LAST:event_jButtonXoaActionPerformed

//    them hoc phi
    private void jButtonThemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonThemActionPerformed
        String tenKhoanPhiText = jTextPaneInputTenKhoanPhi.getText();
        double soTien = 0.0;
        java.sql.Date sqlNgayDong = null;

        // Chuyển đổi số tiền từ chuỗi thành số thực
        try {
            soTien = Double.parseDouble(jTextPaneInputSoTien.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số tiền không hợp lệ. Vui lòng nhập giá trị số.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Chuyển đổi chuỗi ngày đóng thành kiểu Date và sau đó sang java.sql.Date
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date ngayDongText = dateFormat.parse(jTextPaneInputNgayDong.getText());
            sqlNgayDong = new java.sql.Date(ngayDongText.getTime()); // Chuyển đổi sang java.sql.Date
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Ngày đóng không hợp lệ. Vui lòng nhập theo định dạng dd/MM/yyyy.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Lấy mã sinh viên từ comboBox
        SinhVien selected = (SinhVien) jComboBoxMaSV.getSelectedItem();
        if (selected == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn mã sinh viên.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String maSV = selected.getMaSV();

        // Lấy trạng thái từ comboBox
        String trangThaiSelectedItem = (String) jComboBoxTrangThai.getSelectedItem();
        if (trangThaiSelectedItem == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn trạng thái.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Tạo đối tượng HocPhi từ dữ liệu đầu vào
        HocPhi hocPhi = new HocPhi(0, maSV, tenKhoanPhiText, soTien, sqlNgayDong, trangThaiSelectedItem);

        try {
            // Thực hiện chèn ữd liệu vào cơ sở dữ liệu
            hocPhiDao.insert(hocPhi);
            JOptionPane.showMessageDialog(this, "Thêm học phí thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLIntegrityConstraintViolationException e) {
            // Lỗi trùng khóa chính
            JOptionPane.showMessageDialog(this, "Mã sinh viên đã tồn tại. Vui lòng nhập mã khác.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (SQLException e) {
            // Lỗi cơ sở dữ liệu
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi thêm dữ liệu: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (Exception e) {
            // Bắt các ngoại lệ khác
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi không xác định: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        // Cập nhật lại bảng sau khi thêm thành công
        initTable();
    }//GEN-LAST:event_jButtonThemActionPerformed


    private void jComboBoxMaSVActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jComboBoxMaSVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxMaSVActionPerformed

    private void jButtonSuaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonSuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSuaActionPerformed

//    chuyển home
    private void jMenuHomeActionPerformed(MouseEvent evt) {//GEN-FIRST:event_jMenuHomeActionPerformed
        // TODO add your handling code here:
        // Ẩn frame hiện tại
        setVisible(false);

        // Hiển thị frame mới
        new Main().setVisible(true);
    }//GEN-LAST:event_jMenuHomeActionPerformed

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
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frm_hocphi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_hocphi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_hocphi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_hocphi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_hocphi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton jButtonSinhVien;
    private JButton jButtonSua;
    private JButton jButtonThem;
    private JButton jButtonXoa;
    private JComboBox<SinhVien> jComboBoxMaSV;
    private JComboBox<String> jComboBoxTrangThai;
    private JLabel jLabelHocPhi;
    private JLabel jLabelInputMaSinhVien;
    private JLabel jLabelInputNgayDong;
    private JLabel jLabelInputSoTien;
    private JLabel jLabelInputTenKhoanPhi;
    private JLabel jLabelInputTrangThai;
    private JLabel jLabelSinhVien;
    private JList<SinhVien> jListSinhVien;
    private JMenu jMenuBack;
    private JMenuBar jMenuBar;
    private JMenu jMenuHome;
    private JPanel jPanelInputMaLop;
    private JPanel jPanelInputMaLop1;
    private JPanel jPanelInputMaLop2;
    private JPanel jPanelInputTenLop;
    private JPanel jPanelInputTenLop2;
    private JPanel jPanelLop;
    private JPanel jPanelLopAction;
    private JPanel jPanelMonHoc;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JScrollPane jScrollPane6;
    private JTable jTableHocPhi;
    private JTextPane jTextPaneInputNgayDong;
    private JTextPane jTextPaneInputSoTien;
    private JTextPane jTextPaneInputTenKhoanPhi;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom2.qlsv.dao;

import com.nhom2.qlsv.model.SinhVien;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class SinhVienDAOImpl implements SinhVienDAO {
    
    @Override
    public List<SinhVien> getList(){
        List<SinhVien> list = new ArrayList<>();
        try{
        Connection cons = DBConnect.getConnection();
        String sql ="SELECT * FROM sinh_vien";
        PreparedStatement ps = cons.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        
        while ( rs.next()){
            SinhVien sinhVien = new SinhVien();
            sinhVien.setMaSV(rs.getString("maSV"));
            sinhVien.setMaLop(rs.getString("maLop"));
            sinhVien.setHoTen(rs.getString("hoTen"));
            sinhVien.setNgaySinh(rs.getDate("ngaySinh"));
            sinhVien.setGioiTinh(rs.getBoolean("gioiTinh"));
            sinhVien.setSoDT(rs.getString("soDT"));
            sinhVien.setDiaChi(rs.getString("diaChi"));
            sinhVien.setTinhTrang(rs.getBoolean("tinhTrang"));
            list.add(sinhVien);
        
        }
        ps.close();
        rs.close();
        cons.close();
//        return list;
        }catch(SQLException ex){
            ex.setNextException(ex);
        }
        return list;
      
    }
    
    
    
    @Override
    public String createOrUpdate(SinhVien sinhVien) {
        try {
            Connection cons = DBConnect.getConnection();

            // Kiểm tra xem sinh viên có tồn tại không
            String checkExistSql = "SELECT COUNT(*) FROM sinh_vien WHERE maSV = ?";
            PreparedStatement checkPs = cons.prepareStatement(checkExistSql);
            checkPs.setString(1, sinhVien.getMaSV());
            ResultSet rs = checkPs.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            rs.close();
            checkPs.close();

            if (count > 0) {
                // Nếu sinh viên đã tồn tại, thực hiện UPDATE
                String sql = "UPDATE sinh_vien SET hoTen = ?, ngaySinh = ?, gioiTinh = ?, soDT = ?, diaChi = ?, tinhTrang = ?, maLop = ? "
                        + "WHERE maSV = ?";
                PreparedStatement ps = cons.prepareStatement(sql);
                ps.setString(1, sinhVien.getHoTen());
                ps.setDate(2, new java.sql.Date(sinhVien.getNgaySinh().getTime()));
                ps.setBoolean(3, sinhVien.isGioiTinh());
                ps.setString(4, sinhVien.getSoDT());
                ps.setString(5, sinhVien.getDiaChi());
                ps.setBoolean(6, sinhVien.isTinhTrang());
                ps.setString(7, sinhVien.getMaLop());
                ps.setString(8, sinhVien.getMaSV());

                ps.executeUpdate();
                ps.close();
                cons.close();
                return sinhVien.getMaSV();  // Trả về mã sinh viên đã cập nhật
            } else {
                // Nếu sinh viên chưa tồn tại, thực hiện INSERT
                String sql = "INSERT INTO sinh_vien(maSV, maLop, hoTen, ngaySinh, gioiTinh, soDT, diaChi, tinhTrang) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = cons.prepareStatement(sql);
                ps.setString(1, sinhVien.getMaSV());
                ps.setString(2, sinhVien.getMaLop());
                ps.setString(3, sinhVien.getHoTen());
                ps.setDate(4, new java.sql.Date(sinhVien.getNgaySinh().getTime()));
                ps.setBoolean(5, sinhVien.isGioiTinh());
                ps.setString(6, sinhVien.getSoDT());
                ps.setString(7, sinhVien.getDiaChi());
                ps.setBoolean(8, sinhVien.isTinhTrang());

                ps.executeUpdate();
                ps.close();
                cons.close();
                return sinhVien.getMaSV();  // Trả về mã sinh viên vừa thêm
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }


//    @Override
//    public int createOrUpdate(SinhVien sinhVien){
//        try{
//            
//            Connection cons = DBConnect.getConnection();
//            
//            String sql = "INSERT INTO sinh_vien(ma_sinh_vien, ho_ten, ngay_sinh, gioi_tinh, so_dien_thoai, dia_chi, tinh_trang) "
//                   + "VALUES (?, ?, ?, ?, ?, ?, ?)";
//            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
//            
//            ps.setInt(1, sinhVien.getMa_sinh_vien());
//            ps.setString(2, sinhVien.getHo_ten());
//            ps.setDate(3, new java.sql.Date(sinhVien.getNgay_sinh().getTime()));
//            ps.setBoolean(4, sinhVien.isGioi_tinh());
//            ps.setString(5, sinhVien.getSo_dien_thoai());
//            ps.setString(6, sinhVien.getDia_chi());
//            ps.setBoolean(7, sinhVien.isTinh_trang());
//            
//            ps.executeUpdate();
//            
//            ResultSet rs = ps.getGeneratedKeys();
//            int generatedKey = 0;
//            if( rs.next()){
//                generatedKey = rs.getInt(1);
//            }
//            ps.close();
//            cons.close();
//            return generatedKey;
//           
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
//           
//        return 0;
//    }
    

// Phương thức xóa sinh viên
    @Override
    public void deleteSinhVien(String maSinhVien) {
        String sql = "DELETE FROM sinh_vien WHERE maSV = ?";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, maSinhVien);
            pstmt.executeUpdate(); // Thực thi câu lệnh xóa
        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý ngoại lệ nếu có lỗi
        }
    }
    
    public static void main(String[] args) {
        SinhVienDAO sinhVienDAO = new SinhVienDAOImpl();
        System.out.println(sinhVienDAO.getList());
    }
    
}

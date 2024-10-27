package com.ht22.QLDiemSinhVien.DAO;

import com.ht22.QLDiemSinhVien.database.ConnectDB;
import com.ht22.QLDiemSinhVien.entity.HocPhi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DAOHocPhi implements DaoInterface<HocPhi> {
    private final Connection connection;

    public DAOHocPhi() {
        this.connection = ConnectDB.getConnection();
    }

    @Override
    public List<HocPhi> getAll() throws SQLException {
        List<HocPhi> hocPhiList = new ArrayList<>();
        String query = "SELECT * FROM hocphi";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                HocPhi hocPhi = mapResultSetToHocPhi(rs);
                hocPhiList.add(hocPhi);
            }
        }
        return hocPhiList;
    }

    @Override
    public List<HocPhi> getAllByKhoaID(String maSV) throws SQLException {
        List<HocPhi> hocPhiList = new ArrayList<>();
        String query = "SELECT * FROM hocphi WHERE maSV = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, maSV);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                HocPhi hocPhi = mapResultSetToHocPhi(rs);
                hocPhiList.add(hocPhi);
            }
        }
        return hocPhiList;
    }

    @Override
    public Optional<HocPhi> get(int id) throws SQLException {
        String query = "SELECT * FROM hocphi WHERE MaHocPhi = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return Optional.of(mapResultSetToHocPhi(rs));
            }
        }
        return Optional.empty();
    }

    public List<HocPhi> getByID(String id) throws SQLException {
        List<HocPhi> hocPhiList = new ArrayList<>();
        String query = "SELECT * FROM hocphi WHERE maSV = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                HocPhi hocPhi = mapResultSetToHocPhi(rs);
                hocPhiList.add(hocPhi);
            }
        }
        return hocPhiList;
    }

    @Override
    public int insert(HocPhi hocPhi) throws SQLException {
        String query = "INSERT INTO hocphi (maSV, TenKhoanPhi, SoTien, NgayDong, TrangThai) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, hocPhi.getMaSV());
            pstmt.setString(2, hocPhi.getTenKhoanPhi());
            pstmt.setDouble(3, hocPhi.getSoTien());
            pstmt.setDate(4, hocPhi.getNgayDong());
            pstmt.setString(5, hocPhi.getTrangThai());
            pstmt.executeUpdate();

            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            }
        }
        return -1;
    }

    @Override
    public Boolean update(HocPhi hocPhi) throws SQLException {
        String query = "UPDATE hocphi SET maSV = ?, TenKhoanPhi = ?, SoTien = ?, NgayDong = ?, TrangThai = ? WHERE MaHocPhi = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, hocPhi.getMaSV());
            pstmt.setString(2, hocPhi.getTenKhoanPhi());
            pstmt.setDouble(3, hocPhi.getSoTien());
            pstmt.setDate(4, hocPhi.getNgayDong());
            pstmt.setString(5, hocPhi.getTrangThai());
            pstmt.setInt(6, hocPhi.getMaHocPhi());
            return pstmt.executeUpdate() > 0;
        }
    }

    @Override
    public Boolean delete(String maLop) throws SQLException {
        String query = "DELETE FROM hocphi WHERE maSV = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, maLop);
            return pstmt.executeUpdate() > 0;
        }
    }

    private HocPhi mapResultSetToHocPhi(ResultSet rs) throws SQLException {
        HocPhi hocPhi = new HocPhi();
        hocPhi.setMaHocPhi(rs.getInt("MaHocPhi"));
        hocPhi.setMaSV(rs.getString("maSV"));
        hocPhi.setTenKhoanPhi(rs.getString("TenKhoanPhi"));
        hocPhi.setSoTien(rs.getDouble("SoTien"));
        hocPhi.setNgayDong(rs.getDate("NgayDong"));
        hocPhi.setTrangThai(rs.getString("TrangThai"));
        return hocPhi;
    }
}


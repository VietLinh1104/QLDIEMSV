package com.ht22.QLDiemSinhVien.DAO;

import com.ht22.QLDiemSinhVien.database.ConnectDB;
import com.ht22.QLDiemSinhVien.entity.Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DAOSubject implements DaoInterface<Subject> {
    @Override
    public List<Subject> getAll() {
        List<Subject> subjects = new ArrayList<>();
        String query = "SELECT * FROM hoc_phan ;";
        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Subject subject = new Subject(rs.getString("maHocPhan"), rs.getString("makhoa"), rs.getString("tenHocPhan"), rs.getInt("soTinChi"), rs.getString("ghiChu"));
                subjects.add(subject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subjects;
    }

    @Override
    public List<Subject> getAllByKhoaID(String id) {
        List<Subject> subjects = new ArrayList<>();
        String query = "SELECT * FROM hoc_phan WHERE maKhoa = ?;";

        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Đặt giá trị cho tham số
            stmt.setString(1, id);

            // Thực thi truy vấn
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Subject subject = new Subject(rs.getString("maHocPhan"), rs.getString("makhoa"), rs.getString("tenHocPhan"), rs.getInt("soTinChi"), rs.getString("ghiChu"));
                    subjects.add(subject);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return subjects;
    }

    @Override
    public Optional<Subject> get(int id) {
        return Optional.empty();
    }

    @Override
    public int insert(Subject subject) throws SQLException {
        String query = "INSERT INTO hoc_phan (maHocPhan, makhoa, tenHocPhan, soTinChi, ghiChu) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, subject.getMaHocPhan());
            stmt.setString(2, subject.getMaKhoa());
            stmt.setString(3, subject.getTenHocPhan());
            stmt.setInt(4, subject.getSoTinChi());
            stmt.setString(5, subject.getGhiChu());
            stmt.executeUpdate();
        } catch (SQLException e) {
            // Thay vì chỉ in stack trace, ném ngoại lệ ra ngoài để nơi gọi có thể bắt
            throw e;
        }
        return 0;
    }

    @Override
    public Boolean update(Subject subject) {
        Connection conn = ConnectDB.getConnection();
        PreparedStatement ps = null;
        String sql = "update " + "hoc_phan" + " set makhoa =? , tenHocPhan = ?, soTinChi = ?, ghiChu = ? where maHocPhan = ? ";
        try {
            ps = conn.prepareStatement(sql);
//            ps.setString(1, subject.getMaHocPhan());
            ps.setString(1, subject.getMaKhoa());
            ps.setString(2, subject.getTenHocPhan());
            ps.setInt(3, subject.getSoTinChi());
            ps.setString(4, subject.getGhiChu());
            ps.setString(5, subject.getMaHocPhan());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean delete(String maHocPhan) {
        String query = "DELETE FROM hoc_phan WHERE maHocPhan = ?";
        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, maHocPhan); // Giả sử lop có phương thức getMaLop()
            stmt.executeUpdate();
        } catch (SQLException e) {
            // Thay vì chỉ in stack trace, ném ngoại lệ ra ngoài để nơi gọi có thể bắt
            e.printStackTrace();
        }
        return true;
    }
}

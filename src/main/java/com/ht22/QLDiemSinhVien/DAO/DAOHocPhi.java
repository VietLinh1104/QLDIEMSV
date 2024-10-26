package com.ht22.QLDiemSinhVien.DAO;

import com.ht22.QLDiemSinhVien.database.ConnectDB;
import com.ht22.QLDiemSinhVien.entity.Diem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DAOHocPhi implements DaoInterface<Diem>{
    @Override
    public List<Diem> getAll() {
        List<Diem> diems = new ArrayList<>();
        String query = "SELECT * FROM tbl_diem ;";
        try(Connection conn = ConnectDB.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery() ){
            while(rs.next()){
                Diem diem = new Diem(rs.getInt("maDiem"), rs.getString("maSV"), rs.getString("maHocPhan"), rs.getInt("solanthi"),rs.getFloat("diemgiuaki"),rs.getFloat("diemcuoiki"),rs.getString("diemchu"));
                diems.add(diem);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return diems;
    }

    @Override
    public List<Diem> getAllByKhoaID(String id) {
        return List.of();
    }

    public List<Diem> getAllByMaSinhVienAndHocPhan( String maHocPhan) {
        List<Diem> diems = new ArrayList<>();
        String query = "SELECT * FROM tbl_diem WHERE maHocPhan = ?;";
        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, maHocPhan);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Diem diem = new Diem(rs.getInt("maDiem"), rs.getString("maSV"),
                            rs.getString("maHocPhan"), rs.getInt("solanthi"),
                            rs.getFloat("diemgiuaki"), rs.getFloat("diemcuoiki"),
                            rs.getString("diemchu"));
                    diems.add(diem);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return diems;
    }


    @Override
    public Optional<Diem> get(int id) {
        return Optional.empty();
    }

    @Override
    public int insert(Diem diem) throws SQLException {
        String query = "INSERT INTO tbl_diem (maSV, maHocPhan, solanthi, diemgiuaki, diemcuoiki, diemchu) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, diem.getMaSV());
            stmt.setString(2, diem.getMaHocPhan());
            stmt.setInt(3, diem.getSolanthi());
            stmt.setFloat(4, diem.getDiemgiuaki());
            stmt.setFloat(5, diem.getDiemcuoiki());
            stmt.setString(6, diem.getDiemchu());

            return stmt.executeUpdate();
        } catch (SQLException e) {
            // Ném ngoại lệ để nơi gọi có thể xử lý lỗi
            throw e;
        }
    }

    @Override
    public Boolean update(Diem diem) {
        return null;
    }

    @Override
    public Boolean delete(String maDiem) {
        String query = "DELETE FROM tbl_diem WHERE maDiem = ?";
        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, maDiem); // Giả sử lop có phương thức getMaLop()
            stmt.executeUpdate();
        } catch (SQLException e) {
            // Thay vì chỉ in stack trace, ném ngoại lệ ra ngoài để nơi gọi có thể bắt
            e.printStackTrace();
        }
        return true;
    }
}

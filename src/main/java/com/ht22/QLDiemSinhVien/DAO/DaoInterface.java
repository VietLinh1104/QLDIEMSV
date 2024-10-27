package com.ht22.QLDiemSinhVien.DAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DaoInterface<T> {
    List<T> getAll() throws SQLException;
    List<T> getAllByKhoaID(String id) throws SQLException;
    Optional<T> get(int id) throws SQLException;
    int insert(T t) throws SQLException;
    Boolean update(T t) throws SQLException;
    Boolean delete(String maLop) throws SQLException;
}

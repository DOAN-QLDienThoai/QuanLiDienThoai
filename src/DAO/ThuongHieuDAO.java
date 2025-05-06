/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ThuongHieuDTO;
import util.ConnectedDatabase;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.HashMap;
import java.sql.Connection;
import java.sql.SQLException;

public class ThuongHieuDAO {
    public int insertThuongHieu(ThuongHieuDTO th) {
        try {
            String sqlAddThuongHieu = "INSERT INTO ThuongHieu(tenThuongHieu,trangThai)"
                    + "VALUES (?,1)";
            PreparedStatement ps;
            Connection conn = ConnectedDatabase.getConnectedDB();
            ps = conn.prepareStatement(sqlAddThuongHieu);
            ps.setString(1, th.getTenThuongHieu());
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Thêm thương hiệu thành công", "Success", 1);
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int updateThuongHieu(ThuongHieuDTO th) {
        try {
            String sqlUpdateThuongHieu = "UPDATE ThuongHieu SET tenThuongHieu=? WHERE maThuongHieu=? ";
            PreparedStatement ps;
            Connection conn = ConnectedDatabase.getConnectedDB();
            ps = conn.prepareStatement(sqlUpdateThuongHieu);
            ps.setString(1, th.getTenThuongHieu());
            ps.setInt(2, th.getMaThuongHieu());
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Cập nhật thương hiệu thành công", "Success", 1);
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int deleteThuongHieu(int maThuongHieu) {
        try {
            String sqlDeleteRam = "UPDATE ThuongHieu SET trangThai=0 WHERE maThuongHieu=? ";
            PreparedStatement ps;
            Connection conn = ConnectedDatabase.getConnectedDB();
            ps = conn.prepareStatement(sqlDeleteRam);
            ps.setInt(1, maThuongHieu);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Xóa thương hiệu thành công", "Success", 1);
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    //Lấy danh sách thương hiệu đang hoạt động (ahuy)
    public ArrayList<ThuongHieuDTO> listThuongHieu() {
        ArrayList<ThuongHieuDTO> listThuongHieu = new ArrayList<ThuongHieuDTO>();
        try {
            String sqlAllThuongHieu = "SELECT * FROM ThuongHieu WHERE trangThai=1 ";
            PreparedStatement ps;
            ResultSet rs;
            Connection conn = ConnectedDatabase.getConnectedDB();
            ps = conn.prepareStatement(sqlAllThuongHieu);
            rs = ps.executeQuery();
            while (rs.next()) {
                int maThuongHieu = rs.getInt("maThuongHieu");
                String tenThuongHieu = rs.getString("tenThuongHieu");
                listThuongHieu.add(new ThuongHieuDTO(maThuongHieu, tenThuongHieu));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listThuongHieu;
    }
    //Lấy tất cả danh sách thương hiệu (ahuy)
    public ArrayList<ThuongHieuDTO> arrlistTH() {
        ArrayList<ThuongHieuDTO> arrlistTH = new ArrayList<ThuongHieuDTO>();
        try {
            String sqlAllThuongHieu = "SELECT * FROM ThuongHieu WHERE trangThai=1 ";
            PreparedStatement ps;
            ResultSet rs;
            Connection conn = ConnectedDatabase.getConnectedDB();
            ps = conn.prepareStatement(sqlAllThuongHieu);
            rs = ps.executeQuery();
            while (rs.next()) {
                int maThuongHieu = rs.getInt("maThuongHieu");
                String tenThuongHieu = rs.getString("tenThuongHieu");
                arrlistTH.add(new ThuongHieuDTO(maThuongHieu, tenThuongHieu));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrlistTH;
    }
    
    public HashMap<String, Integer> listMapThuongHieu() {
        HashMap<String, Integer> mapThuongHieu = new HashMap<>();
        try {
            String sql = "SELECT * FROM ThuongHieu WHERE trangThai=1";
            PreparedStatement ps;
            ResultSet rs;
            Connection conn = ConnectedDatabase.getConnectedDB();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int maThuongHieu = rs.getInt("maThuongHieu");
                String tenThuongHieu = rs.getString("tenThuongHieu");
                mapThuongHieu.put(tenThuongHieu, maThuongHieu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mapThuongHieu;
    }
}

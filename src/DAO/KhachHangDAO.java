/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.KhachHangDTO;
import Data.ConnectedDatabase;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class KhachHangDAO {
    public int insertKhachHang(KhachHangDTO kh) throws SQLException {
        String sql = "INSERT INTO KhachHang (maKh,tenKh,diaChi,sdt,trangThai)"
                + "VALUES (?,?,?,?,1)";
        PreparedStatement ps;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sql);
            ps.setString(1, kh.getID());
            ps.setString(2, kh.getName());
            ps.setString(3, kh.getAddress());
            ps.setString(4, kh.getSDT());
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Thêm Khách hàng thành công", "Success", 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int updateKhachHang(KhachHangDTO kh) throws SQLException {
        String sqlUpdate = "UPDATE KhachHang "
                + "SET tenKh=?,diaChi=?,sdt=? "
                + "WHERE maKh=? ";
        PreparedStatement ps;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlUpdate);
            ps.setString(1, kh.getName());
            ps.setString(2, kh.getAddress());
            ps.setString(3, kh.getSDT());
            ps.setString(5, kh.getID());
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Update thành công", "Success", 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int deleteKhachHang(String maKh) {
        String sqlDelete = "UPDATE KhachHang SET trangThai=0 "
                + "WHERE maKh=?";
        PreparedStatement ps;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlDelete);
            ps.setString(1, maKh);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Xóa thành công", "Success", 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ArrayList<KhachHangDTO> listKh() {
        ArrayList<KhachHangDTO> listKh = new ArrayList<KhachHangDTO>();
        PreparedStatement ps;
        ResultSet rs;
        String sqlSelect = "SELECT * FROM KhachHang WHERE trangThai=1";
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlSelect);
            rs = ps.executeQuery();
            while (rs.next()) {
                String maKh = rs.getString("maKh");
                String name = rs.getString("tenKh");
                String address = rs.getString("diaChi");
                String sdt = rs.getString("sdt");
                KhachHangDTO kh = new KhachHangDTO(maKh, name, address, sdt);
                listKh.add(kh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listKh;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.RamDTO;
import util.ConnectedDatabase;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.sql.Connection;

public class RamDAO {
    //Thêm ram (ahuy)
    public int insertRam(RamDTO ram) {
        try {
            String sqlAddRam = "INSERT INTO Ram(dungLuongRam,trangThai)"
                    + "VALUES (?,1)";
            PreparedStatement ps;
            Connection conn = ConnectedDatabase.getConnectedDB();
            ps = conn.prepareStatement(sqlAddRam);
            ps.setInt(1, ram.getDungLuongRam());
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Thêm ram thành công", "Success", 1);
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    //Update ram (ahuy)
    public int updateRam(RamDTO ram) {
        try {
            String sqlUpdateRam = "UPDATE Ram SET dungLuongRam=? WHERE maRam=? ";
            PreparedStatement ps;
            Connection conn = ConnectedDatabase.getConnectedDB();
            ps = conn.prepareStatement(sqlUpdateRam);
            ps.setInt(1, ram.getDungLuongRam());
            ps.setInt(2, ram.getMaRam());
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Cập nhật ram thành công", "Success", 1);
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    //Xóa ram (ahuy)
    public int deleteRam(int maRam) {
        try {
            String sqlDeleteRam = "UPDATE Ram SET trangThai=0 WHERE maRam=? ";
            PreparedStatement ps;
            Connection conn = ConnectedDatabase.getConnectedDB();
            ps = conn.prepareStatement(sqlDeleteRam);
            ps.setInt(1, maRam);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Xóa Ram thành công", "Success", 1);
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    //Kiểm tra ram đã đc phiên bản nào sử dụng hay chưa (ahuy)
    public boolean isRamDangDuocSuDung(int maRam) {
        try {
            String sql = "SELECT COUNT(*) FROM PhienBanDienThoai WHERE maRam = ?";
            PreparedStatement ps;
            Connection conn = ConnectedDatabase.getConnectedDB();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, maRam);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    JOptionPane.showMessageDialog(null, "Ram đã được phiên bản sử dụng", "Error", 0);
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    //Lấy danh sách Ram (ahuy)
    public ArrayList<RamDTO> listRam() {
        ArrayList<RamDTO> listRam = new ArrayList<RamDTO>();
        try {
            String sqlAllRam = "SELECT * FROM Ram WHERE trangThai=1 ";
            PreparedStatement ps;
            ResultSet rs;
            Connection conn = ConnectedDatabase.getConnectedDB();
            ps = conn.prepareStatement(sqlAllRam);
            rs = ps.executeQuery();
            while (rs.next()) {
                int maRam = rs.getInt("maRam");
                int dungLuongRam = rs.getInt("dungLuongRam");
                listRam.add(new RamDTO(maRam, dungLuongRam));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listRam;
    }
    public HashMap<Integer, Integer> listMapRam() {
        HashMap<Integer, Integer> mapRam = new HashMap<>();
        try {
            String sql = "SELECT * FROM Ram where trangThai=1";
            PreparedStatement ps;
            ResultSet rs;
            Connection conn = ConnectedDatabase.getConnectedDB();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int maRam = rs.getInt("maRam");
                int dungLuongRam = rs.getInt("dungLuongRam");
                mapRam.put(dungLuongRam, maRam);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mapRam;
    }
}

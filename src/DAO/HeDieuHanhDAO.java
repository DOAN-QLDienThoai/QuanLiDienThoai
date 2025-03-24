/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.HeDieuHanhDTO;
import Data.ConnectedDatabase;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.HashMap;

public class HeDieuHanhDAO {

    public int insertHeDieuHanh(HeDieuHanhDTO hdh) {
        String sqlAddHDH = "INSERT INTO HeDieuHanh(tenHDH,trangThai)"
                + "VALUES (?,1)";
        PreparedStatement ps;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlAddHDH);
            ps.setString(1, hdh.getTenHDH());
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Thêm hệ điều hành thành công", "Success", 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int updateHDH(HeDieuHanhDTO hdh) {
        String sqlUpdateHDH = "UPDATE HeDieuHanh SET tenHDH=? WHERE maHDH=? ";
        PreparedStatement ps;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlUpdateHDH);
            ps.setString(1, hdh.getTenHDH());
            ps.setInt(2, hdh.getMaHDH());
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Cập nhật thành công", "Success", 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int deleteHDH(int maHDH) {
        String sqlDelete = "UPDATE HeDieuHanh SET trangThai=0 WHERE maHDH=? ";
        PreparedStatement ps;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlDelete);
            ps.setInt(1, maHDH);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Xóa thành công", "Success", 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ArrayList<HeDieuHanhDTO> listHDH() {
        ArrayList<HeDieuHanhDTO> listHDH = new ArrayList<HeDieuHanhDTO>();
        String sqlAllHDH = "SELECT * FROM HeDieuHanh WHERE trangThai=1 ";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlAllHDH);
            rs = ps.executeQuery();
            while (rs.next()) {
                int maHDH = rs.getInt("maHDH");
                String tenHDH = rs.getString("tenHDH");
                listHDH.add(new HeDieuHanhDTO(maHDH, tenHDH));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHDH;
    }
    
    public HashMap<String,Integer> listMapHDH() {
        HashMap<String, Integer> mapHDH = new HashMap<>();
        String sql = "SELECT * FROM HeDieuHanh WHERE trangThai=1";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int maHDH = rs.getInt("maHDH");
                String tenHDH = rs.getString("tenHDH");
                mapHDH.put(tenHDH,maHDH);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapHDH;
    }
}

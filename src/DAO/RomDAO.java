/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.RomDTO;
import util.ConnectedDatabase;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

public class RomDAO {
    //Thêm rom (ahuy)
    public int insertRom(RomDTO rom) {
        try {
            String sqlAddRom = "INSERT INTO Rom(dungLuongRom,trangThai)"
                    + "VALUES (?,1)";
            PreparedStatement ps;
            Connection conn = ConnectedDatabase.getConnectedDB();
            ps = conn.prepareStatement(sqlAddRom);
            ps.setInt(1, rom.getDungLuongRom());
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Thêm rom thành công", "Success", 1);
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    //Cập nhật rom (ahuy)
    public int updateRom(RomDTO rom) {
        try {
            String sqlUpdateRom = "UPDATE Rom SET dungLuongRom=? WHERE maRom=? ";
            PreparedStatement ps;
            Connection conn = ConnectedDatabase.getConnectedDB();
            ps = conn.prepareStatement(sqlUpdateRom);
            ps.setInt(1, rom.getDungLuongRom());
            ps.setInt(2, rom.getMaRom());
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Cập nhật rom thành công", "Success", 1);
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    //Xóa rom (ahuy)
    public int deleteRom(int maRom) {
        try {
            String sqlDeleteRam = "UPDATE Rom SET trangThai=0 WHERE maRom=? ";
            PreparedStatement ps;
            Connection conn = ConnectedDatabase.getConnectedDB();
            ps = conn.prepareStatement(sqlDeleteRam);
            ps.setInt(1, maRom);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Xóa Rom thành công", "Success", 1);
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    //Láy danh sách Rom đang hoạt động(ahuy)
    public ArrayList<RomDTO> listRom() {
        ArrayList<RomDTO> listRom = new ArrayList<RomDTO>();
        try {
            String sqlAllRom = "SELECT * FROM Rom WHERE trangThai=1 ";
            PreparedStatement ps;
            ResultSet rs;
            Connection conn = ConnectedDatabase.getConnectedDB();
            ps = conn.prepareStatement(sqlAllRom);
            rs = ps.executeQuery();
            while (rs.next()) {
                int maRom = rs.getInt("maRom");
                int dungLuongRom = rs.getInt("dungLuongRom");
                listRom.add(new RomDTO(maRom, dungLuongRom));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listRom;
    }
    //Lấy full tất cả danh sách rom (ahuy)
    public ArrayList<RomDTO> arrlistRom() {
        ArrayList<RomDTO> arrlistRom = new ArrayList<RomDTO>();
        try {
            String sqlAllRom = "SELECT * FROM Rom ";
            PreparedStatement ps;
            ResultSet rs;
            Connection conn = ConnectedDatabase.getConnectedDB();
            ps = conn.prepareStatement(sqlAllRom);
            rs = ps.executeQuery();
            while (rs.next()) {
                int maRom = rs.getInt("maRom");
                int dungLuongRom = rs.getInt("dungLuongRom");
                arrlistRom.add(new RomDTO(maRom, dungLuongRom));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrlistRom;
    }
    
}

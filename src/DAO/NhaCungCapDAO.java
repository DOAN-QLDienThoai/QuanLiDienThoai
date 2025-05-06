/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.NhaCungCapDTO;
import java.sql.Connection;
import util.ConnectedDatabase;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
public class NhaCungCapDAO {
    //Thêm nhà cung cấp (ahuy)
    public int insertNhaCungCap(NhaCungCapDTO ncc) {
        try {
            String sql = "INSERT INTO NhaCungCap (tenNCC,diaChi,sdt,email,trangThai)"
                    + "VALUES (?,?,?,?,1)";
            PreparedStatement ps;
            Connection conn = ConnectedDatabase.getConnectedDB();
            ps = conn.prepareStatement(sql);
            ps.setString(1, ncc.getName());
            ps.setString(2, ncc.getAddress());
            ps.setString(3, ncc.getSDT());
            ps.setString(4, ncc.getEmail());
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Thêm nhà cung cấp thành công", "Success", 1);
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    //Cập nhật nhà cung cấp (ahuy)
    public int updateNhaCungCap(NhaCungCapDTO ncc) {
        try {
            String sqlUpdate = "UPDATE NhaCungCap "
                    + "SET tenNCC=?,diaChi=?,sdt=?,email=? "
                    + "WHERE maNCC=? ";
            PreparedStatement ps;
            Connection conn = ConnectedDatabase.getConnectedDB();
            ps = conn.prepareStatement(sqlUpdate);
            ps.setString(1, ncc.getName());
            ps.setString(2, ncc.getAddress());
            ps.setString(3, ncc.getSDT());
            ps.setString(4, ncc.getEmail());
            ps.setInt(5, ncc.getmaNCC());
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Update thành công", "Success", 1);
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    //Xóa nhà cung cấp (ahuy)
    public int deleteNhaCungCap(int maNCC) {
        try {
            String sqlDelete = "UPDATE NhaCungCap SET trangThai=0 "
                    + "WHERE maNCC=?";
            PreparedStatement ps;
            Connection conn =ConnectedDatabase.getConnectedDB();
            ps = conn.prepareStatement(sqlDelete);
            ps.setInt(1, maNCC);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Xóa thành công", "Success", 1);
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    //Lấy danh sách nhà cung cấp đang hoạt động (ahuy)
    public ArrayList<NhaCungCapDTO> listNCC() {
        ArrayList<NhaCungCapDTO> listNcc = new ArrayList<NhaCungCapDTO>();
        try {
            String sqlSelect = "SELECT * FROM NhaCungCap WHERE trangThai=1";
            PreparedStatement ps;
            ResultSet rs;
            Connection conn = ConnectedDatabase.getConnectedDB();
            ps = conn.prepareStatement(sqlSelect);
            rs = ps.executeQuery();
            while (rs.next()) {
                int maNCC = rs.getInt("maNCC");
                String name = rs.getString("tenNCC");
                String address = rs.getString("diaChi");
                String sdt = rs.getString("sdt");
                String email = rs.getString("email");
                NhaCungCapDTO ncc = new NhaCungCapDTO(maNCC, name, address, sdt, email);
                listNcc.add(ncc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listNcc;
    }
    //Lấy danh sách nhà cung cấp (ahuy)
    public ArrayList<NhaCungCapDTO> arrlistNCC() {
        ArrayList<NhaCungCapDTO> arrlistNcc = new ArrayList<NhaCungCapDTO>();
        try {
            String sqlSelect = "SELECT * FROM NhaCungCap ";
            PreparedStatement ps;
            ResultSet rs;
            Connection conn = ConnectedDatabase.getConnectedDB();
            ps = conn.prepareStatement(sqlSelect);
            rs = ps.executeQuery();
            while (rs.next()) {
                int maNCC = rs.getInt("maNCC");
                String name = rs.getString("tenNCC");
                String address = rs.getString("diaChi");
                String sdt = rs.getString("sdt");
                String email = rs.getString("email");
                NhaCungCapDTO ncc = new NhaCungCapDTO(maNCC, name, address, sdt, email);
                arrlistNcc.add(ncc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrlistNcc;
    }
   
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.NhaCungCapDTO;
import Data.ConnectedDatabase;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class NhaCungCapDAO {
    public int insertNhaCungCap(NhaCungCapDTO ncc) throws SQLException {
        String sql = "INSERT INTO NhaCungCap (maNCC,tenNCC,diaChi,sdt,email,trangThai)"
                + "VALUES (?,?,?,?,?,1)";
        PreparedStatement ps;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sql);
            ps.setString(1, ncc.getID());
            ps.setString(2, ncc.getName());
            ps.setString(3, ncc.getAddress());
            ps.setString(4, ncc.getSDT());
            ps.setString(5, ncc.getEmail());
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Thêm nhà cung cấp thành công", "Success", 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int updateNhaCungCap(NhaCungCapDTO ncc) throws SQLException {
        String sqlUpdate = "UPDATE NhaCungCap "
                + "SET tenNCC=?,diaChi=?,sdt=?,email=? "
                + "WHERE maNCC=? ";
        PreparedStatement ps;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlUpdate);
            ps.setString(1, ncc.getName());
            ps.setString(2, ncc.getAddress());
            ps.setString(3, ncc.getSDT());
            ps.setString(4, ncc.getEmail());
            ps.setString(5, ncc.getID());
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Update thành công", "Success", 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int deleteNhaCungCap(String maNCC) {
        String sqlDelete = "UPDATE NhaCungCap SET trangThai=0 "
                + "WHERE maNCC=?";
        PreparedStatement ps;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlDelete);
            ps.setString(1, maNCC);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Xóa thành công", "Success", 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ArrayList<NhaCungCapDTO> listNCC() {
        ArrayList<NhaCungCapDTO> listNcc = new ArrayList<NhaCungCapDTO>();
        PreparedStatement ps;
        ResultSet rs;
        String sqlSelect = "SELECT * FROM NhaCungCap WHERE trangThai=1";
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlSelect);
            rs = ps.executeQuery();
            while (rs.next()) {
                String maNCC = rs.getString("maNCC");
                String name = rs.getString("tenNCC");
                String address = rs.getString("diaChi");
                String sdt = rs.getString("sdt");
                String email = rs.getString("email");
                NhaCungCapDTO ncc = new NhaCungCapDTO(maNCC, name, address, sdt, email);
                listNcc.add(ncc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listNcc;
    }
}

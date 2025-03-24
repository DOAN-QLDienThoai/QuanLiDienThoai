/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NhanVienDTO;
import Data.ConnectedDatabase;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author kiman
 */
public class NhanVienDAO {

    public int insertNhanVien(NhanVienDTO nv) throws SQLException {
        try {
            String sqlAdd = "INSERT INTO NhanVien(maNV,hoTen,ngaySinh,gioiTinh,sdt,trangThai) "
                    + "VALUES (?,?,?,?,?,1)";
            PreparedStatement ps;
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlAdd);
            ps.setString(1, nv.getMaNV());
            ps.setString(2, nv.getHoTen());
            ps.setDate(3, (Date) nv.getNgaySinh());
            ps.setString(4, nv.getGioiTinh());
            ps.setString(5, nv.getSDT());
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công");
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int updateNhanVien(NhanVienDTO nv) {
        try {
            String sqlUpdate = "UPDATE NhanVien "
                    + "SET hoTen=?,ngaySinh=?,gioiTinh=?,sdt=? "
                    + "WHERE maNV=?";
            PreparedStatement ps;
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlUpdate);
            ps.setString(1, nv.getHoTen());
            ps.setDate(2, new java.sql.Date(nv.getNgaySinh().getTime()));
            ps.setString(3, nv.getGioiTinh());
            ps.setString(4, nv.getSDT());
            ps.setString(5, nv.getMaNV());
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Cập nhật thông tin nhân viên thành công", "Success", 1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int deleteNhanVien(String maNV) {
        try {
            String sqlDelete = "UPDATE NhanVien SET trangThai=0 "
                    + "WHERE maNV=?";
            PreparedStatement ps;
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlDelete);
            ps.setString(1, maNV);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Xóa thành công", "Success", 1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    

    public ArrayList<NhanVienDTO> listNV() {
        ArrayList<NhanVienDTO> listNV = new ArrayList<NhanVienDTO>();
        String sqlListNV = "SELECT * FROM NhanVien WHERE trangThai=1";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlListNV);
            rs = ps.executeQuery();
            while (rs.next()) {
                String maNV = rs.getString("maNV");
                String hoTen = rs.getString("hoTen");
                Date ngaySinh = rs.getDate("ngaySinh");
                String gioiTinh = rs.getString("gioiTinh");
                String sdt = rs.getString("sdt");
                listNV.add(new NhanVienDTO(maNV, hoTen, ngaySinh, gioiTinh, sdt));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listNV;
    }
    
    
}

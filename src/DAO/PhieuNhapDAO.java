/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.PhieuNhapDTO;
import util.ConnectedDatabase;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class PhieuNhapDAO {
    public int insertPhieuNhapDienThoai (PhieuNhapDTO pn){
        try{
            String sqlAdd = "INSERT INTO PhieuNhap(maPN,thoigian,tongtien,maNCC,maNV,trangthai )"
                    + "VAlUES (?,?,?,?,?,1)";
            PreparedStatement ps;
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlAdd);
            ps.setInt(0, pn.getMaPhieuNhap());
            ps.setDate(1, (Date) pn.getNgayNhap());
            ps.setLong(2, pn.getTongTien());
            ps.setInt(3, pn.getNhaCungCap());
            ps.setInt(4, pn.getNhanVien());
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Tạo phiếu nhập thành công", "Success" , 1);
                return 1;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    
    public int deletePhieuNhap(int maPN) {
        try{
            String sqlDelete = "UPDATE PhieuNhap SET trangthai = 0 "
                    + "WHERE maPN=?";
            PreparedStatement ps;
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlDelete);
            ps.setInt(1, maPN);
            if (ps.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Xóa phiếu nhập thành công", "Success", 1);
                return 1;
            } 
        } catch (Exception ex){
                ex.printStackTrace();
                }
        return 0;
    }
    public int updatePhieuNhap(PhieuNhapDTO pn){
        try {
            String sqlUpdate = "UPDATE PhieuNhap "
                    + "SET thoigian=?,tongtien=?,maNCC=?,maNV=? "
                    + "WHERE maPN=?";
            PreparedStatement ps;
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlUpdate);
            ps.setDate(1, (Date)pn.getNgayNhap());
            ps.setLong(2, pn.getTongTien());
            ps.setInt(3, pn.getNhaCungCap());
            ps.setInt(4, pn.getNhanVien());
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Cap nhat thong tin phieu nhap thanh cong", "Success", 1);
                return 1;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    public ArrayList<PhieuNhapDTO> ListPN() {
        ArrayList<PhieuNhapDTO> ListPN = new ArrayList<>();
        String sqlListPN = "SELECT * FROM PhieuNhap WHERE trangthai=1";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlListPN);
            rs = ps.executeQuery();
            while(rs.next()) {
                int maPN = rs.getInt("maPN");
                Date thoigian = rs.getDate("thoigian");
                long tongtien = rs.getLong("tongtien");
                int maNCC = rs.getInt("maNCC");
                int maNV = rs.getInt("maNV");
                ListPN.add(new PhieuNhapDTO(maPN,thoigian,tongtien,maNCC,maNV));
            }
        } catch (SQLException ex) {
                    Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
        return ListPN;
    }
}

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
            String sqlAdd = "INSERT INTO PhieuNhap(maPN,maNV,maNCC,thoigian,tongtien,trangthai )"
                    + "VAlUES (?,?,?,?,?,1)";
            PreparedStatement ps;
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlAdd);
            ps.setString(1, pn.getMaPhieuNhap());
            ps.setInt(2, pn.getNhanVien());
            ps.setInt(3, pn.getNhaCungCap());
            ps.setDate(4, (Date) pn.getNgayNhap());
            ps.setDouble(5, pn.getTongTien());
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Tạo phiếu nhập thành công", "Success" , 1);
                return 1;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    
    public int deletePhieuNhap(String maPN) {
        try {
            PhienBanDienThoaiDAO pbDao = new PhienBanDienThoaiDAO();
            DienThoaiDAO dtDao = new DienThoaiDAO();
            String sqlSelect = "SELECT maPhienBan, soluong FROM ChiTietPhieuNhap WHERE maPN = ?";
            PreparedStatement psSelect = ConnectedDatabase.getConnectedDB().prepareStatement(sqlSelect);
            psSelect.setString(1, maPN);
            ResultSet rs = psSelect.executeQuery();
            while (rs.next()) {
                int maPhienBan = rs.getInt("maPhienBan");
                int soLuong = rs.getInt("soluong");
                pbDao.updateSoLuongTonPhienBan(maPhienBan, -soLuong);
                dtDao.updateSoLuongTonDienThoai(maPhienBan, -soLuong);
            }
            String sqlUpdate = "UPDATE PhieuNhap SET trangthai = 0 WHERE maPN = ?";
            PreparedStatement psUpdate = ConnectedDatabase.getConnectedDB().prepareStatement(sqlUpdate);
            psUpdate.setString(1, maPN);
            if (psUpdate.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Hủy phiếu nhập và cập nhật tồn kho thành công!", "Success", 1);
                return 1;
            }

        } catch (Exception ex) {
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
            ps.setInt(2, pn.getNhaCungCap());
            ps.setInt(3, pn.getNhanVien());
            ps.setDouble(4, pn.getTongTien());
            ps.setString(5, pn.getMaPhieuNhap());
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Cap nhat thong tin phieu nhap thanh cong", "Success", 1);
                return 1;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    public ArrayList<PhieuNhapDTO> listPN() {
        ArrayList<PhieuNhapDTO> ListPN = new ArrayList<>();
        String sqlListPN = "SELECT * FROM PhieuNhap WHERE trangthai=1";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlListPN);
            rs = ps.executeQuery();
            while(rs.next()) {
                String maPN = rs.getString("maPN");
                int maNV = rs.getInt("maNV");
                int maNCC = rs.getInt("maNCC");
                Date thoigian = rs.getDate("thoigian");
                long tongtien = rs.getLong("tongtien");
                ListPN.add(new PhieuNhapDTO(maPN,maNV,maNCC,thoigian,tongtien));
            }
        } catch (SQLException ex) {
                    Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
        return ListPN;
    }
    public ArrayList<PhieuNhapDTO> listPNFull() {
        ArrayList<PhieuNhapDTO> ListPN = new ArrayList<>();
        String sqlListPN = "SELECT * FROM PhieuNhap ";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlListPN);
            rs = ps.executeQuery();
            while(rs.next()) {
                String maPN = rs.getString("maPN");
                int maNV = rs.getInt("maNV");
                int maNCC = rs.getInt("maNCC");
                Date thoigian = rs.getDate("thoigian");
                long tongtien = rs.getLong("tongtien");
                ListPN.add(new PhieuNhapDTO(maPN,maNV,maNCC,thoigian,tongtien));
            }
        } catch (SQLException ex) {
                    Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
        return ListPN;
    }
    public PhieuNhapDTO getPhieuNhapByMaPN(String maPN) {
        String sql = "SELECT * FROM PhieuNhap WHERE maPN = ? ";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sql);
            ps.setString(1, maPN);
            rs = ps.executeQuery();
            if (rs.next()) {
                int maNV = rs.getInt("maNV");
                int maNCC = rs.getInt("maNCC");
                Date thoigian = rs.getDate("thoigian");
                long tongtien = rs.getLong("tongtien");
                return new PhieuNhapDTO(maPN, maNV, maNCC, thoigian, tongtien);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

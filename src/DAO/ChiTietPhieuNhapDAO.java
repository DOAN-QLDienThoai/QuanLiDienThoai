/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author phant
 */
import DTO.ChiTietPhieuNhapDTO;
import util.ConnectedDatabase;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChiTietPhieuNhapDAO {
    public int insertChiTietPhieuNhap(ChiTietPhieuNhapDTO ctpn){
        try{
            String sqlAdd = "INSERT INTO ctphieunhap(maPhienBan,soluong,dongia,hinhthucnhap) "
                    + "VALUES (?,?,?,?) ";
            PreparedStatement ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlAdd);
            ps.setInt(1, ctpn.getMasp());
            ps.setInt(2, ctpn.getSoluong());
            ps.setInt(3, ctpn.getDongia());
            ps.setString(4, ctpn.getHinhthucnhap());
            if(ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Tao chi tiet phieu nhap thanh cong", "Success", 1);
                return 1;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    public int DeleteChiTietPhieuNhap(int maPN){
        try{
            String sqlDelete = "DELETE FROM ctphieunhap "
                    + "WHERE maPN=?";
            PreparedStatement ps;
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlDelete);
            ps.setInt(1, maPN);
            if (ps.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Xóa chi tiet phiếu nhập thành công", "Success", 1);
                return 1;
            } 
        } catch (SQLException ex){
                Logger.getLogger(ChiTietPhieuNhapDAO.class.getName()).log(Level.SEVERE, null ,ex);
                }
        return 0;
    }
    public int UpdateChiTietPhieuNhap(ChiTietPhieuNhapDTO ctpn){
        try {
            String sqlUpdate = "UPDATE ctphieunhap "
                    + "SET maPhienBan=?,soluong=?,dongia=?,hinhthucnhap=? "
                    + "WHERE maPN=?";
            PreparedStatement ps;
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlUpdate);
            ps.setInt(1, ctpn.getMasp());
            ps.setInt(2, ctpn.getSoluong());
            ps.setInt(3, ctpn.getDongia());
            ps.setString(4, ctpn.getHinhthucnhap());
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Cap nhat thong tin phieu nhap thanh cong", "Success", 1);
                return 1;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    public ArrayList<ChiTietPhieuNhapDTO> ListCTPN() {
        ArrayList<ChiTietPhieuNhapDTO> ListCTPN = new ArrayList<>();
        String sqlListCTPN = "SELECT * FROM ctphieunhap WHERE maPN=?";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlListCTPN);
            rs = ps.executeQuery();
            while(rs.next()) {
                int maPN = rs.getInt("maPN");
                int maPhienBan = rs.getInt("maPhienBan");
                int soluong = rs.getInt("soluong");
                int dongia = rs.getInt("dongia");
                String hinhthucnhap = rs.getString("hinhthucnhap");
                ListCTPN.add(new ChiTietPhieuNhapDTO(maPN,maPhienBan,soluong,dongia,hinhthucnhap));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietPhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ListCTPN;
    }
}
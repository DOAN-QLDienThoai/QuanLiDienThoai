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
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChiTietPhieuNhapDAO {
    public int insertChiTietPhieuNhap(ChiTietPhieuNhapDTO ctpn){
        try{
            String sqlAdd = "INSERT INTO ChiTietPhieuNhap(maPN,maPhienBan,soluong,dongia) "
                    + "VALUES (?,?,?,?) ";
            PreparedStatement ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlAdd);
            ps.setString(1, ctpn.getMaPhieuNhap());
            ps.setInt(2, ctpn.getMaPB());
            ps.setInt(3, ctpn.getSoluong());
            ps.setDouble(4, ctpn.getDongia());
            if(ps.executeUpdate() > 0) {
                return 1;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    public int deleteChiTietPhieuNhap(String maPN,int maPhienBan){
        try{
            String sqlDelete = "DELETE FROM ChiTietPhieuNhap "
                    + "WHERE maPN=? AND maPhienBan=?";
            PreparedStatement ps;
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlDelete);
            ps.setString(1, maPN);
            ps.setInt(1, maPhienBan);
            if (ps.executeUpdate() > 0){
                return 1;
            }
        } catch (SQLException ex){
                Logger.getLogger(ChiTietPhieuNhapDAO.class.getName()).log(Level.SEVERE, null ,ex);
                }
        return 0;
    }
    public int updateChiTietPhieuNhap(ChiTietPhieuNhapDTO ctpn){
        try {
            String sqlUpdate = "UPDATE ChiTietPhieuNhap "
                    + "SET soluong=?,dongia=? "
                    + "WHERE maPN=? AND maPhienBan=?";
            PreparedStatement ps;
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlUpdate);
            ps.setInt(1, ctpn.getSoluong());
            ps.setDouble(2, ctpn.getDongia());
            ps.setString(3,ctpn.getMaPhieuNhap());
            ps.setInt(4,ctpn.getMaPB());
            if(ps.executeUpdate() > 0){
                return 1;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    public ArrayList<ChiTietPhieuNhapDTO> listCTPN() {
        ArrayList<ChiTietPhieuNhapDTO> ListCTPN = new ArrayList<>();
        String sqlListCTPN = "SELECT * FROM ChiTietPhieuNhap ";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlListCTPN);
            rs = ps.executeQuery();
            while(rs.next()) {
                String maPN = rs.getString("maPN");
                int maPhienBan = rs.getInt("maPhienBan");
                int soluong = rs.getInt("soluong");
                double dongia = rs.getDouble("dongia");
                ListCTPN.add(new ChiTietPhieuNhapDTO(maPN,maPhienBan,soluong,dongia));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietPhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ListCTPN;
    }
    public ArrayList<ChiTietPhieuNhapDTO> listCTPNByMaPN(String maPN) {
        ArrayList<ChiTietPhieuNhapDTO> ListCTPN = new ArrayList<>();
        String sqlListCTPN = "SELECT * FROM ChiTietPhieuNhap WHERE maPN=?";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlListCTPN);
            ps.setString(1,maPN);
            rs = ps.executeQuery();
            while(rs.next()) {
                int maPhienBan = rs.getInt("maPhienBan");
                int soluong = rs.getInt("soluong");
                double dongia = rs.getDouble("dongia");
                ListCTPN.add(new ChiTietPhieuNhapDTO(maPN,maPhienBan,soluong,dongia));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietPhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ListCTPN;
    }
}
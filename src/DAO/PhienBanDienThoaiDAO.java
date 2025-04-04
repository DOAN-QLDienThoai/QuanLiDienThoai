/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.PhienBanDienThoaiDTO;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import Data.ConnectedDatabase;
import java.util.ArrayList;
import java.sql.ResultSet;
/**
 *
 * @author kiman
 */
public class PhienBanDienThoaiDAO {
    public int insertPhienBan(PhienBanDienThoaiDTO pb) {
        String sqlAddPB = "INSERT INTO PhienBanDienThoai(maDT, maRam, maRom, maMau, giaNhap, giaXuat)" +
                          " VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlAddPB);
            ps.setInt(1, pb.getMaDT());
            ps.setInt(2, pb.getmaRam());
            ps.setInt(3, pb.getmaRom());
            ps.setInt(4, pb.getmaMau());
            ps.setDouble(5, pb.getGiaNhap());
            ps.setDouble(6, pb.getGiaXuat());
            if(ps.executeUpdate()>0){
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int updatePhienBan(PhienBanDienThoaiDTO pb) {
        String sqlUpdatePB = "UPDATE PhienBanDienThoai SET maRam=?, maRom=?, maMau=?, giaNhap=?, giaXuat=? WHERE maPhienBan=? ";
        PreparedStatement ps;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlUpdatePB);
            ps.setInt(1, pb.getmaRam());
            ps.setInt(2, pb.getmaRom());
            ps.setInt(3, pb.getmaMau());
            ps.setDouble(4, pb.getGiaNhap());
            ps.setDouble(5, pb.getGiaXuat());
            ps.setInt(6, pb.getMaPhienBan());
            if (ps.executeUpdate() > 0) {
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
     public int deletePhienBan(int maPhienBan) {
        String sqlDeletePB = "DELETE PhienBanDienThoai WHERE maPhienBan=? ";
        PreparedStatement ps;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlDeletePB);
            ps.setInt(1, maPhienBan);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Xóa phiên bản điện thoại thành công", "Success", 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public ArrayList<PhienBanDienThoaiDTO> listPhienBan() {
        ArrayList<PhienBanDienThoaiDTO> listPB = new ArrayList<>();
        String sqlAllPB = "SELECT * FROM PhienBanDienThoai ";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlAllPB);
            rs = ps.executeQuery();
            while (rs.next()) {
                int maPhienBan = rs.getInt("maPhienBan");
                int maDT = rs.getInt("maDT");
                int maRam = rs.getInt("maRam");
                int maRom = rs.getInt("maRom");
                int maMau = rs.getInt("maMau");
                double giaNhap = rs.getDouble("giaNhap");
                double giaXuat = rs.getDouble("giaXuat");
                listPB.add(new PhienBanDienThoaiDTO(maPhienBan,maDT, maRam, maRom,maMau, giaNhap, giaXuat));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPB;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import util.ConnectedDatabase;

/**
 *
 * @author THANH HIEU
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.ConnectedDatabase;
import DTO.TaiKhoanDTO;

public class TaiKhoanDAO {
    
    public TaiKhoanDTO ktraDangNhap(String tenDangNhap, String matKhau) {
        String sql = "SELECT * FROM TaiKhoan WHERE tendangnhap = ? AND matkhau = ? AND trangthai = '1'";
        try (Connection conn = ConnectedDatabase.getConnectedDB();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             
            ps.setString(1, tenDangNhap);
            ps.setString(2, matKhau);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                TaiKhoanDTO tk = new TaiKhoanDTO();
                tk.setMaNV(rs.getInt("manv"));
                tk.setTenDangNhap(rs.getString("tendangnhap"));
                tk.setMatKhau(rs.getString("matkhau"));
                tk.setTrangThai(rs.getString("trangthai"));
                return tk;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean capNhatTrangThaiDangNhap(int maNV, boolean isLogin) {
    String sql = "UPDATE TaiKhoan SET islogin = ? WHERE manv = ?";
    try (Connection conn = ConnectedDatabase.getConnectedDB();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setBoolean(1, isLogin);
        ps.setInt(2, maNV);
        int rowsAffected = ps.executeUpdate();
        return rowsAffected > 0;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}
 
}



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
/**
 *
 * @author THANH HIEU
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.ConnectedDatabase;
import DTO.TaiKhoanDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TaiKhoanDAO {
    //Thêm tài khoản (ahuy)
    public int insertTaiKhoan(TaiKhoanDTO taiKhoan) {
        try {
            String sqlAddTaiKhoan = "INSERT INTO TaiKhoan(maNV, tenDangNhap, matKhau, trangThai) "
                    + "VALUES (?, ?, ?, ?)";
            PreparedStatement ps;
            Connection conn = ConnectedDatabase.getConnectedDB();
            ps = conn.prepareStatement(sqlAddTaiKhoan);
            ps.setInt(1, taiKhoan.getMaNV());
            ps.setString(2, taiKhoan.getTenDangNhap());
            ps.setString(3, taiKhoan.getMatKhau());
            ps.setString(4, taiKhoan.getTrangThai());
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Thêm tài khoản thành công", "Success", 1);
                return 1;
            }
            ConnectedDatabase.closeConnectedDB(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    //Update tài khoản (ahuy)
    public int updateTaiKhoan(TaiKhoanDTO taiKhoan) {
        try {
            String sqlUpdateTaiKhoan = "UPDATE TaiKhoan SET tenDangNhap = ?, matKhau = ?, trangThai = ? WHERE maNV = ?";
            PreparedStatement ps;
            Connection conn = ConnectedDatabase.getConnectedDB();
            ps = conn.prepareStatement(sqlUpdateTaiKhoan);
            ps.setString(1, taiKhoan.getTenDangNhap());
            ps.setString(2, taiKhoan.getMatKhau());
            ps.setString(3, taiKhoan.getTrangThai());
            ps.setInt(4, taiKhoan.getMaNV());
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Cập nhật tài khoản thành công", "Success", 1);
                return 1;
            }
            ConnectedDatabase.closeConnectedDB(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    //Xóa tài khoản (ahuy)
    public int deleteTaiKhoan(int maNV) {
        try {
            String sqlDeleteTaiKhoan = "UPDATE TaiKhoan SET trangThai = 2 WHERE maNV = ?";
            PreparedStatement ps;
            Connection conn =ConnectedDatabase.getConnectedDB();
            ps = conn.prepareStatement(sqlDeleteTaiKhoan);
            ps.setInt(1, maNV);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Xóa (khóa) tài khoản thành công", "Success", 1);
                return 1;
            }
            ConnectedDatabase.closeConnectedDB(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int updatePass(int maNV, String newPass) {
        try {
            String sqlUpdatePass = "UPDATE TaiKhoan SET matKhau = ? WHERE maNV = ?";
            PreparedStatement ps;
            Connection conn = ConnectedDatabase.getConnectedDB();
            ps = conn.prepareStatement(sqlUpdatePass);
            ps.setString(1, newPass);
            ps.setInt(2, maNV);
            
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Cập nhật mật khẩu thành công", "Success", 1);
                return 1;
            }
            ConnectedDatabase.closeConnectedDB(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    //Lấy tài khoản bởi maNV (ahuy)
    public TaiKhoanDTO getUserByMaNV(int maNV) {
        try {
            String sql = "SELECT * FROM TaiKhoan WHERE maNV = ? ";
            PreparedStatement ps;
            ResultSet rs;
            Connection conn = ConnectedDatabase.getConnectedDB();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, maNV);
            rs = ps.executeQuery();
            if (rs.next()) {
                String tk = rs.getString("tenDangNhap");
                String mk = rs.getString("matKhau");
                String trangThai = rs.getString("trangThai");
                return new TaiKhoanDTO(maNV, tk, mk, trangThai);
            }
            ConnectedDatabase.closeConnectedDB(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //Lấy danh sách tài khoản (ahuy)
    public ArrayList<TaiKhoanDTO> listTaiKhoan() {
        ArrayList<TaiKhoanDTO> listTaiKhoan = new ArrayList<>();
        try {
            String sqlAllTaiKhoan = "SELECT * FROM TaiKhoan WHERE trangthai='1' OR trangthai='0' ";
            PreparedStatement ps;
            ResultSet rs;
            Connection conn = ConnectedDatabase.getConnectedDB();
            ps = conn.prepareStatement(sqlAllTaiKhoan);
            rs = ps.executeQuery();
            while (rs.next()) {
                int maNV = rs.getInt("maNV");
                String tenDangNhap = rs.getString("tenDangNhap");
                String matKhau = rs.getString("matKhau");
                String trangThai = rs.getString("trangThai"); // Có thể là String hoặc int tùy bạn thiết kế
                listTaiKhoan.add(new TaiKhoanDTO(maNV, tenDangNhap, matKhau, trangThai));
            }
            ConnectedDatabase.closeConnectedDB(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listTaiKhoan;
    }

    public TaiKhoanDTO isLoginCheck() {
        String sql = "SELECT * FROM TaiKhoan WHERE isLogin= 1 AND trangthai = 1 ";
        try (Connection conn = ConnectedDatabase.getConnectedDB(); PreparedStatement ps = conn.prepareStatement(sql)) {
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
    public TaiKhoanDTO ktraDangNhap(String tenDangNhap, String matKhau) {
        String sql = "SELECT * FROM TaiKhoan WHERE tendangnhap = ? AND matkhau = ? AND trangthai = '1'";
        try (Connection conn = ConnectedDatabase.getConnectedDB(); PreparedStatement ps = conn.prepareStatement(sql)) {
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
        try (Connection conn = ConnectedDatabase.getConnectedDB(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setBoolean(1, isLogin);
            ps.setInt(2, maNV);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //Lấy tài khoản đang đăng nhập 
    public TaiKhoanDTO getTKIsLogin() {
        String sql = "SELECT * FROM TaiKhoan WHERE islogin = 1";
        try (Connection conn = ConnectedDatabase.getConnectedDB(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                TaiKhoanDTO tk = new TaiKhoanDTO();
                tk.setTenDangNhap(rs.getString("tendangnhap"));
                tk.setMatKhau(rs.getString("matkhau"));
                tk.setMaNV(rs.getInt("manv"));
                return tk;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}



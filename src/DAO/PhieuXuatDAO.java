package DAO;

import DTO.PhieuXuatDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.ConnectedDatabase;
import javax.swing.JOptionPane;

public class PhieuXuatDAO {

    public ArrayList<String> layDanhSachMaPhieuXuat() {
        ArrayList<String> danhSachMa = new ArrayList<>();
        String sql = "SELECT maPX FROM phieuxuat";
        try (Connection conn = ConnectedDatabase.getConnectedDB();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                danhSachMa.add(rs.getString("maPX"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSachMa;
    }
    public boolean themPhieuXuat(String maPhieu, String maNV, String maKh, String ngayTao, double tongTien) {
       String sql = "INSERT INTO phieuxuat(maPX, maNV, maKh, thoigian, tongtien,trangthai) VALUES (?, ?, ?, ?, ?, 1)";
        try (Connection conn = ConnectedDatabase.getConnectedDB();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, maPhieu);
        ps.setString(2, maNV);
        ps.setString(3, maKh);
        ps.setString(4, ngayTao);
        ps.setDouble(5, tongTien);
        return ps.executeUpdate() > 0;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
    }
    public ArrayList<PhieuXuatDTO> layTatCaPhieuXuat() {
    ArrayList<PhieuXuatDTO> list = new ArrayList<>();
    String sql = "SELECT * FROM phieuxuat WHERE trangThai = 1 ORDER BY thoigian DESC";
    try (Connection conn = ConnectedDatabase.getConnectedDB();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            PhieuXuatDTO px = new PhieuXuatDTO(
                rs.getString("maPX"),
                rs.getString("thoigian"),
                rs.getString("maNV"),
                rs.getString("maKH"),
                rs.getDouble("tongTien"),
                rs.getInt("trangThai")
            );
            list.add(px);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
    }
    // Vị trí thêm: Cuối class PhieuXuatDAO.java
    public void xoaPhieuXuatVaCapNhatTonKho(String maPX) {
        Connection conn = null;
        try {
            conn = ConnectedDatabase.getConnectedDB();
            conn.setAutoCommit(false); // Bắt đầu transaction
            // 1. Lấy chi tiết phiếu xuất
            String sqlLayChiTiet = "SELECT maPhienBan, soluong FROM chitietphieuxuat WHERE maPX = ?";
            PreparedStatement ps1 = conn.prepareStatement(sqlLayChiTiet);
            ps1.setString(1, maPX);
            ResultSet rs = ps1.executeQuery();
            // 2. Cập nhật lại tồn kho
            while (rs.next()) {
                int maPhienBan = rs.getInt("maPhienBan");
                int soLuong = rs.getInt("soluong");
                String sqlUpdateTon = "UPDATE phienbandienthoai SET soLuongTon = soLuongTon + ? WHERE maPhienBan = ?";
                PreparedStatement ps2 = conn.prepareStatement(sqlUpdateTon);
                ps2.setInt(1, soLuong);
                ps2.setInt(2, maPhienBan);
                ps2.executeUpdate();
            }
            // 3. Xoá chi tiết phiếu xuất
            PreparedStatement ps3 = conn.prepareStatement("DELETE FROM chitietphieuxuat WHERE maPX = ?");
            ps3.setString(1, maPX);
            ps3.executeUpdate();
            // 4. Xoá phiếu xuất chính
            PreparedStatement ps4 = conn.prepareStatement("UPDATE phieuxuat SET trangThai = 0 WHERE maPX = ?");
            ps4.setString(1, maPX);
            ps4.executeUpdate();
            conn.commit();
            JOptionPane.showMessageDialog(null, "Đã xóa phiếu xuất và cập nhật tồn kho!");
        } catch (Exception e) {
            try {
                if (conn != null) conn.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Xóa thất bại: " + e.getMessage());
        } finally {
            try {
                if (conn != null) conn.setAutoCommit(true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }


}

package DAO;

import DTO.ChiTietPhieuXuatDTO;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import util.ConnectedDatabase;

public class ChiTietPhieuXuatDAO {
    public boolean themChiTiet(String maPX, int maPhienBan, int soLuong, double donGia) {
        String sql = "INSERT INTO chitietphieuxuat(maPX, maPhienBan, soluong, dongia) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectedDatabase.getConnectedDB();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maPX);
            ps.setInt(2, maPhienBan);
            ps.setInt(3, soLuong);
            ps.setDouble(4, donGia);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Lỗi thêm chi tiết phiếu xuất: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
    public boolean xoaChiTietTheoMaPX(String maPX) {
        String sql = "DELETE FROM chitietphieuxuat WHERE maPX = ?";
        try (Connection conn = ConnectedDatabase.getConnectedDB();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maPX);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Lỗi xoá chi tiết phiếu xuất: " + e.getMessage());
        }
        return false;
    }
    public ArrayList<ChiTietPhieuXuatDTO> layChiTietTheoMaPhieu(String maPX) {
    ArrayList<ChiTietPhieuXuatDTO> ds = new ArrayList<>();
    String sql = "SELECT ct.maPhienBan, dt.tenDT AS tenSanPham, ct.soluong, ct.dongia " +
                 "FROM chitietphieuxuat ct " +
                 "JOIN phienbandienthoai pb ON ct.maPhienBan = pb.maPhienBan " +
                 "JOIN dienthoai dt ON pb.maDT = dt.maDT " +
                 "WHERE ct.maPX = ?";
    try (Connection conn = ConnectedDatabase.getConnectedDB();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, maPX);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ChiTietPhieuXuatDTO ct = new ChiTietPhieuXuatDTO();
            ct.setMaPhienBan(rs.getInt("maPhienBan"));
            ct.setTenSanPham(rs.getString("tenSanPham")); // ✅ Thêm dòng này
            ct.setSoLuong(rs.getInt("soluong"));
            ct.setDonGia(rs.getDouble("dongia"));
            ds.add(ct);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return ds;
}

}

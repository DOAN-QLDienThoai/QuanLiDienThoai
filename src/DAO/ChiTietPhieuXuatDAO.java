package DAO;

import DTO.ChiTietPhieuXuatDTO;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import util.ConnectedDatabase;

public class ChiTietPhieuXuatDAO {

    public boolean themChiTiet(Connection conn, String maPX, int maPhienBan, int soLuong, double donGia) {
        String sql = "INSERT INTO chitietphieuxuat(maPX, maPhienBan, soluong, dongia) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maPX);
            ps.setInt(2, maPhienBan);
            ps.setInt(3, soLuong);
            ps.setDouble(4, donGia);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean xoaChiTietTheoMaPX(String maPX) {
        String sql = "DELETE FROM chitietphieuxuat WHERE maPX = ?";
        try (Connection conn = ConnectedDatabase.getConnectedDB(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maPX);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Lỗi xoá chi tiết phiếu xuất: " + e.getMessage());
        }
        return false;
    }

    public ArrayList<ChiTietPhieuXuatDTO> layChiTietTheoMaPhieu(String maPX) {
        ArrayList<ChiTietPhieuXuatDTO> ds = new ArrayList<>();
        String sql = "SELECT ct.maPhienBan, dt.tenDT AS tenSanPham, ct.soluong, ct.dongia "
                + "FROM chitietphieuxuat ct "
                + "JOIN phienbandienthoai pb ON ct.maPhienBan = pb.maPhienBan "
                + "JOIN dienthoai dt ON pb.maDT = dt.maDT "
                + "WHERE ct.maPX = ?";
        try (Connection conn = ConnectedDatabase.getConnectedDB(); PreparedStatement ps = conn.prepareStatement(sql)) {
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
    public HashMap<Integer, Integer> thongKeSoLuongXuatTheoMaDT() {
        HashMap<Integer, Integer> map = new HashMap<>();
        String sql = "SELECT dt.maDT, SUM(ctpx.soLuong) AS tongSoLuongXuat "
                + "FROM chitietphieuxuat ctpx "
                + "JOIN phienbandienthoai pb ON ctpx.maPhienBan = pb.maPhienBan "
                + "JOIN dienthoai dt ON pb.maDT = dt.maDT "
                + "GROUP BY dt.maDT";
        try (Connection conn = ConnectedDatabase.getConnectedDB(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int maDT = rs.getInt("maDT");
                int soLuongXuat = rs.getInt("tongSoLuongXuat");
                map.put(maDT, soLuongXuat);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}

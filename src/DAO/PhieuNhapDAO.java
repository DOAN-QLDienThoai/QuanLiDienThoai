/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.PhieuNhapDTO;
import util.ConnectedDatabase;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
public class PhieuNhapDAO {
    //Thêm 1 phiếu nhập (ahuy)
    public int insertPhieuNhapDienThoai(PhieuNhapDTO pn) {
        try {
            String sqlAdd = "INSERT INTO PhieuNhap(maPN,maNV,maNCC,thoigian,tongtien,trangthai )"
                    + "VAlUES (?,?,?,?,?,1)";
            PreparedStatement ps;
            Connection conn = ConnectedDatabase.getConnectedDB();
            ps = conn.prepareStatement(sqlAdd);
            ps.setString(1, pn.getMaPhieuNhap());
            ps.setInt(2, pn.getNhanVien());
            ps.setInt(3, pn.getNhaCungCap());
            ps.setDate(4, (Date) pn.getNgayNhap());
            ps.setDouble(5, pn.getTongTien());
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Tạo phiếu nhập thành công", "Success", 1);
                return 1;
            }
            ConnectedDatabase.closeConnectedDB(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    //Cập nhật 1 phiếu nhập (ahuy)
    public int updatePhieuNhap(PhieuNhapDTO pn) {
        try {
            String sqlUpdate = "UPDATE PhieuNhap "
                    + "SET thoigian=?,tongtien=?,maNCC=?,maNV=? "
                    + "WHERE maPN=?";
            PreparedStatement ps;
            Connection conn = ConnectedDatabase.getConnectedDB();
            ps = conn.prepareStatement(sqlUpdate);
            ps.setDate(1, (Date) pn.getNgayNhap());
            ps.setInt(2, pn.getNhaCungCap());
            ps.setInt(3, pn.getNhanVien());
            ps.setDouble(4, pn.getTongTien());
            ps.setString(5, pn.getMaPhieuNhap());
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Cap nhat thong tin phieu nhap thanh cong", "Success", 1);
                return 1;
            }
            ConnectedDatabase.closeConnectedDB(conn);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    //Xóa 1 phiếu nhập (ahuy)
    public int deletePhieuNhap(String maPN) {
        try {
            PhienBanDienThoaiDAO pbDao = new PhienBanDienThoaiDAO();
            DienThoaiDAO dtDao = new DienThoaiDAO();
            String sqlSelect = "SELECT maPhienBan, soluong FROM ChiTietPhieuNhap WHERE maPN = ?";
            PreparedStatement psSelect = ConnectedDatabase.getConnectedDB().prepareStatement(sqlSelect);
            psSelect.setString(1, maPN);
            ResultSet rs = psSelect.executeQuery();

            // Lưu thông tin vào danh sách tạm
            ArrayList<Integer> listMaPhienBan = new ArrayList<>();
            HashMap<Integer, Integer> mapSoLuongNhap = new HashMap<>();

            while (rs.next()) {
                int maPhienBan = rs.getInt("maPhienBan");
                int soLuong = rs.getInt("soLuong");

                // Kiểm tra xem phiên bản này đã từng được xuất chưa
                String sqlCheckXuat = "SELECT SUM(soLuong) AS daXuat FROM ChiTietPhieuXuat WHERE maPhienBan = ?";
                PreparedStatement psCheck = ConnectedDatabase.getConnectedDB().prepareStatement(sqlCheckXuat);
                psCheck.setInt(1, maPhienBan);
                ResultSet rsCheck = psCheck.executeQuery();

                if (rsCheck.next() && rsCheck.getInt("daXuat") > 0) {
                    JOptionPane.showMessageDialog(null,
                            "Không thể hủy phiếu nhập vì sản phẩm đã được xuất!",
                            "Lỗi",0);
                    return 0;
                }

                listMaPhienBan.add(maPhienBan);
                mapSoLuongNhap.put(maPhienBan, soLuong);
            }

            // Cập nhật tồn kho sau khi hủy phiếu nhập
            for (int maPhienBan : listMaPhienBan) {
                int soLuongNhap = mapSoLuongNhap.get(maPhienBan);
                int tonKhoHienTai = pbDao.getSoLuongTonCuaPhienBan(maPhienBan);
                int soLuongThucTeDeTru = Math.min(tonKhoHienTai, soLuongNhap);

                pbDao.updateSoLuongTonPhienBanSauKhiNhap(maPhienBan, -soLuongThucTeDeTru);
                dtDao.updateSoLuongTonDienThoaiSauKhiNhap(maPhienBan, -soLuongThucTeDeTru);
            }

            // Cập nhật trạng thái phiếu nhập
            String sqlUpdate = "UPDATE PhieuNhap SET trangthai = 0 WHERE maPN = ?";
            PreparedStatement psUpdate = ConnectedDatabase.getConnectedDB().prepareStatement(sqlUpdate);
            psUpdate.setString(1, maPN);
            if (psUpdate.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Hủy phiếu nhập và cập nhật tồn kho thành công!", "Thành công", 1);
                return 1;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    //Lấy danh sách phiếu nhập (ahuy)
    public ArrayList<PhieuNhapDTO> listPN() {
        ArrayList<PhieuNhapDTO> ListPN = new ArrayList<>();
        try {
            String sqlListPN = "SELECT * FROM PhieuNhap WHERE trangthai=1";
            PreparedStatement ps;
            ResultSet rs;
            Connection conn = ConnectedDatabase.getConnectedDB();
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlListPN);
            rs = ps.executeQuery();
            while (rs.next()) {
                String maPN = rs.getString("maPN");
                int maNV = rs.getInt("maNV");
                int maNCC = rs.getInt("maNCC");
                Date thoigian = rs.getDate("thoigian");
                long tongtien = rs.getLong("tongtien");
                ListPN.add(new PhieuNhapDTO(maPN, maNV, maNCC, thoigian, tongtien));
            }
            ConnectedDatabase.closeConnectedDB(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ListPN;
    }
    public ArrayList<PhieuNhapDTO> listPNFull() {
        ArrayList<PhieuNhapDTO> ListPN = new ArrayList<>();
        try {
            String sqlListPN = "SELECT * FROM PhieuNhap ";
            PreparedStatement ps;
            ResultSet rs;
            Connection conn = ConnectedDatabase.getConnectedDB();
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlListPN);
            rs = ps.executeQuery();
            while (rs.next()) {
                String maPN = rs.getString("maPN");
                int maNV = rs.getInt("maNV");
                int maNCC = rs.getInt("maNCC");
                Date thoigian = rs.getDate("thoigian");
                long tongtien = rs.getLong("tongtien");
                ListPN.add(new PhieuNhapDTO(maPN, maNV, maNCC, thoigian, tongtien));
            }
            ConnectedDatabase.closeConnectedDB(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ListPN;
    }
    //Lấy phiếu nhập by mã phiếu nhập (ahuy)
    public PhieuNhapDTO getPhieuNhapByMaPN(String maPN) {
        try {
            String sql = "SELECT * FROM PhieuNhap WHERE maPN = ? ";
            PreparedStatement ps;
            ResultSet rs;
            Connection conn =ConnectedDatabase.getConnectedDB();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maPN);
            rs = ps.executeQuery();
            if (rs.next()) {
                int maNV = rs.getInt("maNV");
                int maNCC = rs.getInt("maNCC");
                Date thoigian = rs.getDate("thoigian");
                long tongtien = rs.getLong("tongtien");
                return new PhieuNhapDTO(maPN, maNV, maNCC, thoigian, tongtien);
            }
            ConnectedDatabase.closeConnectedDB(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

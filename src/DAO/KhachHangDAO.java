/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.KhachHangDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import util.ConnectedDatabase;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class KhachHangDAO {
    public int insertKhachHang(KhachHangDTO kh) throws SQLException {
        String sql = "INSERT INTO KhachHang (maKh,tenKh,diaChikh,sdtKH,ngayThamGia)"
                + "VALUES (?,?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sql);
            ps.setString(1, kh.getID());
            ps.setString(2, kh.getName());
            ps.setString(3, kh.getAddress());
            ps.setString(4, kh.getSDT());
            ps.setDate(5, kh.getNgayThamGia());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Thêm Khách hàng thành công", "Success", 1);
            }
            return rows;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int updateKhachHang(KhachHangDTO kh) throws SQLException {
        String sqlUpdate = "UPDATE KhachHang "
                + "SET tenKh = ?, diachiKh = ?, sdtKh = ? "
                + "WHERE maKh = ?";
        try (Connection conn = ConnectedDatabase.getConnectedDB(); PreparedStatement ps = conn.prepareStatement(sqlUpdate)) {

            ps.setString(1, kh.getName());
            ps.setString(2, kh.getAddress());
            ps.setString(3, kh.getSDT());
            ps.setString(4, kh.getID());
            System.out.println("UPDATE với giá trị: " + kh.getName() + " | " + kh.getAddress() + " | " + kh.getSDT() + " | " + kh.getID());
            int rows = ps.executeUpdate();
            System.out.println("Số dòng bị ảnh hưởng: " + rows);

            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Chi tiết lỗi SQL: " + e.getMessage());
            throw e; // ném lại để lớp GUI xử lý
        }
    }

    public int deleteKhachHang(String maKh) {
        int confirm = JOptionPane.showConfirmDialog(
                null,
                "Bạn có chắc chắn muốn xóa khách hàng có mã: " + maKh + "?",
                "Xác nhận xóa",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm != JOptionPane.YES_OPTION) {
            return 0; // Hủy thao tác nếu chọn "Không"
        }

        String sqlDelete = "DELETE FROM KhachHang WHERE maKh=?";
        try {
            PreparedStatement ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlDelete);
            ps.setString(1, maKh);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Xóa thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
            }
            return rows;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Xảy ra lỗi khi xóa", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }

    public ArrayList<KhachHangDTO> listKh() {
        ArrayList<KhachHangDTO> listKh = new ArrayList<KhachHangDTO>();
        PreparedStatement ps;
        ResultSet rs;
        String sqlSelect = "SELECT * FROM KhachHang";
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlSelect);
            rs = ps.executeQuery();
            while (rs.next()) {
                String maKh = rs.getString("makh");
                String tenKh = rs.getString("tenKh");
                String diachiKh = rs.getString("diachiKh");
                String sdtKh = rs.getString("sdtKh");
                java.sql.Date ngayThamGia = rs.getDate("ngayThamGia");
                KhachHangDTO kh = new KhachHangDTO(maKh, tenKh, diachiKh, sdtKh, ngayThamGia);
                listKh.add(kh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listKh;
    }

    private static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ten_csdl";
        String user = "root";
        String password = "123456";
        return DriverManager.getConnection(url, user, password);
    }

    public static java.sql.Date getNgayThamGiaByID(String id) {
        java.sql.Date ngayThamGia = null;
        String query = "SELECT ngaythamgia FROM khachhang WHERE makh = ?";
        try (Connection conn = getConnection(); PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                ngayThamGia = rs.getDate("ngaythamgia");
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ngayThamGia;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.PhienBanDienThoaiDTO;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import util.ConnectedDatabase;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author kiman
 */
public class PhienBanDienThoaiDAO {

    public int insertPhienBan(PhienBanDienThoaiDTO pb) {
        String sqlAddPB = "INSERT INTO PhienBanDienThoai(maDT, maRam, maRom, maMau, giaNhap, giaXuat)"
                + " VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlAddPB);
            ps.setInt(1, pb.getMaDT());
            ps.setInt(2, pb.getmaRam());
            ps.setInt(3, pb.getmaRom());
            ps.setInt(4, pb.getmaMau());
            ps.setDouble(5, pb.getGiaNhap());
            ps.setDouble(6, pb.getGiaXuat());
            if (ps.executeUpdate() > 0) {
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
                listPB.add(new PhienBanDienThoaiDTO(maPhienBan, maDT, maRam, maRom, maMau, giaNhap, giaXuat));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPB;
    }

    //Lấy danh sách cấu hình
    public ArrayList<String> getArrayListCauHinhByMaDT(int maDT) {
        ArrayList<String> danhSachCauHinh = new ArrayList<>();
        String sql = "SELECT r.dungLuongRam AS ram, rom.dungLuongRom AS rom, m.tenMau "
                + "FROM PhienBanDienThoai pbdt "
                + "JOIN Ram r ON pbdt.maRam = r.maRam "
                + "JOIN Rom rom ON pbdt.maRom = rom.maRom "
                + "JOIN MauSac m ON pbdt.maMau = m.maMau "
                + "WHERE pbdt.maDT = ?";
        PreparedStatement ps;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sql);
            ps.setInt(1, maDT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String ram = rs.getString("ram");
                String rom = rs.getString("rom");
                String mauSac = rs.getString("tenMau");
                String cauHinh = ram + "GB-" + rom + "GB-" + mauSac;
                danhSachCauHinh.add(cauHinh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSachCauHinh;
    }

    //Lấy giá nhập điện thoại dựa trên maDT,maRam,maRom,maMau
    public double getGiaNhapByCauHinh(int maDT, int maRam, int maRom, int maMau) {
        double giaNhap = 0.0;
        String sql = "SELECT giaNhap FROM PhienBanDienThoai WHERE maDT = ? AND maRam = ? AND maRom = ? AND maMau = ?";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sql);
            ps.setInt(1, maDT);
            ps.setInt(2, maRam);
            ps.setInt(3, maRom);
            ps.setInt(4, maMau);
            rs = ps.executeQuery();
            if (rs.next()) {
                giaNhap = rs.getDouble("giaNhap");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return giaNhap;
    }

    //Lấy mã Phiên bản dựa trên mã điện thoại, mã ram,mã rom,mã màu
    public int getMaPhienBanByCauHinh(int maDT, int maRam, int maRom, int maMau) {
        int maPhienBan=-1;
        String sql = "SELECT maPhienBan FROM PhienBanDienThoai WHERE maDT = ? AND maRam = ? AND maRom = ? AND maMau = ?";
        PreparedStatement ps ;
        ResultSet rs ;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sql);
            ps.setInt(1, maDT);
            ps.setInt(2, maRam);
            ps.setInt(3, maRom);
            ps.setInt(4, maMau);
            rs = ps.executeQuery();
            if (rs.next()) {
                maPhienBan = rs.getInt("maPhienBan");
            }
        } catch (Exception e) {
            System.err.println("Lỗi truy vấn mã phiên bản: " + e.getMessage());
        }
        return maPhienBan;
    }
    //Lấy mã điện thoại dựa vào mã phiên bản điện thoại
    public int getMaDTByMaPhienBan(int maPhienBan){
        int maDT=-1;
        String sql="SELECT maDT FROM PhienBanDienThoai WHERE maPhienBan=? ";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps=ConnectedDatabase.getConnectedDB().prepareStatement(sql);
            ps.setInt(1,maPhienBan);
            rs=ps.executeQuery();
            if(rs.next()){
                maDT=rs.getInt("maDT");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maDT;
    }
    //Lấy mã rom theo mã phiên bản
    public int getMaRomByMaPhienBan(int maPhienBan) {
        int maRom = -1;
        String sql = "SELECT maRom FROM PhienBanDienThoai WHERE maPhienBan=? ";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sql);
            ps.setInt(1, maPhienBan);
            rs = ps.executeQuery();
            if (rs.next()) {
                maRom = rs.getInt("maRom");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maRom;
    }
    //Lấy mã ram theo mã Phiên bản
    public int getMaRamByMaPhienBan(int maPhienBan) {
        int maRam = -1;
        String sql = "SELECT maRam FROM PhienBanDienThoai WHERE maPhienBan=? ";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sql);
            ps.setInt(1, maPhienBan);
            rs = ps.executeQuery();
            if (rs.next()) {
                maRam = rs.getInt("maRam");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maRam;
    }
    //Lấy mã màu theo mã phiên bản
    public int getMaMauByMaPhienBan(int maPhienBan) {
        int maMau = -1;
        String sql = "SELECT maMau FROM PhienBanDienThoai WHERE maPhienBan=? ";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sql);
            ps.setInt(1, maPhienBan);
            rs = ps.executeQuery();
            if (rs.next()) {
                maMau = rs.getInt("maMau");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maMau;
    }
    //Cập nhật số lượng tồn của mỗi phiên bản điện thoại
    public int updateSoLuongTonPhienBan(int maPhienBan, int soLuongNhap) {
        String sql = "UPDATE PhienBanDienThoai SET soLuongTon = soLuongTon + ? WHERE maPhienBan = ?";
        PreparedStatement ps;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sql);
            ps.setInt(1, soLuongNhap);
            ps.setInt(2, maPhienBan);
            if (ps.executeUpdate() > 0) {
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}

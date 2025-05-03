/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.PhienBanDienThoaiDTO;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.Connection;
import util.ConnectedDatabase;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author kiman
 */
public class PhienBanDienThoaiDAO {
    //Thêm phiên bản (ahuy)
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
    //Cập nhật phiên bản (ahuy)
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
    //Xóa phiên bản (ahuy)
    public int deletePhienBan(int maPhienBan) {
        String sqlDeletePB = "DELETE FROM PhienBanDienThoai WHERE maPhienBan=? ";
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
    //Lấy danh sách phiên bản (ahuy)
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
                
                int soLuongTon = 0;
                listPB.add(new PhienBanDienThoaiDTO(maPhienBan,maDT, maRam, maRom,maMau, giaNhap, giaXuat,soLuongTon));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPB;
    }

    //Lấy danh sách cấu hình (ahuy)
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

    //Lấy giá nhập điện thoại dựa trên maDT,maRam,maRom,maMau (ahuy)
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

    // Lấy mã RAM từ dung lượng (ahuy)
    public int getMaRamTheoDungLuong(int dungLuong) {
        String sql = "SELECT maRam FROM ram WHERE dungLuongRam = ?";
        try (Connection conn = ConnectedDatabase.getConnectedDB();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, dungLuong);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getInt("maRam");
        } catch (Exception e) {
            e.printStackTrace();
        }
         System.out.println("⚠ Không tìm thấy RAM với dung lượng: " + dungLuong);
        return -1;
    }
    // Lấy mã ROM từ dung lượng (ahuy)
    public int getMaRomTheoDungLuong(int dungLuong) {
        String sql = "SELECT maRom FROM rom WHERE dungLuongRom = ?";
        try (Connection conn = ConnectedDatabase.getConnectedDB();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, dungLuong);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getInt("maRom");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    //Lấy mã rom theo mã phiên bản (ahuy)
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
    //Lấy mã ram theo mã Phiên bản (ahuy)
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
    //Lấy mã màu theo mã phiên bản (ahuy)
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
    //Cập nhật số lượng tồn của mỗi phiên bản điện thoại sau khi nhập (ahuy)
    public int updateSoLuongTonPhienBanSauKhiNhap(int maPhienBan, int soLuongNhap) {
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
    //Lấy mã Phiên bản dựa trên mã điện thoại, mã ram,mã rom,mã màu (ahuy)
    public int getMaPhienBanByCauHinh(int maDT, int maRam, int maRom, int maMau) {
        int maPhienBan = -1;
        String sql = "SELECT maPhienBan FROM PhienBanDienThoai WHERE maDT = ? AND maRam = ? AND maRom = ? AND maMau = ?";
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
                maPhienBan = rs.getInt("maPhienBan");
            }
        } catch (Exception e) {
            System.err.println("Lỗi truy vấn mã phiên bản: " + e.getMessage());
        }
        return maPhienBan;
    }
    //Lấy mã điện thoại dựa vào mã phiên bản điện thoại (ahuy)
    public int getMaDTByMaPhienBan(int maPhienBan) {
        int maDT = -1;
        String sql = "SELECT maDT FROM PhienBanDienThoai WHERE maPhienBan=? ";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sql);
            ps.setInt(1, maPhienBan);
            rs = ps.executeQuery();
            if (rs.next()) {
                maDT = rs.getInt("maDT");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maDT;
    }
    //Kiểm tra phiên bản đã được nhập hay chưa (ahuy)
    public boolean existsNhapByMaPhienBan(int maPhienBan) {
        String sql = "SELECT TOP 1 1 FROM ChiTietPhieuNhap WHERE maPhienBan = ? ";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps=ConnectedDatabase.getConnectedDB().prepareStatement(sql);
            ps.setInt(1, maPhienBan);
            rs = ps.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null,"Phiên bản đã được nhập hàng ","Error",0);
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
     //Kiểm tra phiên bản đã được xuất hay chưa (ahuy)
    public boolean existsXuatByMaPhienBan(int maPhienBan) {
        String sql = "SELECT TOP 1 1 FROM phieuxuat WHERE maPhienBan = ? ";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sql);
            ps.setInt(1, maPhienBan);
            rs = ps.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Phiên bản đã được xuất hàng ", "Error", 0);
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public PhienBanDienThoaiDTO getTheoCauHinh(int maDT, int maRam, int maRom, int maMau) {
        PhienBanDienThoaiDTO variant = null;
        String sql = "SELECT * FROM PhienBanDienThoai WHERE maDT = ? AND maRam = ? AND maRom = ? AND maMau = ?";
        try {
            PreparedStatement ps = ConnectedDatabase.getConnectedDB().prepareStatement(sql);
            ps.setInt(1, maDT);
            ps.setInt(2, maRam);
            ps.setInt(3, maRom);
            ps.setInt(4, maMau);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                variant = new PhienBanDienThoaiDTO(
                    rs.getInt("maPhienBan"),
                    rs.getInt("maDT"),
                    rs.getInt("maRam"),
                    rs.getInt("maRom"),
                    rs.getInt("maMau"),
                    rs.getDouble("giaNhap"),
                    rs.getDouble("giaXuat"),
                    rs.getInt("soLuongTon")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return variant;
    }
    public boolean updateSoLuongTonPhienBanSauXuat(int maPhienBan, int soLuongTru) {
        String sql = "UPDATE phienbandienthoai SET soLuongTon = soLuongTon - ? WHERE maPhienBan = ?";
        try (Connection conn = ConnectedDatabase.getConnectedDB();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, soLuongTru);
            ps.setInt(2, maPhienBan);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public int getMaPhienBanTheoChiTiet(String maSP, String maRam, String maRom, String mauSac) {
        int ma = -1;
        String sql = "SELECT maPhienBan FROM phienbandienthoai WHERE maDT = ? AND maRam = ? AND maRom = ? AND maMau = (SELECT maMau FROM mausac WHERE tenMau = ?)";
        try (Connection conn = ConnectedDatabase.getConnectedDB();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, Integer.parseInt(maSP));
            ps.setInt(2, Integer.parseInt(maRam));
            ps.setInt(3, Integer.parseInt(maRom));
            ps.setString(4, mauSac);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) ma = rs.getInt("maPhienBan");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ma;
    }
    public String[] layCauHinhBangPhienBan(int maPhienBan) {
        String[] cauHinh = new String[3]; // ROM - RAM - Màu
        String sql = "SELECT r.dungLuongRam AS ram, rom.dungLuongRom AS rom, m.tenMau " +
                     "FROM phienbandienthoai p " +
                     "JOIN ram r ON p.maRam = r.maRam " +
                     "JOIN rom rom ON p.maRom = rom.maRom " +
                     "JOIN mausac m ON p.maMau = m.maMau " +
                     "WHERE p.maPhienBan = ?";
        try (Connection conn = ConnectedDatabase.getConnectedDB();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, maPhienBan);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cauHinh[0] = rs.getString("rom");     // ROM
                cauHinh[1] = rs.getString("ram");     // RAM
                cauHinh[2] = rs.getString("tenMau");  // Màu sắc
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cauHinh;
    }
    public int getTongSoLuongTonCuaDienThoai(int maDT) {
        int tong = 0;
        try (Connection conn = ConnectedDatabase.getConnectedDB()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT SUM(soLuongTon) AS tong FROM PhienBanDienThoai WHERE maDT = ?"
            );
            stmt.setInt(1, maDT);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                tong = rs.getInt("tong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tong;
    }
    public int getSoLuongTonCuaPhienBan(int maPhienBan) {
        int soLuongTon = 0;
        String sql = "SELECT soLuongTon FROM PhienBanDienThoai WHERE maPhienBan = ?";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sql);
            ps.setInt(1, maPhienBan);
            rs = ps.executeQuery();
            if (rs.next()) {
                soLuongTon = rs.getInt("soLuongTon");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return soLuongTon;
    }
}

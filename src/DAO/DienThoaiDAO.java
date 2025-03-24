/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DienThoaiDTO;
import Data.ConnectedDatabase;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
public class DienThoaiDAO {
    public int insertDienThoai(DienThoaiDTO dt) {
        try {
            String sqlAdd = "INSERT INTO DienThoai(maDT,tenDT,maHDH,maThuongHieu,chipXuLy,dungLuongPin,kichThuocMan,hinhAnh,trangThai) "
                    + "VALUES (?,?,?,?,?,?,?,?,1)";
            PreparedStatement ps;
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlAdd);
            ps.setString(1, dt.getMaDT());
            ps.setString(2, dt.getTenDT());
            ps.setInt(3, dt.getHeDieuHanh());  // Đã đổi sang kiểu int
            ps.setInt(4, dt.getThuongHieu());  // Đã đổi sang kiểu int
            ps.setString(5, dt.getChipXuLy());
            ps.setInt(6, dt.getDungLuongPin());
            ps.setDouble(7, dt.getKichThuocMan());
            ps.setString(8, dt.getHinhAnh());  // Thêm hình ảnh
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Thêm điện thoại thành công", "Success", 1);
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
   public int updateDienThoai(DienThoaiDTO dt) {
    try {
        String sqlUpdate = "UPDATE DienThoai "
                + "SET tenDT=?, maHDH=?, maThuongHieu=?,chipXuLy=?,dungLuongPin=?,kichThuocMan=?,hinhAnh=? "
                + "WHERE maDT=?";
        PreparedStatement ps;
        ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlUpdate);
        ps.setString(1, dt.getTenDT());
        ps.setInt(2, dt.getHeDieuHanh());  // Đã đổi sang kiểu int
        ps.setInt(3, dt.getThuongHieu());  // Đã đổi sang kiểu int
        ps.setString(4, dt.getChipXuLy());
        ps.setInt(5, dt.getDungLuongPin());
        ps.setDouble(6, dt.getKichThuocMan());
        ps.setString(7, dt.getHinhAnh());  // Thêm hình ảnh
        ps.setString(9, dt.getMaDT());  // Điều kiện WHERE

        if (ps.executeUpdate() > 0) {
            JOptionPane.showMessageDialog(null, "Cập nhật thông tin điện thoại thành công", "Success", 1);
            return 1;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return 0;
}
    
    public int deleteDienThoai(String maDT) {
        try {
            String sqlDelete = "UPDATE DienThoai SET trangThai=0 "
                    + "WHERE maDT=?";
            PreparedStatement ps;
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlDelete);
            ps.setString(1, maDT);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Xóa điện thoại thành công", "Success", 1);
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public ArrayList<DienThoaiDTO> listDT() {
        ArrayList<DienThoaiDTO> listDT = new ArrayList<>();
        String sqlListDT = "SELECT * FROM DienThoai WHERE trangThai=1";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlListDT);
            rs = ps.executeQuery();
            while (rs.next()) {
                String maDT = rs.getString("maDT");
                String tenDT = rs.getString("tenDT");
                int heDieuHanh = rs.getInt("maHDH");
                int thuongHieu = rs.getInt("maThuongHieu");
                String chipXuLy = rs.getString("chipXuLy");
                int dungLuongPin = rs.getInt("dungLuongPin");
                double kichThuocMan = rs.getDouble("kichThuocMan");
                String hinhanh=rs.getString("hinhanh");
                int soluongton = rs.getInt("soLuongTon");
                listDT.add(new DienThoaiDTO(maDT, tenDT, heDieuHanh, thuongHieu, chipXuLy, dungLuongPin, kichThuocMan,hinhanh,soluongton));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDT;
    }
}

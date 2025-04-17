/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DienThoaiDTO;
import util.ConnectedDatabase;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;

public class DienThoaiDAO {

    public int insertDienThoai(DienThoaiDTO dt) {
        try {
            String sqlAdd = "INSERT INTO DienThoai(tenDT,maHDH,maThuongHieu,chipXuLy,dungLuongPin,kichThuocMan,hinhAnh,trangThai) "
                    + "VALUES (?,?,?,?,?,?,?,1)";
            PreparedStatement ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlAdd);
            ps.setString(1, dt.getTenDT());
            ps.setInt(2, dt.getHeDieuHanh());
            ps.setInt(3, dt.getThuongHieu());
            ps.setString(4, dt.getChipXuLy());
            ps.setInt(5, dt.getDungLuongPin());
            ps.setDouble(6, dt.getKichThuocMan());
            ps.setString(7, dt.getHinhAnh());
            if(ps.executeUpdate()>0)
                return 1;
            ps.close();
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
            ps.setInt(8, dt.getMaDT());  // Điều kiện WHERE
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Cập nhật thông tin điện thoại thành công", "Success", 1);
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int deleteDienThoai(int maDT) {
        try {
            String sqlDelete = "UPDATE DienThoai SET trangThai=0 "
                    + "WHERE maDT=?";
            PreparedStatement ps;
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlDelete);
            ps.setInt(1, maDT);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Xóa điện thoại thành công", "Success", 1);
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getID() {
        int id = -1;
        try {
            String sql = "SELECT MAX(maDT) FROM DienThoai";
            PreparedStatement ps = ConnectedDatabase.getConnectedDB().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
    public int updateSoLuongTonDienThoai(int maPhienBan, int soLuongNhap) {
        String sql = "UPDATE DienThoai SET soLuongTon = soLuongTon + ? "
                + "WHERE maDT = (SELECT maDT FROM PhienBanDienThoai WHERE maPhienBan = ?)";
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
    public ArrayList<DienThoaiDTO> listDT() {
        ArrayList<DienThoaiDTO> listDT = new ArrayList<>();
        String sqlListDT = "SELECT * FROM DienThoai WHERE trangThai=1";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlListDT);
            rs = ps.executeQuery();
            while (rs.next()) {
                int maDT = rs.getInt("maDT");
                String tenDT = rs.getString("tenDT");
                int heDieuHanh = rs.getInt("maHDH");
                int thuongHieu = rs.getInt("maThuongHieu");
                String chipXuLy = rs.getString("chipXuLy");
                int dungLuongPin = rs.getInt("dungLuongPin");
                double kichThuocMan = rs.getDouble("kichThuocMan");
                String hinhanh = rs.getString("hinhanh");
                int soLuongTon=rs.getInt("soLuongTon");
                listDT.add(new DienThoaiDTO(maDT, tenDT, heDieuHanh, thuongHieu, chipXuLy, dungLuongPin, kichThuocMan, hinhanh,soLuongTon));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDT;
    }
    public String getHinhAnh(int maDT){
        String hinhAnh=null;
        String sqlgetHinhAnh = "SELECT hinhAnh FROM DienThoai WHERE maDT=? ";
        PreparedStatement ps;
        ResultSet rs;
        try{
            ps=ConnectedDatabase.getConnectedDB().prepareStatement(sqlgetHinhAnh);
            ps.setInt(1, maDT);
            rs=ps.executeQuery();
            if(rs.next()){
                hinhAnh=rs.getString("hinhAnh");
            }
            rs.close();
            ps.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Không lấy được link hình ảnh","Error",0);
            e.printStackTrace();
        }
        return hinhAnh;
    }
}

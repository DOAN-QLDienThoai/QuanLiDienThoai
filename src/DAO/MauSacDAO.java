/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.MauSacDTO;
import util.ConnectedDatabase;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.HashMap;

public class MauSacDAO {
    //Thêm màu sắc (ahuy)
    public int insertMauSac(MauSacDTO ms){
        String sqlAddMS="INSERT INTO MauSac(tenMau,trangThai)"+
                         "VALUES (?,1)";
        PreparedStatement ps;
        try {
            ps=ConnectedDatabase.getConnectedDB().prepareStatement(sqlAddMS);
            ps.setString(1,ms.getTenMau());
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null,"Thêm màu sắc thành công","Success",1);
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    //Cập nhật màu sắc (ahuy)
    public int updateMS(MauSacDTO ms){
        String sqlUpdateMS="UPDATE MauSac SET tenMau=? WHERE maMau=? ";
        PreparedStatement ps;
        try {
            ps=ConnectedDatabase.getConnectedDB().prepareStatement(sqlUpdateMS);
            ps.setString(1,ms.getTenMau());
            ps.setInt(2,ms.getMaMau() );
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null,"Cập nhật màu sắc thành công","Success",1);
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    //Xóa màu sắc (ahuy)
    public int deleteMS(int maMau){
        String sqlDeleteMS="UPDATE MauSac SET trangThai=0 WHERE maMau=? ";
        PreparedStatement ps;
        try {
            ps=ConnectedDatabase.getConnectedDB().prepareStatement(sqlDeleteMS);
            ps.setInt(1,maMau);
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null,"Xóa màu sắc thành công","Success",1);
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    //Kiểm tra màu sắc đã được sử dụng ở phiên bản chưa (ahuy)
    public boolean isMauSacDangDuocSuDung(int maMau) {
        String sql = "SELECT COUNT(*) FROM PhienBanDienThoai WHERE maMau = ?";
        PreparedStatement ps;
        try {
            ps=ConnectedDatabase.getConnectedDB().prepareStatement(sql);
            ps.setInt(1, maMau);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    JOptionPane.showMessageDialog(null, "Màu sắc đã được phiên bản sử dụng", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    //Lấy danh sách màu sắc (ahuy)
    public ArrayList<MauSacDTO> listMS(){
        ArrayList<MauSacDTO> listMS=new ArrayList<MauSacDTO>();
        String sqlAllMS="SELECT * FROM MauSac WHERE trangThai=1 ";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps=ConnectedDatabase.getConnectedDB().prepareStatement(sqlAllMS);
            rs=ps.executeQuery();
            while(rs.next()){
                int maMau=rs.getInt("maMau");
                String tenMau=rs.getString("tenMau");
                listMS.add(new MauSacDTO(maMau,tenMau));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMS;
    }
    public HashMap<String,Integer> listMapMS() {
        HashMap<String, Integer> mapMS = new HashMap<>();
        String sql = "SELECT * FROM MauSac WHERE trangThai=1";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int maMau = rs.getInt("maMau");
                String tenMau = rs.getString("tenMau");
                mapMS.put(tenMau,maMau);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapMS;
    }
    public int getMaMauByTen(String tenMau) {
            int maMau = -1;
         String sql = "SELECT maMau FROM MauSac WHERE tenMau = ?";
            try {
                PreparedStatement ps = ConnectedDatabase.getConnectedDB().prepareStatement(sql);
                ps.setString(1, tenMau);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    maMau = rs.getInt("maMau");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return maMau;
    }
}

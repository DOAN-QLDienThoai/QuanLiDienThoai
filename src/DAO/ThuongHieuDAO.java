/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ThuongHieuDTO;
import Data.ConnectedDatabase;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.HashMap;

public class ThuongHieuDAO {
    public int insertThuongHieu(ThuongHieuDTO th){
        String sqlAddThuongHieu="INSERT INTO ThuongHieu(tenThuongHieu,trangThai)"+
                         "VALUES (?,1)";
        PreparedStatement ps;
        try {
            ps=ConnectedDatabase.getConnectedDB().prepareStatement(sqlAddThuongHieu);
            ps.setString(1,th.getTenThuongHieu());
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null,"Thêm thương hiệu thành công","Success",1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int updateThuongHieu(ThuongHieuDTO th){
        String sqlUpdateThuongHieu="UPDATE ThuongHieu SET tenThuongHieu=? WHERE maThuongHieu=? ";
        PreparedStatement ps;
        try {
            ps=ConnectedDatabase.getConnectedDB().prepareStatement(sqlUpdateThuongHieu);
            ps.setString(1,th.getTenThuongHieu());
            ps.setInt(2,th.getMaThuongHieu());
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null,"Cập nhật thương hiệu thành công","Success",1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int deleteThuongHieu(int maThuongHieu){
        String sqlDeleteRam="UPDATE ThuongHieu SET trangThai=0 WHERE maThuongHieu=? ";
        PreparedStatement ps;
        try {
            ps=ConnectedDatabase.getConnectedDB().prepareStatement(sqlDeleteRam);
            ps.setInt(1,maThuongHieu);
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null,"Xóa thương hiệu thành công","Success",1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public ArrayList<ThuongHieuDTO> listThuongHieu(){
        ArrayList<ThuongHieuDTO> listThuongHieu=new ArrayList<ThuongHieuDTO>();
        String sqlAllThuongHieu="SELECT * FROM ThuongHieu WHERE trangThai=1 ";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps=ConnectedDatabase.getConnectedDB().prepareStatement(sqlAllThuongHieu);
            rs=ps.executeQuery();
            while(rs.next()){
                int maThuongHieu=rs.getInt("maThuongHieu");
                String tenThuongHieu=rs.getString("tenThuongHieu");
                listThuongHieu.add(new ThuongHieuDTO(maThuongHieu,tenThuongHieu));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listThuongHieu;
    }
    
    public HashMap<String,Integer> listMapThuongHieu() {
        HashMap<String, Integer> mapThuongHieu = new HashMap<>();
        String sql = "SELECT * FROM ThuongHieu WHERE trangThai=1";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int maThuongHieu = rs.getInt("maThuongHieu");
                String tenThuongHieu = rs.getString("tenThuongHieu");
                mapThuongHieu.put(tenThuongHieu,maThuongHieu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapThuongHieu;
    }
}

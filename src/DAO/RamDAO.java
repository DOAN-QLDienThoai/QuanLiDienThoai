/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.RamDTO;
import util.ConnectedDatabase;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.HashMap;

public class RamDAO {
    //Thêm ram (ahuy)
    public int insertRam(RamDTO ram){
        String sqlAddRam="INSERT INTO Ram(dungLuongRam,trangThai)"+
                         "VALUES (?,1)";
        PreparedStatement ps;
        try {
            ps=ConnectedDatabase.getConnectedDB().prepareStatement(sqlAddRam);
            ps.setInt(1,ram.getDungLuongRam());
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null,"Thêm ram thành công","Success",1);
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    //Update ram (ahuy)
    public int updateRam(RamDTO ram){
        String sqlUpdateRam="UPDATE Ram SET dungLuongRam=? WHERE maRam=? ";
        PreparedStatement ps;
        try {
            ps=ConnectedDatabase.getConnectedDB().prepareStatement(sqlUpdateRam);
            ps.setInt(1,ram.getDungLuongRam());
            ps.setInt(2,ram.getMaRam());
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null,"Cập nhật ram thành công","Success",1);
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    //Xóa ram (ahuy)
    public int deleteRam(int maRam){
        String sqlDeleteRam="UPDATE Ram SET trangThai=0 WHERE maRam=? ";
        PreparedStatement ps;
        try {
            ps=ConnectedDatabase.getConnectedDB().prepareStatement(sqlDeleteRam);
            ps.setInt(1,maRam);
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null,"Xóa Ram thành công","Success",1);
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    //Kiểm tra ram đã đc phiên bản nào sử dụng hay chưa (ahuy)
    public boolean isRamDangDuocSuDung(int maRam) {
        String sql = "SELECT COUNT(*) FROM PhienBanDienThoai WHERE maRam = ?";
        PreparedStatement ps;
        try {
            ps=ConnectedDatabase.getConnectedDB().prepareStatement(sql);
            ps.setInt(1, maRam);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    JOptionPane.showMessageDialog(null, "Ram đã được phiên bản sử dụng", "Error", 0);
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    //Lấy danh sách Ram (ahuy)
    public ArrayList<RamDTO> listRam(){
        ArrayList<RamDTO> listRam=new ArrayList<RamDTO>();
        String sqlAllRam="SELECT * FROM Ram WHERE trangThai=1 ";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps=ConnectedDatabase.getConnectedDB().prepareStatement(sqlAllRam);
            rs=ps.executeQuery();
            while(rs.next()){
                int maRam=rs.getInt("maRam");
                int dungLuongRam=rs.getInt("dungLuongRam");
                listRam.add(new RamDTO(maRam,dungLuongRam));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listRam;
    }
    public HashMap<Integer,Integer> listMapRam() {
        HashMap<Integer, Integer> mapRam = new HashMap<>();
        String sql = "SELECT * FROM Ram where trangThai=1";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int maRam = rs.getInt("maRam");
                int dungLuongRam = rs.getInt("dungLuongRam");
                mapRam.put(dungLuongRam,maRam);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapRam;
    }
}

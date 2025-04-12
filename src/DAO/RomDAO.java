/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.RomDTO;
import util.ConnectedDatabase;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.HashMap;

public class RomDAO {
    public int insertRom(RomDTO rom){
        String sqlAddRom="INSERT INTO Rom(dungLuongRom,trangThai)"+
                         "VALUES (?,1)";
        PreparedStatement ps;
        try {
            ps=ConnectedDatabase.getConnectedDB().prepareStatement(sqlAddRom);
            ps.setInt(1,rom.getDungLuongRom());
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null,"Thêm rom thành công","Success",1);
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int updateRom(RomDTO rom){
        String sqlUpdateRom="UPDATE Rom SET dungLuongRom=? WHERE maRom=? ";
        PreparedStatement ps;
        try {
            ps=ConnectedDatabase.getConnectedDB().prepareStatement(sqlUpdateRom);
            ps.setInt(1,rom.getDungLuongRom());
            ps.setInt(2,rom.getMaRom());
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null,"Cập nhật rom thành công","Success",1);
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int deleteRom(int maRom){
        String sqlDeleteRam="UPDATE Rom SET trangThai=0 WHERE maRom=? ";
        PreparedStatement ps;
        try {
            ps=ConnectedDatabase.getConnectedDB().prepareStatement(sqlDeleteRam);
            ps.setInt(1,maRom);
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null,"Xóa Rom thành công","Success",1);
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public ArrayList<RomDTO> listRom(){
        ArrayList<RomDTO> listRom=new ArrayList<RomDTO>();
        String sqlAllRom="SELECT * FROM Rom WHERE trangThai=1 ";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps=ConnectedDatabase.getConnectedDB().prepareStatement(sqlAllRom);
            rs=ps.executeQuery();
            while(rs.next()){
                int maRom=rs.getInt("maRom");
                int dungLuongRom=rs.getInt("dungLuongRom");
                listRom.add(new RomDTO(maRom,dungLuongRom));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listRom;
    }
    
    public HashMap<Integer,Integer> listMapRom() {
        HashMap<Integer, Integer> mapRom = new HashMap<>();
        String sql = "SELECT * FROM Rom WHERE trangThai=1";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int maRom = rs.getInt("maRom");
                int dungLuongRom = rs.getInt("dungLuongRom");
                mapRom.put(dungLuongRom,maRom);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapRom;
    }
}

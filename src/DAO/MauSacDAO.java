/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.MauSacDTO;
import Data.ConnectedDatabase;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class MauSacDAO {
    public int insertMauSac(MauSacDTO ms){
        String sqlAddMS="INSERT INTO MauSac(maMau,tenMau,trangThai)"+
                         "VALUES (?,?,1)";
        PreparedStatement ps;
        try {
            ps=ConnectedDatabase.getConnectedDB().prepareStatement(sqlAddMS);
            ps.setString(1,ms.getMaMau());
            ps.setString(2,ms.getTenMau());
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null,"Thêm màu sắc thành công","Success",1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int updateMS(MauSacDTO ms){
        String sqlUpdateMS="UPDATE MauSac SET tenMau=? WHERE maMau=? ";
        PreparedStatement ps;
        try {
            ps=ConnectedDatabase.getConnectedDB().prepareStatement(sqlUpdateMS);
            ps.setString(1,ms.getTenMau());
            ps.setString(2,ms.getMaMau() );
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null,"Cập nhật màu sắc thành công","Success",1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int deleteMS(String maMau){
        String sqlDeleteMS="UPDATE MauSac SET trangThai=0 WHERE maMau=? ";
        PreparedStatement ps;
        try {
            ps=ConnectedDatabase.getConnectedDB().prepareStatement(sqlDeleteMS);
            ps.setString(1,maMau);
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null,"Xóa màu sắc thành công","Success",1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public ArrayList<MauSacDTO> listMS(){
        ArrayList<MauSacDTO> listMS=new ArrayList<MauSacDTO>();
        String sqlAllMS="SELECT * FROM MauSac WHERE trangThai=1 ";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps=ConnectedDatabase.getConnectedDB().prepareStatement(sqlAllMS);
            rs=ps.executeQuery();
            while(rs.next()){
                String maMau=rs.getString("maMau");
                String tenMau=rs.getString("tenMau");
                listMS.add(new MauSacDTO(maMau,tenMau));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMS;
    }
}

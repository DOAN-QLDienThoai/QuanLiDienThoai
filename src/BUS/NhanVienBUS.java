/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.util.ArrayList;

/**
 *
 * @author kiman
 */
public class NhanVienBUS {
    private NhanVienDAO NhanVienDAO;
    public NhanVienBUS(){
        NhanVienDAO=new NhanVienDAO();
    }
    public int insertNhanVien(NhanVienDTO nv){
        return NhanVienDAO.insertNhanVien(nv);
    }
    public int updateNhanVien(NhanVienDTO nv){
        return NhanVienDAO.updateNhanVien(nv);
    }
    public int deleteNhanVien(int maNV){
        return NhanVienDAO.deleteNhanVien(maNV);
    }
    public ArrayList<NhanVienDTO> listNV(){
        return NhanVienDAO.listNV();
    }
    public ArrayList<NhanVienDTO> timKiem(String text,String type){
        ArrayList<NhanVienDTO> listNV=NhanVienDAO.listNV();
        ArrayList<NhanVienDTO> listNVFilter=new ArrayList<>();
        String text_find=text.toLowerCase();
        for(NhanVienDTO nv : listNV){
            String maNV=String.valueOf(nv.getMaNV()).toLowerCase();
            String ngaySinh=String.valueOf(nv.getNgaySinh()).toLowerCase();
            switch (type){
                case "Tất cả":
                    if(nv.getHoTen().toLowerCase().contains(text_find)||nv.getSDT().toLowerCase().contains(text_find)
                       ||maNV.contains(text_find)||ngaySinh.contains(text_find)||nv.getGioiTinh().toLowerCase().contains(text_find)){
                        listNVFilter.add(nv);
                    }
                    break;
                case "Tên nhân viên":
                    if(nv.getHoTen().toLowerCase().contains(text_find))
                        listNVFilter.add(nv);
                    break;
                case "Số điện thoại":
                    if(nv.getSDT().toLowerCase().contains(text_find))
                        listNVFilter.add(nv);
                    break;
                case "Giới tính":
                    if(nv.getGioiTinh().toLowerCase().contains(text_find))
                        listNVFilter.add(nv);
                    break;
                case "Ngày sinh":
                    if(ngaySinh.contains(text_find))
                        listNVFilter.add(nv);
                    break;
            }
        }
        return listNVFilter;
    }
}

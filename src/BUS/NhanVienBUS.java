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
    private NhanVienDAO nvDao=new NhanVienDAO();
    private ArrayList<NhanVienDTO> listNV=new ArrayList<>();
    public NhanVienBUS(){
        this.listNV=nvDao.listNV();
    }
    public int insertNhanVien(NhanVienDTO nv){
        int check=nvDao.insertNhanVien(nv);
        if(check==1){
            listNV=nvDao.listNV();
        }
        return check;
    }
    public int updateNhanVien(NhanVienDTO nv){
        int check=nvDao.updateNhanVien(nv);
        if(check==1){
            listNV=nvDao.listNV();
        }
        return check;
    }
    public int deleteNhanVien(int maNV){
        int check=nvDao.deleteNhanVien(maNV);
        if(check==1){
            listNV=nvDao.listNV();
        }
        return check;
    }
    public int getIndexByID(int maNV){
        int i=0;
        int vitri=-1;
        while(i<listNV.size()&&vitri==-1){
            if(listNV.get(i).getMaNV()==maNV){
                vitri=i;
            }else{
                i++;
            }
        }
        return vitri;
    }
    public String getTenNVByID(int maNV){
        return listNV.get(getIndexByID(maNV)).getHoTen();
    }
    public ArrayList<NhanVienDTO> listNV(){
        return listNV;
    }
    public ArrayList<NhanVienDTO> timKiem(String text,String type){
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

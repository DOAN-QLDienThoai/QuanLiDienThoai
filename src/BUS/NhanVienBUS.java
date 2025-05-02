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
    public int deleteCheckNhanVien(int maNV) {
        int check = nvDao.deleteCheckNhanVien(maNV);
        if (check == 1) {
            listNV = nvDao.listNV();
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
    public String getTenNVByID(int maNV) {
        listNV = nvDao.listNV();
        int index = getIndexByID(maNV);
        if (index == -1) {
            return null;
        }
        return listNV.get(index).getHoTen();
    }
    public int getIDByTenNV(String tenNV) {
        listNV = nvDao.listNV();
        for (NhanVienDTO nv : listNV) {
            if (nv.getHoTen().equalsIgnoreCase(tenNV)) {
                return nv.getMaNV(); // trả về ID đầu tiên
            }
        }
        return -1; // không tìm thấy
    }
    public ArrayList<NhanVienDTO> listNV(){
        listNV=nvDao.listNV();
        return listNV;
    }
    public ArrayList<NhanVienDTO> timKiem(String text,String type){
        listNV=nvDao.listNV();
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

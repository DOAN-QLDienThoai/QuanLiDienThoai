/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.PhieuNhapDAO;
import DTO.PhieuNhapDTO;
import java.util.ArrayList;

/**
 *
 * @author kiman
 */
public class PhieuNhapBUS {
    private PhieuNhapDAO pnDao=new PhieuNhapDAO();
    private ArrayList<PhieuNhapDTO> listPN=new ArrayList<>();
    private NhaCungCapBUS nccBus=new NhaCungCapBUS();
    private NhanVienBUS nvBus=new NhanVienBUS();
    public PhieuNhapBUS(){
    }
     public ArrayList<PhieuNhapDTO> listPN(){
        this.listPN=pnDao.listPN();
        return listPN;
    }
    public int insertPhieuNhap(PhieuNhapDTO pn){
        int check=pnDao.insertPhieuNhapDienThoai(pn);
        if(check==1){
            listPN=pnDao.listPN();
        }
        return check;
    }
    public int updatePhieuNhap(PhieuNhapDTO pn){
        int check=pnDao.updatePhieuNhap(pn);
        if(check==1){
            listPN=pnDao.listPN();
        }
        return check;
    }
    public int deletePhieuNhap(String maPN){
        int check=pnDao.deletePhieuNhap(maPN);
        if(check==1){
            listPN=pnDao.listPN();
        }
        return check;
    }
    public int getIndexByID(String maPN){
        int i=0;
        int vitri=-1;
        while(i<listPN.size()&&vitri==-1){
            if(listPN.get(i).getMaPhieuNhap().equals(maPN)){
                vitri=i;
            }else{
                i++;
            }
        }
        return vitri;
    }
    public PhieuNhapDTO getPhieuNhapByID(String maPN){
        return pnDao.getPhieuNhapByMaPN(maPN);
    }
    public ArrayList<PhieuNhapDTO> listPNFull(){
        return pnDao.listPNFull();
    }
    public ArrayList<PhieuNhapDTO> timKiem(String text,String type){
        ArrayList<PhieuNhapDTO> listPNFilter=new ArrayList<>();
        String text_find=text.toLowerCase();
        for(PhieuNhapDTO pn : listPN){
            String maPN=pn.getMaPhieuNhap().toLowerCase();
            String ngayNhap=String.valueOf(pn.getNgayNhap()).toLowerCase();
            String tongTien=String.valueOf(pn.getTongTien()).toLowerCase();
            String tenNCC=nccBus.getTenNCCByID(pn.getNhaCungCap()).toLowerCase();
            String tenNV=nvBus.getTenNVByID(pn.getNhanVien()).toLowerCase();
            switch (type){
                case "Tất cả":
                    if(maPN.contains(text_find)||ngayNhap.contains(text_find)
                       ||tenNCC.contains(text_find)||tenNV.contains(text_find)||tongTien.contains(text_find)){
                        listPNFilter.add(pn);
                    }
                    break;
                case "Tên nhà cung cấp":
                    if(tenNCC.contains(text_find))
                        listPNFilter.add(pn);
                    break;
                case "Tên nhân viên":
                    if(tenNV.contains(text_find))
                        listPNFilter.add(pn);
                    break;
                case "Tổng tiền":
                    if(tongTien.contains(text_find))
                        listPNFilter.add(pn);
                    break;
                case "Mã phiếu nhập":
                    if(maPN.contains(text_find))
                        listPNFilter.add(pn);
                    break;
                case "Ngày nhập":
                    if(ngayNhap.contains(text_find))
                        listPNFilter.add(pn);
                    break;
            }
        }
        return listPNFilter;
    }
}

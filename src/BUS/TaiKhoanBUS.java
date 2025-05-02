/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.TaiKhoanDAO;
import DTO.TaiKhoanDTO;
import java.util.ArrayList;

/**
 *
 * @author kiman
 */
public class TaiKhoanBUS {

    private TaiKhoanDAO tkDao = new TaiKhoanDAO();
    private ArrayList<TaiKhoanDTO> listTaiKhoan = new ArrayList<>();

    public TaiKhoanBUS() {
        this.listTaiKhoan = tkDao.listTaiKhoanFull();
    }
    public ArrayList<TaiKhoanDTO> listTaiKhoan() {
        listTaiKhoan=tkDao.listTaiKhoanFull();
        return listTaiKhoan;
    }
    public int insertTaiKhoan(TaiKhoanDTO tk) {
        int check = tkDao.insertTaiKhoan(tk);
        if (check == 1) {
            listTaiKhoan = tkDao.listTaiKhoanFull();
        }
        return check;
    }

    public int updateTaiKhoan(TaiKhoanDTO tk) {
        int check = tkDao.updateTaiKhoan(tk);
        if (check == 1) {
            listTaiKhoan = tkDao.listTaiKhoanFull();
        }
        return check;
    }

    public int deleteTaiKhoan(int maNV) {
        int check = tkDao.deleteTaiKhoan(maNV);
        if (check == 1) {
            listTaiKhoan = tkDao.listTaiKhoan();
        }
        return check;
    }

    public int updatePass(int maNV, String newPass) {
        int check = tkDao.updatePass(maNV, newPass);
        if (check == 1) {
            listTaiKhoan = tkDao.listTaiKhoanFull();
        }
        return check;
    }

    public int getIndexByMaNV(int maNV) {
        int i = 0;
        int vitri = -1;
        while (i < listTaiKhoan.size() && vitri == -1) {
            if (listTaiKhoan.get(i).getMaNV() == maNV) {
                vitri = i;
            } else {
                i++;
            }
        }
        return vitri;
    }

    public String getTenDangNhapByMaNV(int maNV) {
        listTaiKhoan = tkDao.listTaiKhoanFull();
        int index = getIndexByMaNV(maNV);
        if (index == -1) {
            return null;
        }
        return listTaiKhoan.get(index).getTenDangNhap();
    }
    public ArrayList<TaiKhoanDTO> timKiem(String textfind, String type) {
        String trangThaiHD = null;
        String text = textfind.toLowerCase();
        listTaiKhoan = tkDao.listTaiKhoanFull();
        ArrayList<TaiKhoanDTO> listTKTemp = new ArrayList<>();
        for (TaiKhoanDTO u : listTaiKhoan) {
            if (type.equals("Tất cả")) {
                String maNV = String.valueOf(u.getMaNV()).toLowerCase();
                if (u.getTrangThai().equals("1")) {
                    trangThaiHD = "Hoạt động".toLowerCase();
                }
                if (u.getTrangThai().equals("0")) {
                    trangThaiHD = "Ngưng hoạt động".toLowerCase();
                }
                if (maNV.contains(text) || u.getTenDangNhap().toLowerCase().contains(text) || trangThaiHD.contains(text)) {
                    listTKTemp.add(u);
                }
            } else if (type.equals("Mã NV")) {
                String maNV = String.valueOf(u.getMaNV()).toLowerCase();
                if (maNV.equals(text)) {
                    listTKTemp.add(u);
                }
            } else if (type.equals("Tên tài khoản")) {
                if (u.getTenDangNhap().toLowerCase().contains(text)) {
                    listTKTemp.add(u);
                }
            }
            else{
                if (u.getTrangThai().equals("1")) {
                    trangThaiHD = "Hoạt động".toLowerCase();
                }
                if (u.getTrangThai().equals("0")) {
                    trangThaiHD = "Ngưng hoạt động".toLowerCase();
                }
                if(trangThaiHD.contains(text)){
                    listTKTemp.add(u);
                }
            }
        }
        return listTKTemp;
    }
        
    public TaiKhoanDTO getUserByMaNV(int maNV){
        return tkDao.getUserByMaNV(maNV);
    }
}

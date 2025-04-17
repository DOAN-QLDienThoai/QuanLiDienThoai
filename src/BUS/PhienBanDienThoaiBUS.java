/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.PhienBanDienThoaiDAO;
import DTO.PhienBanDienThoaiDTO;
import java.util.ArrayList;

/**
 *
 * @author kiman
 */
public class PhienBanDienThoaiBUS {
    private PhienBanDienThoaiDAO pbDao=new PhienBanDienThoaiDAO();
    private ArrayList<PhienBanDienThoaiDTO> listPB=new ArrayList<>();
    public PhienBanDienThoaiBUS(){
        this.listPB=pbDao.listPhienBan();
    }
    public ArrayList<PhienBanDienThoaiDTO> listPB(){
        return listPB;
    }
    public int insertPhienBanDienThoai(PhienBanDienThoaiDTO pb){
        int check=pbDao.insertPhienBan(pb);
        if(check==1){
            listPB=pbDao.listPhienBan();
        }
        return check;
    }
    public int updatePhienBanDienThoai(PhienBanDienThoaiDTO pb){
        int check=pbDao.updatePhienBan(pb);
        if(check==1){
            listPB=pbDao.listPhienBan();
        }
        return check;
    }
    public int deletePhienBanDienThoai(int maPB) {
        int check = pbDao.deletePhienBan(maPB);
        if (check == 1) {
            listPB = pbDao.listPhienBan();
        }
        return check;
    }

    public ArrayList<String> getCauHinhByMaDT(int maDT) {
        return pbDao.getArrayListCauHinhByMaDT(maDT);
    }
    public int updateSoLuongTon(int maPB,int soLuong){
        int check=pbDao.updateSoLuongTonPhienBan(maPB, soLuong);
        if(check==1){
            listPB=pbDao.listPhienBan();
        }
        return check;
    }
    public boolean checkDupAdd(ArrayList<PhienBanDienThoaiDTO> listPBTemp, PhienBanDienThoaiDTO pb) {
        for (PhienBanDienThoaiDTO item : listPBTemp) {
            if (item.isSameConFig(pb)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkDupEdit(ArrayList<PhienBanDienThoaiDTO> listPBTemp, PhienBanDienThoaiDTO pb) {
        for (PhienBanDienThoaiDTO item : listPBTemp) {
            if (item.isSameFullConFig(pb)) {
                return false;
            }
        }
        return true;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.MauSacDAO;
import DTO.MauSacDTO;
import java.util.ArrayList;

/**
 *
 * @author kiman
 */
public class MauSacBUS {
    private MauSacDAO msDao=new MauSacDAO();
    private ArrayList<MauSacDTO> listMS=new ArrayList<>();
    public MauSacBUS(){
        this.listMS=msDao.listMS();
    }
    public ArrayList<MauSacDTO> listMS(){
        listMS=msDao.listMS();
        return this.listMS;
    }
    public int insertMauSac(String tenMau){
        int check=msDao.insertMauSac(new MauSacDTO(tenMau));
        if(check==1){
            listMS=msDao.listMS();
        }
        return check;
    }
    public int updateMauSac(MauSacDTO ms){
        int check=msDao.updateMS(ms);
        if(check==1){
            listMS=msDao.listMS();
        }
        return check;
    }
    public int deleteMauSac(int maMau){
        int check=msDao.deleteMS(maMau);
        if(check==1){
            listMS=msDao.listMS();
        }
        return check;
    }
    public int getIndexByID(int maMS) {
        ArrayList<MauSacDTO> arrlistMS=msDao.arrlistMS();
        int vitri = -1;
        int i = 0;
        while (vitri == -1 && arrlistMS.size() > i) {
            if (arrlistMS.get(i).getMaMau() == maMS) {
                vitri = i;
            } else {
                i++;
            }
        }
        return vitri;
    }

    public int getIDByTenMau(String tenMau) {
        ArrayList<MauSacDTO> arrlistMS=msDao.arrlistMS();
        for (MauSacDTO ms : arrlistMS) {
            if (ms.getTenMau().equals(tenMau)) {
                return ms.getMaMau();
            }
        }
        return -1;
    }

    public String getTenMauByID(int maMS) {
        ArrayList<MauSacDTO> arrlistMS=msDao.arrlistMS();
        int index = getIndexByID(maMS);
        if (index == -1) {
            return null;
        }
        return arrlistMS.get(index).getTenMau();
    }
    public boolean checkDup(String tenMau){
        boolean check=true;
        int i=0;
        while(i<listMS.size()&&check){
            if(listMS.get(i).getTenMau().toLowerCase().equals(tenMau.toLowerCase())){
                check=false;
            }else{
                i++;
            }
        }
        return check;
    }
    public ArrayList<MauSacDTO> timKiem(String text_find) {
        ArrayList<MauSacDTO> listMSTemp = new ArrayList<>();
        String text = text_find.toLowerCase();
        listMS = msDao.listMS();
        for (MauSacDTO ms : listMS) {
            String maMau = String.valueOf(ms.getMaMau()).toLowerCase();
            String tenMau = ms.getTenMau().toLowerCase();
            if (maMau.contains(text) || tenMau.contains(text)) {
                listMSTemp.add(ms);
            }
        }
        return listMSTemp;
    }
}

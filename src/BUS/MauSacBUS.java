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
        return this.listMS;
    }
    public int getIndexByID(int maMS){
        int vitri=-1;
        int i=0;
        while(vitri==-1&&listMS.size()>i){
            if(listMS.get(i).getMaMau()==maMS){
                vitri=i;
            }
            else{
                i++;
            }
        }
        return vitri;
    }
    public int getIDByTenMau(String tenMau){
        for(MauSacDTO ms : listMS){
            if(ms.getTenMau().equals(tenMau))
                return ms.getMaMau();
        }
        return -1;
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
    public String getTenMauByID(int maMS){
        return listMS.get(getIndexByID(maMS)).getTenMau();
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
}

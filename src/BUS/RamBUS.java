/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.RamDAO;
import DTO.RamDTO;
import java.util.ArrayList;

/**
 *
 * @author kiman
 */
public class RamBUS {
    private RamDAO ramDao=new RamDAO();
    private ArrayList<RamDTO> listRAM=new ArrayList<>();
    public RamBUS(){
        listRAM=ramDao.listRam();
    }
    public ArrayList<RamDTO> listRAM(){
        return listRAM;
    }
    public int getIndexByID(int maRam){
        int i=0;
        int vitri=-1;
        while(vitri==-1&&i<listRAM.size()){
            if(listRAM.get(i).getMaRam()==maRam)
                vitri=i;
            else
                i++;
        }
        return vitri;
    }
    public int insertRam(int dungLuongRam){
        int check=ramDao.insertRam(new RamDTO(dungLuongRam));
        if(check==1)
            listRAM=ramDao.listRam();
        return check;
    }
    public int updateRam(RamDTO ram){
        int check=ramDao.updateRam(ram);
        if(check==1)
            listRAM=ramDao.listRam();
        return check;
    }
    public int deleteRam(int maRam){
        int check=ramDao.deleteRam(maRam);
        if(check==1)
            listRAM=ramDao.listRam();
        return check;
    }
    public int getDungLuongRambyID(int maRam){
        return listRAM.get(getIndexByID(maRam)).getDungLuongRam();
    }
    public boolean checkDup(int dungLuongRam){
        boolean check=true;
        int i=0;
        while(i<listRAM.size()&&check){
            if(listRAM.get(i).getDungLuongRam()==dungLuongRam)
                check=false;
            else
                i++;
        }
        return check;
    }
}

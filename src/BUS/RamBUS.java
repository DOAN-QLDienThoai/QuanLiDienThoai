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
        listRAM=ramDao.listRam();
        return listRAM;
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
    public int getIndexByID(int maRam){
        ArrayList<RamDTO> arrlistRam=ramDao.arrlistRam();
        int i=0;
        int vitri=-1;
        while(vitri==-1&&i<arrlistRam.size()){
            if(arrlistRam.get(i).getMaRam()==maRam)
                vitri=i;
            else
                i++;
        }
        return vitri;
    }
    public int getIDByDungLuongRam(int dungLuongRam){
         ArrayList<RamDTO> arrlistRam=ramDao.arrlistRam();
        for(RamDTO ram: arrlistRam){
            if(ram.getDungLuongRam()==dungLuongRam){
                return ram.getMaRam();
            }
        }
        return -1;
    }
    public int getDungLuongRambyID(int maRam){
        ArrayList<RamDTO> arrlistRam=ramDao.arrlistRam();
        int index = getIndexByID(maRam);
        if (index == -1) {
            return -1;
        }
        return arrlistRam.get(index).getDungLuongRam();
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
    public ArrayList<RamDTO> timKiem(String text_find) {
        ArrayList<RamDTO> listRamTemp = new ArrayList<>();
        String text = text_find.toLowerCase();
        listRAM = ramDao.listRam();
        for (RamDTO ram : listRAM) {
            String maRam = String.valueOf(ram.getMaRam()).toLowerCase();
            String dungLuongRam = String.valueOf(ram.getDungLuongRam()).toLowerCase();
            if (maRam.contains(text) || dungLuongRam.contains(text)) {
                listRamTemp.add(ram);
            }
        }
        return listRamTemp;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.RomDAO;
import DTO.RomDTO;
import java.util.ArrayList;

/**
 *
 * @author kiman
 */
public class RomBUS {
    private RomDAO RomDao=new RomDAO();
    private ArrayList<RomDTO> listROM=new ArrayList<>();
    public RomBUS(){
        listROM=RomDao.listRom();
    }
    public ArrayList<RomDTO> listROM(){
        return listROM;
    }
    public int getIndexByID(int maRom){
        int i=0;
        int vitri=-1;
        while(vitri==-1&&i<listROM.size()){
            if(listROM.get(i).getMaRom()==maRom)
                vitri=i;
            else
                i++;
        }
        return vitri;
    }
    public int insertRom(int dungLuongRom){
        int check=RomDao.insertRom(new RomDTO(dungLuongRom));
        if(check==1)
            listROM=RomDao.listRom();
        return check;
    }
    public int updateRom(RomDTO rom){
        int check=RomDao.updateRom(rom);
        if(check==1)
            listROM=RomDao.listRom();
        return check;
    }
    public int deleteRom(int maRom){
        int check=RomDao.deleteRom(maRom);
        if(check==1)
            listROM=RomDao.listRom();
        return check;
    }
    public int getDungLuongRombyID(int maRom){
        return listROM.get(getIndexByID(maRom)).getDungLuongRom();
    }
    public int getIDByDungLuongRom(int dungLuongRom) {
        for (RomDTO rom : listROM) {
            if (rom.getDungLuongRom() == dungLuongRom) {
                return rom.getMaRom();
            }
        }
        return -1; // nếu không tìm thấy
    }
    public boolean checkDup(int dungLuongRom){
        boolean check=true;
        int i=0;
        while(i<listROM.size()&&check){
            if(listROM.get(i).getDungLuongRom()==dungLuongRom)
                check=false;
            else
                i++;
        }
        return check;
    }
}

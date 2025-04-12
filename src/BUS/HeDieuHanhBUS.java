/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.HeDieuHanhDAO;
import DTO.HeDieuHanhDTO;
import java.util.ArrayList;

/**
 *
 * @author kiman
 */
public class HeDieuHanhBUS {
    private HeDieuHanhDAO hdhDao =new HeDieuHanhDAO();
    private ArrayList<HeDieuHanhDTO> listHDH=new ArrayList<>();
    public HeDieuHanhBUS(){
        listHDH=hdhDao.listHDH();
    }
    public ArrayList<HeDieuHanhDTO> listHDH(){
        return this.listHDH;
    }
    public int getIndexByID(int maHDH){
        int i=0;
        int vitri=-1;
        while(i<listHDH.size()&&vitri==-1){
            if(listHDH.get(i).getMaHDH()==maHDH){
                vitri=i;
        }else{
                i++;
        }
    }
        return vitri;
    }
    public int insertHeDieuHanh(String name){
        HeDieuHanhDTO th=new HeDieuHanhDTO(name);
        int check=hdhDao.insertHeDieuHanh(th);
        if(check==1){
            listHDH=hdhDao.listHDH();
        }
        return check;
    }
    public int updateHeDieuHanh(HeDieuHanhDTO hdh){
        int check=hdhDao.updateHDH(hdh);
        if(check==1){
            listHDH=hdhDao.listHDH();
        }
        return check;
    }
    public int deleteThuongHieu(int maHDH){
        int check=hdhDao.deleteHDH(maHDH);
        if(check==1){
            listHDH=hdhDao.listHDH();
        }
        return check;
    }
    public String getTenByMaTH(int maTH){
        return listHDH.get(getIndexByID(maTH)).getTenHDH();
    }
    public boolean checkDup(String name){
        boolean check=true;
        int i=0;
        while(i<listHDH.size()&&check){
            if(listHDH.get(i).getTenHDH().toLowerCase().equals(name.toLowerCase())){
                check=false;
        }
            else{
                i++;
            }
        }
        return check;
    }
}

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
    HeDieuHanhDAO hdhDao =new HeDieuHanhDAO();
    ArrayList<HeDieuHanhDTO> listHDH=new ArrayList<>();
    public HeDieuHanhBUS(){
        listHDH=hdhDao.listHDH();
    }
    public ArrayList<HeDieuHanhDTO> listHDH(){
        listHDH=hdhDao.listHDH();
        return this.listHDH;
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
    public int getIndexByID(int maHDH) {
        ArrayList<HeDieuHanhDTO> arrlistHDH =hdhDao.arrlistHDH();
        int i = 0;
        int vitri = -1;
        while (i < arrlistHDH.size() && vitri == -1) {
            if (arrlistHDH.get(i).getMaHDH() == maHDH) {
                vitri = i;
            } else {
                i++;
            }
        }
        return vitri;
    }
    public int getIDByTenHDH(String tenHDH){
        ArrayList<HeDieuHanhDTO> arrayListHDH=hdhDao.arrlistHDH();
        for(HeDieuHanhDTO hdh : arrayListHDH){
            if(hdh.getTenHDH().equals(tenHDH))
                return hdh.getMaHDH();
        }
        return -1;
    }
    public String getTenByMaHDH(int maHDH){
        ArrayList<HeDieuHanhDTO> arrlistHDH =hdhDao.arrlistHDH();
        int index = getIndexByID(maHDH);
        if (index == -1) {
            return null;
        }
        return arrlistHDH.get(index).getTenHDH();
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
    public ArrayList<HeDieuHanhDTO> timKiem(String text_find) {
        ArrayList<HeDieuHanhDTO> listHDHTemp = new ArrayList<>();
        String text = text_find.toLowerCase();
        listHDH = hdhDao.listHDH();
        for (HeDieuHanhDTO hdh : listHDH) {
            String maHDH = String.valueOf(hdh.getMaHDH()).toLowerCase();
            String tenHDH = hdh.getTenHDH().toLowerCase();
            if (maHDH.contains(text) || tenHDH.contains(text)) {
                listHDHTemp.add(hdh);
            }
        }
        return listHDHTemp;
    }
}

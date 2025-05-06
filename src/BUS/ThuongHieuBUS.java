/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ThuongHieuDAO;
import DTO.ThuongHieuDTO;
import java.util.ArrayList;

/**
 *
 * @author kiman
 */
public class ThuongHieuBUS {
    private final ThuongHieuDAO thDAO =new ThuongHieuDAO();
    private ArrayList<ThuongHieuDTO> listTH=new ArrayList<>();
    public ThuongHieuBUS(){
        listTH=thDAO.listThuongHieu();
    }
    public ArrayList<ThuongHieuDTO> listTH(){
        return this.listTH;
    }
    public int insertThuongHieu(String name){
        ThuongHieuDTO th=new ThuongHieuDTO(name);
        int check=thDAO.insertThuongHieu(th);
        if(check==1){
            listTH=thDAO.listThuongHieu();
        }
        return check;
    }
    public int updateThuongHieu(ThuongHieuDTO th){
        int check=thDAO.updateThuongHieu(th);
        if(check==1){
            listTH=thDAO.listThuongHieu();
        }
        return check;
    }
    public int deleteThuongHieu(int maTH){
        int check=thDAO.deleteThuongHieu(maTH);
        if(check==1){
            listTH=thDAO.listThuongHieu();
        }
        return check;
    }
    public int getIndexByID(int maTH) {
        ArrayList<ThuongHieuDTO> arrlistTH=thDAO.arrlistTH();
        int i = 0;
        int vitri = -1;
        while (i < arrlistTH.size() && vitri == -1) {
            if (arrlistTH.get(i).getMaThuongHieu() == maTH) {
                vitri = i;
            } else {
                i++;
            }
        }
        return vitri;
    }

    public int getIDByTenTH(String tenTH) {
        ArrayList<ThuongHieuDTO> arrlistTH=thDAO.arrlistTH();
        for (ThuongHieuDTO th : arrlistTH) {
            if (th.getTenThuongHieu().equals(tenTH)) {
                return th.getMaThuongHieu();
            }
        }
        return -1;
    }

    public String getTenByMaTH(int maTH) {
        ArrayList<ThuongHieuDTO> arrlistTH=thDAO.arrlistTH();
        int index = getIndexByID(maTH);
        if (index == -1) {
            return null;
        }
        return arrlistTH.get(index).getTenThuongHieu();
    }
    public boolean checkDup(String name){
        boolean check=true;
        int i=0;
        while(i<listTH.size()&&check){
            if(listTH.get(i).getTenThuongHieu().toLowerCase().equals(name.toLowerCase())){
                check=false;
        }
            else{
                i++;
            }
        }
        return check;
    }
    public ArrayList<ThuongHieuDTO> timKiem(String text_find) {
        ArrayList<ThuongHieuDTO> listTHTemp = new ArrayList<>();
        String text = text_find.toLowerCase();
        listTH = thDAO.listThuongHieu();
        for (ThuongHieuDTO th : listTH) {
            String maTH = String.valueOf(th.getMaThuongHieu()).toLowerCase();
            String tenTH = th.getTenThuongHieu().toLowerCase();
            if (maTH.contains(text) || tenTH.contains(text)) {
                listTHTemp.add(th);
            }
        }
        return listTHTemp;
    }
}

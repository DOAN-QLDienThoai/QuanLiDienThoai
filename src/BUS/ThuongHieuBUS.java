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
    public int getIndexByID(int maTH){
        int i=0;
        int vitri=-1;
        while(i<listTH.size()&&vitri==-1){
            if(listTH.get(i).getMaThuongHieu()==maTH){
                vitri=i;
        }else{
                i++;
        }
    }
        return vitri;
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
    public String getTenByMaTH(int maTH){
        return listTH.get(getIndexByID(maTH)).getTenThuongHieu();
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
}

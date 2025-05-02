package BUS;

import java.util.ArrayList;
import DAO.KhachHangDAO;
import DTO.KhachHangDTO;

public class KhachHangBUS {
    private KhachHangDAO khachHangDAO;
    private ArrayList<KhachHangDTO> listKH=new ArrayList<>();
    public KhachHangBUS() {
        khachHangDAO = new KhachHangDAO();
    }

    public ArrayList<KhachHangDTO> layTatCaKhachHang() {
        return khachHangDAO.listKh();
    }
    public int getIndexByID(String maKH){
        listKH=khachHangDAO.listKh();
        int i=0;
        int vitri=-1;
        while(i<listKH.size()&&vitri==-1){
            if(listKH.get(i).getID().equals(maKH)){
                vitri=i;
            }else{
                i++;
            }
        }
        return vitri;
    }
    public String getTenKHByID(String maKH) {
        listKH = khachHangDAO.listKh();
        int index = getIndexByID(maKH);
        if (index == -1) {
            return null;
        }
        return listKH.get(index).getName();
    }
}

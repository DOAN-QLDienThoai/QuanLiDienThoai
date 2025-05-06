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
        ArrayList<KhachHangDTO> arrlistKH = khachHangDAO.arrlistKH();
        int i=0;
        int vitri=-1;
        while(i<arrlistKH.size()&&vitri==-1){
            if(arrlistKH.get(i).getID().equals(maKH)){
                vitri=i;
            }else{
                i++;
            }
        }
        return vitri;
    }
    public String getTenKHByID(String maKH) {
        ArrayList<KhachHangDTO> arrlistKH = khachHangDAO.arrlistKH();
        int index = getIndexByID(maKH);
        if (index == -1) {
            return null;
        }
        return arrlistKH.get(index).getName();
    }
}

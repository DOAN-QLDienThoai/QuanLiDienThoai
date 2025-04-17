/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ChiTietPhieuNhapDAO;
import DTO.ChiTietPhieuNhapDTO;
import java.util.ArrayList;

/**
 *
 * @author kiman
 */
public class ChiTietPhieuNhapBUS {
    private ChiTietPhieuNhapDAO ctpnDao=new ChiTietPhieuNhapDAO();
    private ArrayList<ChiTietPhieuNhapDTO> listCTPN=new ArrayList<>();
    public ChiTietPhieuNhapBUS(){
        this.listCTPN=ctpnDao.listCTPN();
    }
    public int insertCTPN(ChiTietPhieuNhapDTO ctpn) {
        int check = ctpnDao.insertChiTietPhieuNhap(ctpn);
        if (check == 1) {
            listCTPN = ctpnDao.listCTPN();
        }
        return check;
    }

    public int updateCTPN(ChiTietPhieuNhapDTO ctpn) {
        int check = ctpnDao.updateChiTietPhieuNhap(ctpn);
        if (check == 1) {
            listCTPN = ctpnDao.listCTPN();
        }
        return check;
    }

    public int deleteCTPN(String maPN, int maPB) {
        int check = ctpnDao.deleteChiTietPhieuNhap(maPN, maPB);
        if (check == 1) {
            listCTPN = ctpnDao.listCTPN();
        }
        return check;
    }

    public ArrayList<ChiTietPhieuNhapDTO> listCTPN() {
        return listCTPN;
    }
    //Lấy vị trí 1 đối tượng chi tiết phiếu nhập thông qua mã Phiếu Nhập, mã Phiên Bản
    public int getIndexByID(String maPN, int maPB) {
        for (int i = 0; i < listCTPN.size(); i++) {
            ChiTietPhieuNhapDTO ctpn = listCTPN.get(i);
            if (ctpn.getMaPhieuNhap().equals(maPN) && ctpn.getMaPB() == maPB) {
                return i;
            }
        }
        return -1;
    }
    //Lấy 1 đối tượng chi tiết phiếu nhập thông qua mã Phiếu Nhập, mã Phiên Bản
    public ChiTietPhieuNhapDTO getCTPNByID(String maPN, int maPB) {
        int index = getIndexByID(maPN, maPB);
        if (index != -1) {
            return listCTPN.get(index);
        }
        return null;
    }
    //Lấy danh sách đối tượng chi tiết phiếu nhập thông qua mã Phiếu Nhập
    public ArrayList<ChiTietPhieuNhapDTO> getArrListCTPNByMaPN(String maPN){
        return ctpnDao.listCTPNByMaPN(maPN);
    }
}

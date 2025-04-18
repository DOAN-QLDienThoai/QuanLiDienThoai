package BUS;

import java.util.ArrayList;
import DAO.KhachHangDAO;
import DTO.KhachHangDTO;

public class KhachHangBUS {
    private KhachHangDAO khachHangDAO;

    public KhachHangBUS() {
        khachHangDAO = new KhachHangDAO();
    }

    public ArrayList<KhachHangDTO> layTatCaKhachHang() {
        return khachHangDAO.listKh();
    }
}

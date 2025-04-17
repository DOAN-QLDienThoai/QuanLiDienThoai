/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DienThoaiDAO;
import DTO.DienThoaiDTO;
import java.util.ArrayList;

/**
 *
 * @author kiman
 */
public class DienThoaiBUS {
    private DienThoaiDAO dtDao=new DienThoaiDAO();
    public static ArrayList<DienThoaiDTO> listDT=new ArrayList<>();
    public DienThoaiBUS(){
    }
    public ArrayList<DienThoaiDTO> listDT(){
        this.listDT=dtDao.listDT();
        return listDT;
    }
    public int insertDienThoai(DienThoaiDTO dt){
        int check=dtDao.insertDienThoai(dt);
        if(check==1){
            listDT=dtDao.listDT();
        }
        return check;
    }
    public int updateDienThoai(DienThoaiDTO dt){
        int check=dtDao.updateDienThoai(dt);
        if(check==1){
            listDT=dtDao.listDT();
        }
        return check;
    }
    public int deleteDienThoai(int maDT){
        int check=dtDao.deleteDienThoai(maDT);
        if(check==1){
            listDT=dtDao.listDT();
        }
        return check;
    }
    public int updateSoLuongTon(int maPB,int soLuong){
        int check=dtDao.updateSoLuongTonDienThoai(maPB, soLuong);
        if(check==1){
            listDT=dtDao.listDT();
        }
        return check;
    }
    public int getIndexByID(int maDT){
        int i=0;
        int vitri=-1;
        while(i<listDT.size()){
            if(listDT.get(i).getMaDT()==maDT&&vitri==-1){
                vitri=i;
            }
            else{
                i++;
            }
        }
        return vitri;
    }
    public String getTenDTByID(int maDT){
        return listDT.get(getIndexByID(maDT)).getTenDT();
    }
    public DienThoaiDTO layThongTinTheoMa(String maDT) {
    return new DienThoaiDAO().layTheoMa(maDT);
    }
    public int getIDbyIndex(int index) {
        ArrayList<DienThoaiDTO> list = listDT(); // lấy danh sách điện thoại
        if (index >= 0 && index < list.size()) {
            return list.get(index).getMaDT();
        }
        return -1; // hoặc ném exception nếu cần
    }
    public ArrayList<DienThoaiDTO> timKiem(String text,String type){
        String find_text=text.toLowerCase();
        ArrayList<DienThoaiDTO> listDTFilter=new ArrayList<>();
        for(DienThoaiDTO dt : listDT){
            String maDT=String.valueOf(dt.getMaDT()).toLowerCase();
            String kichThuocMan=String.valueOf(dt.getKichThuocMan()+" inch").toLowerCase();
            String dungLuongPin=String.valueOf(dt.getDungLuongPin()+"mAh").toLowerCase();
            switch (type){
                case "Tất cả":
                    if(dt.getTenDT().toLowerCase().contains(find_text)||dt.getChipXuLy().toLowerCase().contains(find_text)
                       ||maDT.contains(find_text)||kichThuocMan.contains(find_text)||dungLuongPin.contains(find_text)
                       )
                        listDTFilter.add(dt);
                    break;
                case "Tên điện thoại":
                    if(dt.getTenDT().toLowerCase().contains(find_text))
                        listDTFilter.add(dt);
                    break;
                case "Mã điện thoại":
                    if(maDT.contains(find_text))
                        listDTFilter.add(dt);
                    break;
                case "Kích thước màn":
                    if(kichThuocMan.contains(find_text))
                        listDTFilter.add(dt);
                    break;
                case "Dung lượng pin":
                    if(dungLuongPin.contains(find_text))
                        listDTFilter.add(dt);
                    break;
                case "Chip xử lý":
                    if(dt.getChipXuLy().toLowerCase().contains(find_text))
                        listDTFilter.add(dt);
                    break;
            }
        }
        return listDTFilter;
    }
}
